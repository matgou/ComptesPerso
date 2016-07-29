package info.kapable.app.ComptesPerso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;

 
@Controller
@RequestMapping("/status")
/**
 * Simple controller to handle monitoring request
 * @author Johanna
 *
 */
public class statusController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String sayStatus(ModelMap model) {
        model.addAttribute("greeting", "Application ComptesPerso is OK");
        return "monitoring";
    }
 
    @RequestMapping(value="/ping", method = RequestMethod.GET)
    public String sayPong(ModelMap model) {
        model.addAttribute("greeting", "pong");
        return "monitoring";
    }

    @RequestMapping(value="/time", method = RequestMethod.GET)
    public String sayTime(ModelMap model) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        model.addAttribute("greeting", sdf.format(cal.getTime()) );
        return "monitoring";
    }
}
