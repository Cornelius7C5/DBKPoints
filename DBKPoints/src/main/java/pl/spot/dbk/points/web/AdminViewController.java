package pl.spot.dbk.points.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.Invoice;
import pl.spot.dbk.points.server.service.InvoiceService;
import pl.spot.dbk.points.server.service.ItemService;
import pl.spot.dbk.points.server.service.RoleService;
import pl.spot.dbk.points.server.service.SalePointService;
import pl.spot.dbk.points.server.service.UserService;

@Controller
@RequestMapping(value = Constants.ADMIN + "*")
public class AdminViewController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    private SalePointService spService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private InvoiceService invoiceService;

    @ModelAttribute("invoice")
    public Invoice getInvoice() {
        return new Invoice();
    }

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
        ModelAndView mv = new ModelAndView(Constants.SELLER + "main");
        mv.addObject("add", true);
        mv.addObject("sps", spService.list());
        return mv;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView prepareListings(@RequestParam("type") String type) {
        ModelAndView mv = new ModelAndView(Constants.ADMIN + "list");
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
        // mv.addObject("roles", roleService.list());
        // mv.addObject("sps", spService.list());
        mv.addObject("type", type);
        return mv;
    }

}
