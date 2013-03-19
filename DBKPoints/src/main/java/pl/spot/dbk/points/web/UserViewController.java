package pl.spot.dbk.points.web;

import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.CommonUtil;
import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.Basket;
import pl.spot.dbk.points.server.hib.Item;
import pl.spot.dbk.points.server.hib.Order;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.InvoiceService;
import pl.spot.dbk.points.server.service.ItemService;
import pl.spot.dbk.points.server.service.OrderService;

@Controller
@RequestMapping(value = Constants.USER + "**")
public class UserViewController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView prepareMainView(HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.USER + "main");
        User u = (User) session.getAttribute(Constants.USER);

        int points = invoiceService.getPointsByUser(u.getId_u());

        mv.addObject("points", points);
        mv.addObject("avPoints", points - u.getBlocked_points());
        mv.addObject("list", itemService.list());
        return mv;
    }

    @RequestMapping(value = "/basket", method = RequestMethod.POST)
    public ModelAndView addItemToBasket(HttpServletRequest req, HttpServletResponse res, HttpSession session) {

        ModelAndView mv = prepareMainView(session);
        User u = (User) session.getAttribute(Constants.USER);
        Order o = (Order) session.getAttribute(Constants.ORDER);
        Item i = itemService.get(req.getParameter("id"));

        int amount = new Integer(req.getParameter("amount"));

        if (invoiceService.getPointsByUser(u.getId_u()) <= i.getCost() * amount) {
            mv.addObject("err", true);
            mv.addObject("errMessage", "Niewystarczająca ilość punktów!");
            return mv;
        }
        if (o == null) {
            o = new Order();
            o.setDate(CommonUtil.getCurrTimestamp());
            o.setUser(u);
        }
        @SuppressWarnings("unchecked")
        ArrayList<Basket> basket = (ArrayList<Basket>) session.getAttribute("basket");
        if (basket == null) {
            basket = new ArrayList<Basket>();
        }
        basket.size();
        Basket newItemInBasket = new Basket();
        newItemInBasket.setId_order(o);
        newItemInBasket.setId_item(i);
        newItemInBasket.setAmount(amount);
        basket.add(newItemInBasket);
        u.setBlocked_points(u.getBlocked_points() + (i.getCost() * amount));
        o.setBasketItems(new HashSet<Basket>(basket));

        session.setAttribute("basket", basket);
        session.setAttribute(Constants.ORDER, o);
        session.setAttribute(Constants.USER, u);

        int points = invoiceService.getPointsByUser(u.getId_u());

        mv.addObject("points", points);
        mv.addObject("avPoints", points - u.getBlocked_points());
        mv.addObject("list", itemService.list());
        return mv;
    }

    @RequestMapping(value = "/basket/show", method = RequestMethod.POST)
    public ModelAndView prepareBasketView(HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.USER + "basket");
        User u = (User) session.getAttribute(Constants.USER);
        Order o = (Order) session.getAttribute(Constants.ORDER);

        @SuppressWarnings("unchecked")
        ArrayList<Basket> basket = (ArrayList<Basket>) session.getAttribute("basket");
        ArrayList<Basket> items = new ArrayList<Basket>();

        for (Basket b : basket) {
            boolean exists = false;
            for (Basket i : items) {
                if (b.getId_item().getId_i() == i.getId_item().getId_i()) {
                    exists = true;
                    int indx = items.indexOf(i);
                    i.setAmount(i.getAmount() + b.getAmount());
                    items.set(indx, i);
                }
            }
            if (!exists) {
                items.add(b);
            }
        }
        o.setBasketItems(new HashSet<Basket>(items));
        session.setAttribute("basket", items);
        session.setAttribute(Constants.ORDER, o);
        session.setAttribute(Constants.USER, u);
        mv.addObject("items", items);
        return mv;
    }

    @RequestMapping(value = "/basket/order", method = RequestMethod.POST)
    public ModelAndView orderBasket(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        User u = (User) session.getAttribute(Constants.USER);
        Order o = (Order) session.getAttribute(Constants.ORDER);
        ArrayList<Basket> basket = (ArrayList<Basket>) session.getAttribute("basket");
        
        orderService.create(o);

        return mv;
    }
}
