package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String returnPosts() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String returnPostId(@PathVariable long id) {
            return "view an individual post " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewPosts() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPosts() {
        return "create a new post";
    }



}




//    Create a PostController class. This controller should return strings for the following routes that describe what will ultimately be there.
//        method	url	            description
//        GET	    /posts	        posts index page
//        GET	    /posts/{id}	    view an individual post
//        GET	    /posts/create	view the form for creating a post
//        POST	    /posts/create	create a new post