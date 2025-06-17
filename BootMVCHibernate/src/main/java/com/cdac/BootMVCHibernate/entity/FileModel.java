package com.cdac.BootMVCHibernate.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileModel {
	
	MultipartFile fileAttachment;

	public MultipartFile getFileAttachment() {
		return fileAttachment;
	}

	public void setFileAttachment(MultipartFile fileAttachment) {
		this.fileAttachment = fileAttachment;
	}

	
	
}
