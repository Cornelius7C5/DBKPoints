package pl.spot.dbk.points.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.CommonUtil;
import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.Invoice;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.InvoiceService;
import pl.spot.dbk.points.server.service.SalePointService;
import pl.spot.dbk.points.server.service.UserService;

/**
 * 
 * @author K.Olejniczak
 *
 */
@Controller
@RequestMapping(value = Constants.SALE + "**")
public class SalesController {

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
    public ModelAndView prepareView(HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.SALE + "main");
        User u = (User) session.getAttribute(Constants.USER);

        mv.addObject("sps", spService.list());
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView prepareAddSalesView(@ModelAttribute("invoice") Invoice invoice, HttpSession session) {
        ModelAndView mv = null;
        User u = (User) session.getAttribute(Constants.USER);

        if (u.isAdmin()) {
            mv = new ModelAndView("redirect:" + Constants.ADMIN + "sales");
        } else if (u.getRole().getId_r() == 11) {
            mv = new ModelAndView("redirect:" + Constants.SELLER + "sales");
        }

        invoice.setSalePoint(spService.get(invoice.getInvoiceSalePoint_id()));
        invoice.setUser(userService.get(invoice.getUser_id()));
        invoice.setSeller(u);
        invoice.setOrder_registration(CommonUtil.getCurrTimestamp());
        invoiceService.create(invoice);
        return mv;
    }
}
