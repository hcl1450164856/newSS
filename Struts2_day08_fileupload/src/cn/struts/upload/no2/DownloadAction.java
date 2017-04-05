package cn.struts.upload.no2;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//结果类型
	private String contentType;
	//下载的文件长度
	private long contentLength;
	//设定Content-DisPonsition 响应头， 指定响应是一个文件下载类型，一般取值为attachmen;filename="document.pdf"
	private String contentDisposition;
	//指定文件输入流getter定义的那个属性的名字，默认为inputStream
	private InputStream inputStream;
	
	
	public String getContentType() {
		return contentType;
	}
	public long getContentLength() {
		return contentLength;
	}
	public String getContentDisposition() {
		return contentDisposition;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	
	@Override
	public String execute() throws Exception {
		// 确认各个成员变量的值
		
		
		contentType="text/html";
		contentDisposition="attachment;filename="+"hidden.html";
		ServletContext sc =ServletActionContext.getServletContext();
		String path =sc.getRealPath("/files/hidden.html");
		System.out.println(path);
		inputStream = new FileInputStream(path);
		
		contentLength = inputStream.available();
	
		return "success";
	}
	
	
}
