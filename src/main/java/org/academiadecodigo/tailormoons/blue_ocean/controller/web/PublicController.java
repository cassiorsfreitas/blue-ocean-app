package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.academiadecodigo.tailormoons.blue_ocean.dto.RegisterCustomerDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.Role;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.RoleEnum;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.User;
import org.academiadecodigo.tailormoons.blue_ocean.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class PublicController {

    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET, path = {"", "index", "index.html"})
    public String index() {
        return getView("index");
    }


    @RequestMapping(method = RequestMethod.GET, path = {"splash", "splash.html"})
    public String splash() {
        return getView("splash");
    }


    @RequestMapping(method = RequestMethod.GET, path = {"login", "login.html"})
    public String login() {
        return getView("login");
    }


    @RequestMapping(method = RequestMethod.GET, path = {"signup", "signup.html"})
    public String signup(Model model) {
        model.addAttribute("customer", new RegisterCustomerDto());
        return getView("signup");
    }


    @RequestMapping(method = RequestMethod.POST, path = "registration")
    public String addUser(@Valid @ModelAttribute("customer") RegisterCustomerDto registerCustomerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return getView("signup");
        }

        if (userService.hasUser(registerCustomerDto.getUsername().trim())) {
            redirectAttributes.addFlashAttribute("userExist", "User already exist");
            return getView("signup");
        }

        userService.add(registerCustomerDto);

        return "redirect:/login";
    }


    @RequestMapping(method = RequestMethod.GET, path = {"forgot-password", "forgot-password.html"})
    public String forgotPassword() {
        return getView("forgot-password");
    }


    private String getView(String viewDefault) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // TODO: 20/12/2020 Verify autentication before going to pages
        /*
        if (!authentication.isAuthenticated()) {
            return "redirect:/lobby";
        }
        */
        return viewDefault;
    }

}
