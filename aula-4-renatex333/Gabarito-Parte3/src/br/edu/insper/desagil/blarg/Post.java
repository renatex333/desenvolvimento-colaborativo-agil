package br.edu.insper.desagil.blarg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	private Date date;
	private String title;
	private String content;
	private List<String> tags;
	private List<Comment> comments;

	public Post(String title, String content) {
		this.date = new Date();
		this.title = title;
		this.content = content;
		this.tags = new ArrayList<>();
		this.comments = new ArrayList<>();
	}

	public Date getDate() {
		return this.date;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean contains(String tag) {
		return this.tags.contains(tag);
	}

	public void addTag(String tag) {
		this.tags.add(tag);
	}

	public void addComment(String author, String content) {
		this.comments.add(new Comment(author, content));
	}
}
