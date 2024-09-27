package br.edu.insper.desagil.appsup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChatTest {
	private Chat c;

	@BeforeEach
	public void setUp() {
		c = new Chat();
	}

	@Test
	public void testVazio() {
		assertEquals("<main></main>", c.renderAll());
	}

	@Test
	public void testTresMensagens() {
		c.post(new Message("maria", "hello world"));
		c.post(new Message("jose", "goodbye universe"));
		c.post(new Message("mariana", "something else"));
		assertEquals(
			"<main>" +
			"<p><strong>maria:</strong> hello world</p>" +
			"<p><strong>jose:</strong> goodbye universe</p>" +
			"<p><strong>mariana:</strong> something else</p>" +
			"</main>",
		c.renderAll());
	}

	@Test
	public void testTresImagens() {
		c.post(new ImageMessage("maria", "hello world", "hello.png"));
		c.post(new ImageMessage("jose", "goodbye universe", "goodbye.jpg"));
		c.post(new ImageMessage("mariana", "something else", "something.gif"));
		assertEquals(
			"<main>" +
			"<figure><p><strong>maria:</strong> hello world</p><img src=\"hello.png\"></figure>" +
			"<figure><p><strong>jose:</strong> goodbye universe</p><img src=\"goodbye.jpg\"></figure>" +
			"<figure><p><strong>mariana:</strong> something else</p><img src=\"something.gif\"></figure>" +
			"</main>",
		c.renderAll());
	}

	@Test
	public void testTresVideos() {
		c.post(new VideoMessage("maria", "hello world", "hello.mp4"));
		c.post(new VideoMessage("jose", "goodbye universe", "goodbye.mkv"));
		c.post(new VideoMessage("mariana", "something else", "something.avi"));
		assertEquals(
			"<main>" +
			"<figure><p><strong>maria:</strong> hello world</p><video src=\"hello.mp4\"></figure>" +
			"<figure><p><strong>jose:</strong> goodbye universe</p><video src=\"goodbye.mkv\"></figure>" +
			"<figure><p><strong>mariana:</strong> something else</p><video src=\"something.avi\"></figure>" +
			"</main>",
		c.renderAll());
	}

	@Test
	public void testTresDiferentes() {
		c.post(new Message("maria", "hello world"));
		c.post(new ImageMessage("jose", "goodbye universe", "goodbye.jpg"));
		c.post(new VideoMessage("mariana", "something else", "something.avi"));
		assertEquals(
			"<main>" +
			"<p><strong>maria:</strong> hello world</p>" +
			"<figure><p><strong>jose:</strong> goodbye universe</p><img src=\"goodbye.jpg\"></figure>" +
			"<figure><p><strong>mariana:</strong> something else</p><video src=\"something.avi\"></figure>" +
			"</main>",
		c.renderAll());
	}
}
