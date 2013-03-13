package pl.spot.dbk.points.web;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.UserService;

@Controller
@RequestMapping("/login/**")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "failed", method = RequestMethod.GET)
    public ModelAndView prepareLoginFailedForm() {
        ModelAndView m = new ModelAndView("ss/failed");
        return m;
    }

    @RequestMapping(value = "success", method = RequestMethod.GET)
    public ModelAndView prepareLoginSuccessForm(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // System.out.println("HELLO! " + userDetails.getAuthorities().toString() + "?"
        // + userDetails.getAuthorities().toString().contains("ADMINISTRATOR"));
        //
        // if (userDetails.getAuthorities().toString().contains("ADMINISTRATOR")) { return new ModelAndView(
        // "redirect:/admin/"); }

        User u = userService.get(userDetails.getUsername());
        u.setLast_login(new Timestamp((new java.util.Date()).getTime()));
        userService.update(u);
        session.setAttribute(Constants.USER, u);
        
        switch (u.getRole().getId_r()) {
        case 1:
            return new ModelAndView("redirect:" + Constants.USER);
        case 11:
            return new ModelAndView("redirect:" + Constants.SELLER);
        case 111:
            return new ModelAndView("redirect:" + Constants.ADMIN);
        }

        return null;
    }

}
