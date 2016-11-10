package org.iiiedu.eeit88.health.getimage.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.getimage.model.dao.PicDAOJdbc;


public class PicService {
	private PicDAO picDao = new PicDAOJdbc();

	public List<PicBean> select(PicBean bean){	//selectAll
		List<PicBean> result=null;
		if(bean!=null && bean.getId()!=0){
			PicBean temp = picDao.select(bean.getId());
			if(temp!=null){
				result = new ArrayList<PicBean>();
				result.add(temp);
			}
		}else{
			result = picDao.select();
		}
		return result;
	}
	
	public PicBean insert(String keyword, byte[] pic){	//insert
		PicBean result = null;
		if(keyword != null && pic!=null){
			PicBean bean = new PicBean();
			bean.setKeyword(keyword);
			bean.setPic(pic);
			result = picDao.insert(bean);
		}		
		return result;
	}
	
	public PicBean update(String keyword, byte[] pic, Integer id){	//update
		PicBean result = null;
		if(keyword !=null && pic !=null){
			PicBean bean = new PicBean();
			bean.setKeyword(keyword);
			bean.setPic(pic);
			bean.setId(id);
			result = picDao.update(keyword, pic, id);
		}
		return result;
	}
	
	
	//test
	public static void main(String[] args) throws IOException {
		PicService service = new PicService();
		List<PicBean> beans = service.select(null);
		System.out.println(beans);
		
		File finput = new File("C:/Users/Student/Desktop/a01.png");	//檔案
		int size=(int) finput.length();
		byte[] inputPictures = new byte[size];
		FileInputStream fis = new FileInputStream(finput);
		fis.read(inputPictures);
		fis.close();
		
//		service.insert("aaa", inputPictures);
//		service.update("bbb", inputPictures, 2);

	}

}
