package pl.spot.dbk.points.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.Order;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.OrderService;
import pl.spot.dbk.points.server.service.StatusService;

/** Adding and managing orders
 * 
 * @author K.Olejniczak */
@Controller
@RequestMapping(value = Constants.ORDER + "**")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public ModelAndView changeOrderStatus(@PathVariable("id") int id, HttpServletRequest req, HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.ORDER + "main");
        orderService.changeStatus(id, new Integer(req.getParameter("status")));
        mv.addObject("orders", orderService.list());
        mv.addObject("statuses", statusService.list());
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView prepareSingleOrderView(@PathVariable("id") int id, HttpServletRequest req, HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.ORDER + "edit");
        Order order = orderService.get(id);

        mv.addObject("order", order);
        mv.addObject("statuses", statusService.list());
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }
}
