package pl.spot.dbk.points.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.UserService;
import pl.spot.dbk.points.web.util.Constants;

@Controller
@RequestMapping(value = "/admin/**")
public class AdminViewController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView prepareMainView() {
        ModelAndView mv = new ModelAndView(Constants.ADMIN+"main");
        User u = userService.get((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }
}
