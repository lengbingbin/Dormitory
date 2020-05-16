package zhb.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable{
	
	private int S_id;
	private String S_name;
	private String sex;
	private Date birthday;
	private String qq;
	private String mobile;
	private int dormid;
	private int classid;
	public int getS_id() {
		return S_id;
	}
	public void setS_id(int s_id) {
		S_id = s_id;
	}
	public String getS_name() {
		return S_name;
	}
	public void setS_name(String s_name) {
		S_name = s_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getDormid() {
		return dormid;
	}
	public void setDormid(int dormid) {
		this.dormid = dormid;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [S_id=" + S_id + ", S_name=" + S_name + ", sex=" + sex
				+ ", birthday=" + birthday + ", qq=" + qq + ", mobile="
				+ mobile + ", dormid=" + dormid + ", classid=" + classid + "]";
	}
	
	
	

}
