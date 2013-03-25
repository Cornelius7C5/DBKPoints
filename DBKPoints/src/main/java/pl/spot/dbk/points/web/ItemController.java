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
import pl.spot.dbk.points.server.hib.Item;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.ItemService;
/**
 * Adding new Items
 * @author K.Olejniczak
 *
 */
@Controller
@RequestMapping(value = Constants.ITEM + "**")
public class ItemController {

    @Autowired
    ItemService itemService;

    @ModelAttribute("item")
    public Item getUser() {
        return new Item();
    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public ModelAndView prepareView(HttpSession session) {
        ModelAndView mv = new ModelAndView(Constants.ITEM + "main");
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView addItem(@ModelAttribute("item") Item item, ModelMap model) {
        ModelAndView mv = new ModelAndView(Constants.ITEM + "main");
        itemService.create(item);
        mv.addObject("ok", true);
        mv.addObject("newItemName", item.getName());
        mv.addObject("newItemCost", item.getCost());

        return mv;
    }

}
