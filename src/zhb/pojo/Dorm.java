package zhb.pojo;

import java.io.Serializable;

public class Dorm implements Serializable{
	
	private Integer id;
	private Integer D_id;
	private String dormadmin;
	private int total;
	private int used;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getD_id() {
		return D_id;
	}
	public void setD_id(Integer d_id) {
		D_id = d_id;
	}
	public String getDormadmin() {
		return dormadmin;
	}
	public void setDormadmin(String dormadmin) {
		this.dormadmin = dormadmin;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	@Override
	public String toString() {
		return "Dorm [id=" + id + ", D_id=" + D_id + ", dormadmin=" + dormadmin
				+ ", total=" + total + ", used=" + used + "]";
	}
	
	
	
	

}
