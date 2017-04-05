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
	//�������
	private String contentType;
	//���ص��ļ�����
	private long contentLength;
	//�趨Content-DisPonsition ��Ӧͷ�� ָ����Ӧ��һ���ļ��������ͣ�һ��ȡֵΪattachmen;filename="document.pdf"
	private String contentDisposition;
	//ָ���ļ�������getter������Ǹ����Ե����֣�Ĭ��ΪinputStream
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
		// ȷ�ϸ�����Ա������ֵ
		
		
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
