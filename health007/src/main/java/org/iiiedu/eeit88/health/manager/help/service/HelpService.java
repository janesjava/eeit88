package org.iiiedu.eeit88.health.manager.help.service;

import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.manager.help.model.HelpBean;
import org.iiiedu.eeit88.health.manager.help.model.HelpDAO;
import org.iiiedu.eeit88.health.manager.help.model.dao.HelpDAOJdbc;

public class HelpService {
	private HelpDAO helpDao = new HelpDAOJdbc();

	//測試
	public static void main (String args[]){
//		HelpService service = new HelpService();		
//		List<HelpBean> beans = service.select(null);
//		System.out.println("beans= "+beans);
		
//		HelpDAOJdbc helpdao = new HelpDAOJdbc();
//		HelpBean bean = service.insert(helpdao.select(6));
//		System.out.println(bean);
		
//		service.update(helpdao.update("keyword7", "question7", "answer7", 7));
//		System.out.println(helpdao.select(7));
		
//		service.changeStatus(helpdao.changeStatus(true, 7));
//		System.out.println(helpdao.select(7));
	}
	
	
	public List<HelpBean> select(HelpBean bean){	//搜尋全部
		List<HelpBean> result = null;
		if(bean!=null && bean.getId()!=0) {
			HelpBean temp = helpDao.select(bean.getId());
			if(temp!=null){
				result = new ArrayList<HelpBean>();
				result.add(temp);
			}
		}else {
			result = helpDao.select();
		}		
		return result;		
	}
	
	public HelpBean insert(HelpBean bean){	//增加資料
		HelpBean result = null;
		if(bean!=null){
			result = helpDao.insert(bean);
		}		
		return result;		
	}
	
	public HelpBean update(HelpBean bean){	//修改資料
		HelpBean result = null;
		if(bean!=null){
			result = helpDao.update(bean.getKeyword(), bean.getQuestion(),
					bean.getAnswer(), bean.getId());
			System.out.println(result);
		}
		return result;
	}
	
	public HelpBean changeStatus(HelpBean bean){	//修改狀態
		HelpBean result = null;
		if(bean!=null){
			result = helpDao.changeStatus(bean.getHelpStatus(), bean.getId());
		}
		return result;
	}
	
	public String textReplace(String answer){
		String replacedAnswer = answer.replace("\r\n", "<br/>");
		return replacedAnswer;	
	}

	
	
}
