package ru.geekbrains.java4.springboot.domain;

import javax.persistence.*;

@Entity
//@Table(name = "post_entity", schema = "sa")
public class PostEntity {
	
	public PostEntity() {}
	
	public PostEntity(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

//	@Column(name = "cont") //
	private String content;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
