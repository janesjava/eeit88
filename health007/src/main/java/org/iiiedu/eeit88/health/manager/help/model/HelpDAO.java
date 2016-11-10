package org.iiiedu.eeit88.health.manager.help.model;

import java.util.List;

public interface HelpDAO {

	public HelpBean select(Integer id);
	public List<HelpBean> select();	
	public HelpBean insert(HelpBean bean);
	public HelpBean update(String keyword, String question, String answer, Integer id);
	public HelpBean changeStatus(Boolean helpStatus, Integer id);
	
}
