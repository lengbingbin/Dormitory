package zhb.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Damagething implements Serializable{
	
	private Integer Da_id;
	private String damagestation;
	private String damagetime;
	private String isfixed;
	private int dormid;
	
	public Integer getDa_id() {
		return Da_id;
	}
	public void setDa_id(Integer da_id) {
		Da_id = da_id;
	}
	public String getDamagestation() {
		return damagestation;
	}
	public void setDamagestation(String damagestation) {
		this.damagestation = damagestation;
	}
	public String getDamagetime() {
		return damagetime;
	}
	public void setDamagetime(String damagetime) {
		this.damagetime = damagetime;
	}
	public String getIsfixed() {
		return isfixed;
	}
	public void setIsfixed(String isfixed) {
		this.isfixed = isfixed;
	}
	public int getDormid() {
		return dormid;
	}
	public void setDormid(int dormid) {
		this.dormid = dormid;
	}
	@Override
	public String toString() {
		return "Damagething [Da_id=" + Da_id + ", damagestation="
				+ damagestation + ", damagetime=" + damagetime + ", isfixed="
				+ isfixed + ", dormid=" + dormid + "]";
	}
	
	
	
	

}
