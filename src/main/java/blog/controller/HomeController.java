package blog.controller;

import blog.model.Post;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    PostService postService;

    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("...Inside HomeController...");
        List<Post> list = postService.firstThreePosts();
        model.addAttribute("posts", list);
        return "index";
    }
}
