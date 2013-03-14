package pl.spot.dbk.points.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.service.RoleService;
import pl.spot.dbk.points.server.service.UserService;

@Controller
@RequestMapping(value = Constants.ADMIN + "**")
public class AdminViewController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView prepareMainView() {
        ModelAndView mv = new ModelAndView(Constants.ADMIN + "main");
        return mv;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView prepareUsersView() {
        ModelAndView mv = new ModelAndView("redirect:" + Constants.USER + "main");
        return mv;
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public ModelAndView preparePrizesView() {
        ModelAndView mv = new ModelAndView("redirect:" + Constants.ITEM + "main");
        return mv;
    }

    @RequestMapping(value = "/sp", method = RequestMethod.GET)
    public ModelAndView prepareSalePointsView() {
        ModelAndView mv = new ModelAndView("redirect:" + Constants.SP + "main");
        return mv;
    }

    @RequestMapping(value = "/sales", method = RequestMethod.GET)
    public ModelAndView prepareSalesView() {
        return null;
    }
}
