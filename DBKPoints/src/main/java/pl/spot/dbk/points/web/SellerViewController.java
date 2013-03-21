package pl.spot.dbk.points.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.Invoice;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.InvoiceService;
import pl.spot.dbk.points.server.service.SalePointService;
import pl.spot.dbk.points.server.service.UserService;

@Controller
@RequestMapping(value = Constants.SELLER + "**")
public class SellerViewController {
    @Autowired
    private SalePointService spService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    UserService userService;

    @ModelAttribute("invoice")
    public Invoice getInvoice() {
        return new Invoice();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView prepareMain(HttpServletRequest req, HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.SELLER + "main");
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView prepareMainWithChecked(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView(Constants.SELLER + "main");
        mv.addObject("check", true);
        int id = new Integer(req.getParameter("id"));
        int points = invoiceService.getPointsByUser(id);
        User u = userService.get(id);

        mv.addObject("points", points);
        mv.addObject("avPoints", points - u.getBlocked_points());
        mv.addObject("blPoints", u.getBlocked_points());
        return mv;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView prepareUsersView() {
        ModelAndView mv = new ModelAndView("redirect:" + Constants.USER + "main");
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView prepareNewSaleView() {
        ModelAndView mv = new ModelAndView(Constants.SELLER + "main");
        mv.addObject("add", true);
        mv.addObject("sps", spService.list());
        return mv;
    }

}
