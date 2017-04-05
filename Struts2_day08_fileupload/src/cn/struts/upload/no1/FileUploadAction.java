package cn.struts.upload.no1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File oneFile;
	private String oneFileContentType;
	private String oneFileFileName;
	private String fileDesc;
	
	
	
	public File getOneFile() {
		return oneFile;
	}
	public void setOneFile(File oneFile) {
		this.oneFile = oneFile;
	}
	public String getOneFileContentType() {
		return oneFileContentType;
	}
	public void setOneFileContentType(String oneFileContentType) {
		this.oneFileContentType = oneFileContentType;
	}



	public String getOneFileFileName() {
		return oneFileFileName;
	}



	public void setOneFileFileName(String oneFileFileName) {
		this.oneFileFileName = oneFileFileName;
	}
	public String getFileDesc() {
		return fileDesc;
	}
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}
	
	
	@Override
	public String execute() throws Exception {
		System.out.println(oneFile);
		System.out.println(oneFileContentType);
		System.out.println(oneFileFileName);
		System.out.println(fileDesc);
		
		ServletContext sc = ServletActionContext.getServletContext();
		String path  = sc.getRealPath("/files/"+oneFileFileName);
		System.out.println(path);
		FileInputStream in = new FileInputStream(oneFile);
		FileOutputStream out = new FileOutputStream(path);
		
		byte[] buffer = new byte[1024];
		int len = in.read(buffer);
		while(len!=-1){
			out.write(buffer, 0, len);
			len = in.read(buffer);
			out.flush();
		}
		out.close();
		in.close();
		return super.execute();
	}
}
