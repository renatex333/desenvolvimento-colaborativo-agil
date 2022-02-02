package br.edu.desagil.aula5;

public abstract class MediaMessage extends Message{
	private String src;
	
	public MediaMessage(String user, String text, String src) {
		super(user, text);
		this.src = src;
	}
	
	public String getSrc() {
		return src;
	}
	
	@Override
	public String render() {
		return "<figure>" + super.render() + preRender() + "</figure>";
	}
	
	public abstract String preRender();
	
}
