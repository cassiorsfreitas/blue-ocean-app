package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.academiadecodigo.tailormoons.blue_ocean.services.CustomerService;
import org.academiadecodigo.tailormoons.blue_ocean.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin-panel")
public class AdminController {

    private CustomerService customerService;

    private UserService userService;


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET, path = {"", "/"})
    public String getAdminPanel() {

        // Check for permissions

        return "admin-panel";
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/remove/{id}")
    public String removeCustomer(@PathVariable("id") Integer id) {

        // Check for permissions

        // Use BindingResult to show errors instead of if

        if (userService.hasUser(id)) {
            userService.delete(id);
        }

        // Use RedirectAttributes to show some util message ("Saved successfully")

        return "admin-panel";
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/password-reset/{id}")
    public String resetPassword(@PathVariable("id") Integer id) {

        // Check for permissions

        // Use BindingResult to show errors instead of if

        if (userService.hasUser(id)) {
            userService.resetPassword(id);
        }

        // Use RedirectAttributes to show some util message ("Saved successfully")

        return "admin-panel";
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/permissions")
    public String updatePermissions(@RequestAttribute("id") Integer id, @RequestAttribute("role") String role) {

        if (userService.hasUser(id)) {
            userService.updateRole(id, role);
        }

        return "admin-panel";
    }

}
