package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.dto.AuthorDTO;

public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	public String id;
	public String title;
	public String body;
	public Date date;
	public AuthorDTO author;
	
	public Post()
	{
		
	}

	public Post(String id, String title, String body, Date date, AuthorDTO author) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", date=" + date + ", author=" + author + "]";
	}
}
