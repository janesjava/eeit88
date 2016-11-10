package org.iiiedu.eeit88.health.manager.help.model;

import java.io.Serializable;


public class HelpBean implements Serializable{

	private Integer id;
	private String keyword;
	private String question;
	private String answer;
	private Boolean helpStatus;
	
	@Override
	public String toString() {
		return "HelpBean [id=" + id + ", keyword=" + keyword + ", question=" + question + ", answer=" + answer
				+ ", helpStatus=" + helpStatus + "]";
	}
	
	
	
	public HelpBean(Integer id, String keyword, String question, String answer, Boolean helpStatus) {
		super();
		this.id = id;
		this.keyword = keyword;
		this.question = question;
		this.answer = answer;
		this.helpStatus = helpStatus;
	}
	public HelpBean() {
		super();
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Boolean getHelpStatus() {
		return helpStatus;
	}
	public void setHelpStatus(Boolean helpStatus) {
		this.helpStatus = helpStatus;
	}
	
	
}
