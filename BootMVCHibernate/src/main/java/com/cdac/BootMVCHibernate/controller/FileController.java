package com.cdac.BootMVCHibernate.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import com.cdac.BootMVCHibernate.entity.FileModel;

@Controller
public class FileController {

	
	@Autowired
	StandardServletMultipartResolver multipleResolver;
	
	@RequestMapping(method = RequestMethod.GET, value="/uploadFile")
	public void prepareFile(Model data) {
		System.out.println("sdqas");
		data.addAttribute("fileUpload", new FileModel());
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/uploadFile")
	public String uploadFile(@ModelAttribute("fileUpload")FileModel fileModel) {
		System.out.println("111");
		try(FileOutputStream fileOut = new FileOutputStream("E:\\Batch1\\" + fileModel.getFileAttachment().getOriginalFilename())){
			fileOut.write(fileModel.getFileAttachment().getBytes());
			return "welcome";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}
}
