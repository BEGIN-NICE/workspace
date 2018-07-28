package com.itheima.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public String upload() throws IOException {
		String path = ServletActionContext.getServletContext().getRealPath("upload/");
		uploadFileName = UUID.randomUUID().toString().replace("-", "")+"_"+uploadFileName;
		File file = new File(path,uploadFileName);
		FileUtils.copyFile(upload, file);
		return "success";
	}
}
