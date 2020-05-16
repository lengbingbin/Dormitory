package zhb.pojo;

import java.io.Serializable;

public class Viewvis implements Serializable{
	
	private int id;
	private String visitorname;
	private String S_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVisitorname() {
		return visitorname;
	}
	public void setVisitorname(String visitorname) {
		this.visitorname = visitorname;
	}
	public String getS_name() {
		return S_name;
	}
	public void setS_name(String s_name) {
		S_name = s_name;
	}
	public Viewvis() {
		super();
	}
	@Override
	public String toString() {
		return "Viewvis [id=" + id + ", visitorname=" + visitorname
				+ ", S_name=" + S_name + "]";
	}
	
	

}
