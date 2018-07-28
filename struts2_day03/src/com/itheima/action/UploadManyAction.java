package com.itheima.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadManyAction {
	private List<File> upload;
	private List<String> uploadContentType;
	private List<String> uploadFileName;
	public List<File> getUpload() {
		return upload;
	}
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}
	public List<String> getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public List<String> getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public String uploads() throws IOException {
		String path = ServletActionContext.getServletContext().getRealPath("upload/");
		for (int i=0;i < upload.size();i++) {
			String filename = uploadFileName.get(i);
			filename = UUID.randomUUID().toString().replace("-", "")+"_"+filename;
			File file = new File(path,filename);
			FileUtils.copyFile(upload.get(i), file);
		}
		return "success";
	}
}
