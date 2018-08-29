package blog.controller;

import blog.form.RegisterNewUser;
import blog.model.User;
import blog.services.PostService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @RequestMapping("users/login")
    private String loginPage(User user) {

        return "users/login";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String login(User user, Model model) {
        boolean validUser = true;
        if (userService.authenticate(user.getUsername(), user.getPasswordHash())) {
            return "redirect:/posts";
        }
        return "redirect:/";
    }

    @RequestMapping("/users/logout")
    public String logout(User user, Model model) {
        model.addAttribute("posts", postService.firstThreePosts());
        return "index";
    }

    @RequestMapping(value = "users/register")
    public String register(User user, Model model) {
        return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerUser(RegisterNewUser registerNewUser) {
        User user = new User();
        user.setUsername(registerNewUser.getUserName());
        user.setPasswordHash(registerNewUser.getPasswordHash());
        user.setFullName(registerNewUser.getFullName());
        userService.registerNewUser(user);
        return "redirect:/";
    }
}
