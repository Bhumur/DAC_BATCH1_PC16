package com.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees") 
@Data // Lombok: Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Lombok: Generates a no-argument constructor
@AllArgsConstructor // Lombok: Generates a constructor with all arguments
@Getter
@Setter
public class Employee {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name = "first_name", nullable = false) 
    private String firstName;

    @Column(name = "last_name", nullable = false) 
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true) 
    private String emailId;
    
    
}
