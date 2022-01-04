package com.example.exappspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UsersController {

    private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/add")
    public String hello(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age) {

        User user = new User(firstName, lastName, age);
        userRepository.add(user);

        return "redirect:/users";


    }

    // localhost:8080/add?firstName=aa&lastName=bb&age=15

    @ResponseBody
    @RequestMapping("/users")
    public String list() {
        List<User> userList = userRepository.getAll();
        String result = "";

        for (User user : userList) {
            if (user.getFirstName().isEmpty()) {
                return "err";
            } else
                return "success";
        }


        return result;
    }

}
