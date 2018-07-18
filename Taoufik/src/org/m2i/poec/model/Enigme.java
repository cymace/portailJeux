package org.m2i.poec.model;

public class Enigme {

	private int id;
	private String question;
	private String reponse;
	private String explication;
	
	public Enigme(int id, String question, String reponse, String explication) {
		super();
		this.id = id;
		this.question = question;
		this.reponse = reponse;
		this.explication = explication;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public String getExplication() {
		return explication;
	}
	public void setExplication(String explication) {
		this.explication = explication;
	}
	@Override
	public String toString() {
		return "Enigme [id=" + id + ", question=" + question + ", reponse=" + reponse + ", explication=" + explication
				+ "]";
	}
	
}
