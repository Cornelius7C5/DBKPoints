package pl.spot.dbk.points.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.Invoice;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.InvoiceService;
import pl.spot.dbk.points.server.service.ItemService;
import pl.spot.dbk.points.server.service.OrderService;
import pl.spot.dbk.points.server.service.SalePointService;
import pl.spot.dbk.points.server.service.StatusService;
import pl.spot.dbk.points.server.service.UserService;

/** Preparation and navigation for the admin main view
 * 
 * @author K.Olejniczak */
@Controller
@RequestMapping(value = Constants.ADMIN + "*")
public class AdminViewController {

    @Autowired
    private UserService userService;
    @Autowired
    private SalePointService spService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StatusService statusService;

    @ModelAttribute("invoice")
    public Invoice getInvoice() {
        return new Invoice();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView prepareMainView(HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.ADMIN + "main");
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView prepareUsersView(HttpSession session) {
        ModelAndView mv = new ModelAndView("redirect:" + Constants.USER + "main");
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        mv.addObject("add", true);
        return mv;
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public ModelAndView preparePrizesView(HttpSession session) {
        ModelAndView mv = new ModelAndView("redirect:" + Constants.ITEM + "main");
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = "/sp", method = RequestMethod.GET)
    public ModelAndView prepareSalePointsView(HttpSession session) {
        ModelAndView mv = new ModelAndView("redirect:" + Constants.SP + "main");
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = "/sales", method = RequestMethod.GET)
    public ModelAndView prepareSalesView(HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.SELLER + "main");
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        mv.addObject("add", true);
        mv.addObject("sps", spService.list());
        return mv;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView prepareOrdersView(HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.SELLER + "main");
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        mv.addObject("add", true);
        mv.addObject("sps", spService.list());
        return mv;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView prepareListings(HttpSession session, @RequestParam("type") String type) {
        User u = (User) session.getAttribute(Constants.USER);
        ModelAndView mv = null;
        if (!type.equals(Constants.ORDER)) {
            mv = new ModelAndView(Constants.ADMIN + "list");
        } else {
            mv = new ModelAndView(Constants.ORDER + "main");
            mv.addObject("orders", orderService.list());
            mv.addObject("statuses", statusService.list());
        }
        try {
            if (type.equals(Constants.SALE)) {
                mv.addObject("list", invoiceService.listAsMetaObject());
            }
            if (type.equals(Constants.USER)) {
                mv.addObject("list", userService.listAsMetaObject());
            }
            if (type.equals(Constants.ITEM)) {
                mv.addObject("list", itemService.listAsMetaObject());
            }
            if (type.equals(Constants.SP)) {
                mv.addObject("list", spService.listAsMetaObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        mv.addObject("type", type);
        return mv;
    }

}
