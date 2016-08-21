package info.kapable.app.ComptesPerso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 
@Controller
@RequestMapping("/")
/**
 * Simple controller to handle monitoring request
 * @author Johanna
 *
 */
public class WelcomeController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String sayWelcome(ModelMap model) {
        return "dashboard";
    }
}
