package com.project.domain;

public class Journal {
	public int id;
	public String title;
	public String content;
	public int userId;
	
	public Journal(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public Journal(int id, String title, String content, int userId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
	}
	

}
