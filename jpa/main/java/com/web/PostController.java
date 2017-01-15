package com.web;

import com.model.Person;
import com.model.Post;
import com.service.PersonService;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PersonService personService;
    private final PostService postService;

    @Autowired
    public PostController(PersonService personService, PostService postService) {
        this.personService = personService;
        this.postService = postService;
    }

    @RequestMapping("")
    public String listPosts( Model model) {
        final Collection<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @RequestMapping("/list/{nickname}")
    public String listPosts(@PathVariable(value="nickname") String nickName, Model model) {
        final Person author = personService.findByNickName(nickName);
        final Collection<Post> posts = postService.findAllByAuthor(author);
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @RequestMapping("/view/{id}")
    public String viewPost(@PathVariable(value="id") Long id, Model model) {
        final Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "post/view";
    }

}
