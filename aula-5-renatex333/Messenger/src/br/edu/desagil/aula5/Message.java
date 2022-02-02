package br.edu.desagil.aula5;

public class Message {
	private String user;
	private String text;
	
	public Message(String user, String text) {
		this.user = user;
		this.text = text;
	}
	
	public String getUser() {
		return this.user;
	}

	public String getText() {
		return this.text;
	}

	public String render() {
		return "<p><strong>" + this.user + "</strong> " + this.text + "</p>";
	}

}
