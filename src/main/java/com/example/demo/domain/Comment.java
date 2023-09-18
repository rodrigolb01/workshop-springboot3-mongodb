package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.dto.AuthorDTO;

public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private AuthorDTO author;
	
	public Comment()
	{
		
	}

	public Comment(String text, Date date, AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Comment [text=" + text + ", date=" + date + ", author=" + author + "]";
	}
}
