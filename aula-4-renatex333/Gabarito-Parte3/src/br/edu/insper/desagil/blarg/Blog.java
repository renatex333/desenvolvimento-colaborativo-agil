package br.edu.insper.desagil.blarg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blog {
	private String name;
	private List<String> tags;
	private List<Post> posts;

	public Blog(String name) {
		this.name = name;
		this.tags = new ArrayList<>();
		this.posts = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTags() {
		return Collections.unmodifiableList(this.tags);
	}

	public List<Post> getPosts() {
		return Collections.unmodifiableList(this.posts);
	}

	public void addPost(String title, String content, List<String> tags) {
		Post post = new Post(title, content);
		for (String tag: tags) {
			post.addTag(tag);
			if (!this.tags.contains(tag)) {
				this.tags.add(tag);
			}
		}
		this.posts.add(post);
	}

	private List<Post> getPostsWithTag(String tag) {
		List<Post> postsWith = new ArrayList<>();
		for (Post post: this.posts) {
			if (post.contains(tag)) {
				postsWith.add(post);
			}
		}
		return postsWith;
	}

	public Map<String, List<Post>> getPostsPerTag() {
		Map<String, List<Post>> postsPerTag = new HashMap<>();
		for (String tag: this.tags) {
			postsPerTag.put(tag, getPostsWithTag(tag));
		}
		return postsPerTag;
	}
}
