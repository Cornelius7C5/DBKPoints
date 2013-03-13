package pl.spot.dbk.points.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;

/** Simple index page controller serving hello.jsp file */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    /** Simply serves hello.jsp
     * 
     * @return view with name 'hello' */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("redirect:" + Constants.LOGIN);
    }

}
