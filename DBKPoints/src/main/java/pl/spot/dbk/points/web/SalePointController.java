package pl.spot.dbk.points.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.SalePoint;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.SalePointService;

/** Adding new SalePoints
 * 
 * @author K.Olejniczak */
@Controller
@RequestMapping(value = Constants.SP + "**")
public class SalePointController {

    @Autowired
    SalePointService spService;

    @ModelAttribute("sp")
    public SalePoint getSalePoint() {
        return new SalePoint();
    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public ModelAndView prepareView(HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.SP + "main");
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView addSP(@ModelAttribute("sp") SalePoint sp, ModelMap model) {
        ModelAndView mv = new ModelAndView(Constants.SP + "main");
        spService.create(sp);
        mv.addObject("ok", true);
        mv.addObject("newSP", sp.getName());
        return mv;
    }

}
