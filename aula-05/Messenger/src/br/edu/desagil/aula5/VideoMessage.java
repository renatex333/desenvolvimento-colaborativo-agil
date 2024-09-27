package br.edu.desagil.aula5;

public class VideoMessage extends MediaMessage {
	
	public VideoMessage(String user, String text, String src) {
		super(user, text, src);
	}
	
	@Override
	public String preRender() {
		return "<video src=\"" + getSrc() + "\">";
	}
}
