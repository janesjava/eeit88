package org.iiiedu.eeit88.health.getimage.model;

import java.util.List;

public interface PicDAO {

	public PicBean select(Integer id);
	public List<PicBean> select();
	public PicBean insert(PicBean bean);
	public PicBean update(String keyword, byte[] pic, Integer id);
	
}
