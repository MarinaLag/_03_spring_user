package by.itclass.controllers;

import by.itclass.model.entities.User;
import by.itclass.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import static by.itclass.constants.AppConst.*;

@Controller
public class UserController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = ALL_USER_URL) //ALL_USER_URL = "/all";
    public String userControllerMethodWhichReturnAllUsers(Model model) {
        var users = service.getAllUsers();
        model.addAttribute(USER_LIST_ATTR, users); //USER_LIST_ATTR = "userList"
        //имя в jsp файле
        return USERS_PAGE; //USERS_PAGE = "users"
    }

    @GetMapping(value = DELETE_USER_URL) //DELETE_USER_URL = "/delete";
    public String deleteUserControllerById(@RequestParam(name = "id") int userId) {
        service.deleteById(userId);
        return INDEX_PAGE;  //INDEX_PAGE = "index";
    }

    @GetMapping(value = "/")
    public String root() {
        return INDEX_PAGE;  //INDEX_PAGE = "index";
    }//  попадем на index страничку

    @GetMapping(value = ADD_USER_URL) //ADD_USER_URL = "/add";
    public ModelAndView addUserFromForm() { //ничего не принимает,но создаст пустой
        var modelAndView = new ModelAndView(ADD_PAGE, USER_ATTR, new User()); // на стронице add создай  пустой user

        return modelAndView;
    }

    @PostMapping(value = SAVE_USER_URL) // SAVE_USER_URL = "/save";
    public String save(@ModelAttribute(name = USER_ATTR) User user) {
        service.add(user);
        return "redirect:" + ALL_USER_URL;
    }


    @GetMapping(value = UPDATE_USER_URL)
    public ModelAndView update(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") int age) {
        return new ModelAndView(UPDATE_PAGE, USER_ATTR, new User(id, name, age));
    }

    @PostMapping(value = "/saveUpdate")
    public String saveUpdate(@ModelAttribute(name = "user") User user){
        service.update(user);
        return "redirect:" + ALL_USER_URL;
    }

}
