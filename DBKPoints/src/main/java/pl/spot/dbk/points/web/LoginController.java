package pl.spot.dbk.points.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login/**")
public class LoginController {

    @RequestMapping(value = "failed", method = RequestMethod.GET)
    public ModelAndView prepareLoginFailedForm() {
        ModelAndView m = new ModelAndView("ss/failed");
        return m;
    }

    @RequestMapping(value = "success", method = RequestMethod.GET)
    public ModelAndView prepareLoginSuccessForm() {
        return new ModelAndView();
    }

}
