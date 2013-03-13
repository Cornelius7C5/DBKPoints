package pl.spot.dbk.points.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.RoleService;
import pl.spot.dbk.points.server.service.UserService;

@Controller
@RequestMapping(value = "/admin/**")
public class AdminViewController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView prepareMainView() {
        ModelAndView mv = new ModelAndView(Constants.ADMIN + "main");
        User u = userService.get((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView prepareUsersView() {
        
        ModelAndView mv = new ModelAndView("redirect:/user/main");
//        mv.addObject("isAdmin",userService.get((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).isAdmin());
        return mv;
    }

    @RequestMapping(value = "/prizes", method = RequestMethod.GET)
    public ModelAndView preparePrizesView() {
        return null;
    }

    @RequestMapping(value = "/sp", method = RequestMethod.GET)
    public ModelAndView prepareSalePointsView() {
        return null;
    }

    @RequestMapping(value = "/sales", method = RequestMethod.GET)
    public ModelAndView prepareSalesView() {
        return null;
    }
}
