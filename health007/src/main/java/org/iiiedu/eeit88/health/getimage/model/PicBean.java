package org.iiiedu.eeit88.health.getimage.model;

import java.util.Arrays;

public class PicBean {
	private Integer id;
	private String keyword;
	private byte[] pic;
	
	@Override
	public String toString() {
		return "PicBean [id=" + id + ", keyword=" + keyword + ", pic=" + Arrays.toString(pic) + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}	
	
}
