package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.repository.EmployeeRepository;

@Service 
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired 
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true) 
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> 
                new ResourceNotFoundException("Employee not found with id: " + id));
    }

    @Override
    @Transactional 
    public Employee createEmployee(Employee employee) {
    	Optional<Employee> existingEmployee = employeeRepository.findByEmailId(employee.getEmailId());
        if (existingEmployee.isPresent()) {
            throw new ResourceNotFoundException("Employee with email '" + employee.getEmailId() + "' already exists.");
        }
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        if (employeeDetails == null) {
            throw new ResourceNotFoundException("Employee details cannot be null for update.");
        }
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
   
        if (employeeDetails.getFirstName() == null || employeeDetails.getFirstName().trim().isEmpty()) {
            throw new ResourceNotFoundException("First name cannot be null or empty.");
        }
        if (employeeDetails.getLastName() == null || employeeDetails.getLastName().trim().isEmpty()) {
            throw new ResourceNotFoundException("Last name cannot be null or empty.");
        }
        if (employeeDetails.getEmailId() == null || employeeDetails.getEmailId().trim().isEmpty()) {
            throw new ResourceNotFoundException("Email ID cannot be null or empty.");
        }

        existingEmployee.setFirstName(employeeDetails.getFirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setEmailId(employeeDetails.getEmailId()); 
    
        if (!existingEmployee.getEmailId().equals(employeeDetails.getEmailId())) { 
            if (employeeRepository.findByEmailId(employeeDetails.getEmailId()).isPresent()) {
                throw new ResourceNotFoundException("Email '" + employeeDetails.getEmailId() + "' is already taken by another employee.");
            }
        }
        return employeeRepository.save(existingEmployee);
    }

    

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
