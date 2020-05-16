package zhb.pojo;

import java.io.Serializable;

public class Score implements Serializable{
	
	private Integer id;
	private int dormid;
	private int score;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getDormid() {
		return dormid;
	}
	public void setDormid(int dormid) {
		this.dormid = dormid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Score [id=" + id + ", dormid=" + dormid + ", score=" + score
				+ "]";
	}
	
	
	
	

}
