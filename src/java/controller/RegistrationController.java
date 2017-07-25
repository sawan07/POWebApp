/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.LoginServiceDao;
import model.dao.RegistrationDao;
import model.pojo.BuyerRenter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sawan_000
 */
@Controller
public class RegistrationController {

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registration(Model model, HttpServletRequest request, HttpSession session) {

        //if (buyerRenter != null && buyerRenter.getBuyerRenterUname()!= null && buyerRenter.getPassword()!= null) {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String buyerRenterUname = request.getParameter("buyer_renter_uname");
        String email = request.getParameter("email");
        int date = Integer.parseInt(request.getParameter("date"));
        String gender = request.getParameter("gender");
        System.out.println(gender);
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        Timestamp singnUpDate = Timestamp.valueOf(ft.format(dNow));
        String image = "";
        BuyerRenter buyerRenter = new BuyerRenter(name, password,gender, address, telephone, email, date,singnUpDate,  image,buyerRenterUname);
        RegistrationDao.saveUser(buyerRenter);

        return "redirect:home.htm";

    }

}
