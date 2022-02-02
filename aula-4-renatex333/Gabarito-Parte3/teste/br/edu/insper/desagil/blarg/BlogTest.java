package br.edu.insper.desagil.blarg;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class BlogTest {
	private Blog blog;
	
	@Test
	public void adicionaDoisPosts() {

		List<String> tagsUm = new ArrayList<>();
		tagsUm.add("comida");
		tagsUm.add("mcdonalds");
		
		List<String> tagsDois = new ArrayList<>();
		tagsDois.add("comida");
		tagsDois.add("burgerking");

		blog = new Blog("Renatex");
		blog.addPost("PostagemUm", "MemesUm", tagsUm);
		blog.addPost("PostagemDois", "MemesDois", tagsDois);
		
		Map<String, List<Post>> postsPerTag = blog.getPostsPerTag();
		
		assertEquals(3, postsPerTag.size());
		assertEquals(2, postsPerTag.get("comida").size());
		assertEquals(1, postsPerTag.get("mcdonalds").size());
		assertEquals(1, postsPerTag.get("burgerking").size());
		
	}

	

}
