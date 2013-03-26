package pl.spot.dbk.points.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spot.dbk.points.Constants;
import pl.spot.dbk.points.server.hib.Item;
import pl.spot.dbk.points.server.hib.SalePoint;
import pl.spot.dbk.points.server.hib.User;
import pl.spot.dbk.points.server.service.ItemService;
import pl.spot.dbk.points.server.service.RoleService;
import pl.spot.dbk.points.server.service.SalePointService;
import pl.spot.dbk.points.server.service.UserService;

/** Controller for populating a form with editing data and persisting the edits.
 * 
 * @author K.Olejniczak */
@Controller
@RequestMapping(value = Constants.ADMIN + "uno/*")
public class AdminUpdateController {
    @Autowired
    public UserService userService;
    @Autowired
    public RoleService roleService;
    @Autowired
    public SalePointService spService;
    @Autowired
    public ItemService itemService;

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @ModelAttribute("item")
    public Item getItem() {
        return new Item();
    }

    @ModelAttribute("sp")
    public SalePoint getSP() {
        return new SalePoint();
    }

    @RequestMapping(value = "/{type}/{id}", method = RequestMethod.GET)
    public ModelAndView prepareDetails(@PathVariable("type") String type, @PathVariable("id") String id,
            HttpSession session) {
        ModelAndView mv = null;
        try {
            if (Constants.SALE.contains(type)) {
                mv = new ModelAndView(Constants.ADMIN);

            }
            if (Constants.USER.contains(type)) {
                mv = new ModelAndView(Constants.USER + "edit");
                mv.addObject("object", userService.get(id));
                mv.addObject("points", userService.getPoints(id));
                mv.addObject("roles", roleService.list());
                mv.addObject("sps", spService.list());
            }
            if (Constants.ITEM.contains(type)) {
                mv = new ModelAndView(Constants.ITEM + "edit");
                mv.addObject("object", itemService.get(id));
            }
            if (Constants.SP.contains(type)) {
                mv = new ModelAndView(Constants.SP + "edit");
                mv.addObject("object", spService.get(id));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = Constants.USER + "{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("user") User user, @PathVariable("id") String id, HttpSession session) {
        ModelAndView mv = null;
        try {
            user.setRole(roleService.getRole(user.getRole_id()));
            user.setRegisterPoint(spService.get(user.getRegisterPoint_id()));
            if (user.getId_u() == 0) {
                user.setId_u(id);
            }
            userService.update(user);
            mv = new ModelAndView(Constants.USER + "edit");
            mv.addObject("object", userService.get(id));
            mv.addObject("points", userService.getPoints(id));
            mv.addObject("roles", roleService.list());
            mv.addObject("sps", spService.list());

        } catch (Exception e) {
            e.printStackTrace();
        }
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = Constants.ITEM + "{id}", method = RequestMethod.POST)
    public ModelAndView updateItem(@ModelAttribute("item") Item item, @PathVariable("id") String id, HttpSession session) {
        ModelAndView mv = null;
        try {
            mv = new ModelAndView(Constants.ITEM + "edit");
            if (item.getId_i() == 0) {
                item.setId_i(id);
            }
            itemService.update(item);
            mv.addObject("object", itemService.get(id));

        } catch (Exception e) {
            e.printStackTrace();
        }
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }

    @RequestMapping(value = Constants.SP + "{id}", method = RequestMethod.POST)
    public ModelAndView updateSalePoint(@ModelAttribute("sp") SalePoint sp, @PathVariable("id") String id,
            HttpSession session) {
        ModelAndView mv = null;
        try {
            mv = new ModelAndView(Constants.SP + "edit");
            if (sp.getId_sp() == 0) {
                sp.setId_sp(id);
            }
            spService.update(sp);
            mv.addObject("object", spService.get(id));

        } catch (Exception e) {
            e.printStackTrace();
        }
        User u = (User) session.getAttribute(Constants.USER);
        mv.addObject("hello", u.getName() + " " + u.getSurname());
        return mv;
    }
}