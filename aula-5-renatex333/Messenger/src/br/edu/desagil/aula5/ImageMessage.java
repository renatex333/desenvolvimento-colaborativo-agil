package br.edu.desagil.aula5;

public class ImageMessage extends MediaMessage {
	
	public ImageMessage(String user, String text, String src) {
		super(user, text, src);
	}
	
	@Override
	public String preRender() {
		return "<img src=\"" + getSrc() + "\">";
	}
	
}
