package cn.struts.upload.no1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class MyFile extends ActionSupport{
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<File> myfile;
	private List<String> myfileContentType;
	private List<String> myfileFileName;
	
	private List<String> desc;
	@Override
	public String execute() throws Exception {
		System.out.println(myfile);
		System.out.println(myfileContentType);
		System.out.println(myfileFileName);
		
		System.out.println(desc.size()+desc.get(0));
		
		for (int i = 0; i < myfile.size(); i++) {
			FileInputStream in = new FileInputStream(myfile.get(i));
			FileOutputStream out = new FileOutputStream("C:/Users/lx/Desktop/"+myfileFileName.get(i));
			
			byte[] buffer = new byte[1024];
			int len = in.read(buffer);
			while(len!=-1){
				out.write(buffer, 0, len);
				len = in.read(buffer);
				out.flush();
			}
			out.close();
			in.close();
		}
		
		return super.execute();
	}
	public List<File> getMyfile() {
		return myfile;
	}
	public void setMyfile(List<File> myfile) {
		this.myfile = myfile;
	}
	public List<String> getMyfileContentType() {
		return myfileContentType;
	}
	public void setMyfileContentType(List<String> myfileContentType) {
		this.myfileContentType = myfileContentType;
	}
	public List<String> getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(List<String> myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	public List<String> getDesc() {
		return desc;
	}
	public void setDesc(List<String> desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "MyFile [myfile=" + myfile + ", myfileContentType=" + myfileContentType + ", myfileFileName="
				+ myfileFileName + ", desc=" + desc + "]";
	}
}
