package ru.geekbrains.java4.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.geekbrains.java4.springboot.domain.PostEntity;
import ru.geekbrains.java4.springboot.form.Post;
import ru.geekbrains.java4.springboot.repository.PostRepository;

import javax.validation.Valid;

@Controller
public class Home {

	@Autowired
	private PostRepository 	postRepository; 
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Post post) {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addNewPost(@Valid Post post, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "index";
		}
		postRepository.save(new PostEntity(post.getTitle(), post.getContent()));
		model.addAttribute("posts", postRepository.findAll());
		return "redirect:result";
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showAllPosts(Model model) {
		model.addAttribute("posts", postRepository.findAll());
		return "result";
	}
}
