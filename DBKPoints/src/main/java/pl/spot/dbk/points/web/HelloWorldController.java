package pl.spot.dbk.points.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/** Simple index page controller serving hello.jsp file */
@Controller
@RequestMapping("/welcome")
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    /** Simply serves hello.jsp
     * 
     * @return view with name 'hello' */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home() {
        logger.info("Welcome home!");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.ENGLISH);

        ModelAndView model = new ModelAndView("hello");

        String formattedDate = dateFormat.format(date);

        model.addObject("serverTime", formattedDate);

        return model;
    }

}
