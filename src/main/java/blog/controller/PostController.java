package blog.controller;

import blog.model.Post;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @RequestMapping("/posts")
    public String getAllPosts(Model model) {
        List<Post> list = postService.findAll();
        model.addAttribute("posts", list);

        return "/posts/posts";
    }

    @RequestMapping("posts/create")
    public String createPost() {
        return "/posts/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPostPage(Post post) {
        post.setId(System.currentTimeMillis() % 1000);
        postService.create(post);
        return "redirect:/posts";
    }


}
