package pl.spot.dbk.points.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.RoleService;
import pl.spot.dbk.points.server.service.SalePointService;
import pl.spot.dbk.points.server.service.UserService;

@Controller
@RequestMapping(value = "/user/**")
public class UserController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private SalePointService spService;

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public ModelAndView prepareView(@ModelAttribute("user") User user, ModelMap model) {
        ModelAndView mv = new ModelAndView(Constants.USER + "main");
        mv.addObject("roles", roleService.list());
        mv.addObject("sps", spService.list());
        return mv;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user, ModelMap model) {
        ModelAndView mv = new ModelAndView(Constants.USER + "main");
        user.setRole(roleService.getRole(user.getRole_id()));
        user.setRegisterPoint(spService.get(user.getRegisterPoint_id()));
        userService.create(user);

        mv.addObject("ok", true);
        return mv;
    }

}
