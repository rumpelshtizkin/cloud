package ru.geekbrains.java4.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.java4.springboot.domain.PostEntity;
import ru.geekbrains.java4.springboot.repository.PostRepository;

import java.util.List;

@RestController
public class RestAPI {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public List<PostEntity> showAllPosts() {
       return (List<PostEntity>) postRepository.findAll();
    }

    @RequestMapping(value = "/rest/id/{id}", method = RequestMethod.GET)
    public PostEntity showPostById(@PathVariable Long id) {
        return  postRepository.findOne(id);
    }


    @RequestMapping(value = "/rest/title/{title}", method = RequestMethod.GET)
    public List<PostEntity> showPostByTitle(@PathVariable String title) {
        return  postRepository.findByTitle(title);
    }
}
