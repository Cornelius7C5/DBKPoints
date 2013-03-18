package pl.spot.dbk.points.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.Invoice;
import pl.spot.dbk.points.server.service.SalePointService;

@Controller
@RequestMapping(value = Constants.SELLER + "**")
public class SellerViewController {
    @Autowired
    private SalePointService spService;

    @ModelAttribute("invoice")
    public Invoice getInvoice() {
        return new Invoice();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView prepareMain() {
        ModelAndView mv = new ModelAndView(Constants.SELLER + "main");
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
