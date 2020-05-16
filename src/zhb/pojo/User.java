package zhb.pojo;

public class User {

	private Integer id;
	private String userName;
	private String password;
	private int permission;
	private int age;
	private String sex;
	private Integer u_id;
	
	
	public Integer getu_id() {
		return u_id;
	}
	public void setu_id(Integer u_id) {
		this.u_id = u_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", permission=" + permission + ", age=" + age
				+ ", sex=" + sex + ", u_id=" + u_id + "]";
	}
	
	
	
}
