/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.mchange.v2.c3p0.impl.C3P0Defaults.password;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.OfferDao;
import model.dao.PropertyDao;
import model.dao.RegistrationDao;
import model.pojo.BuyerRenter;
import model.pojo.Offer;
import model.pojo.PropertyPosts;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sawan_000
 */
public class OfferController {
    @RequestMapping(value = "/saveOffer", method = RequestMethod.POST)
    public String makeOffer(Model model,  HttpServletRequest request, HttpSession session) {
//System.out.println("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        //if (buyerRenter != null && buyerRenter.getBuyerRenterUname()!= null && buyerRenter.getPassword()!= null) {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            BuyerRenter userLoggedIn = (BuyerRenter) session.getAttribute("user");
          int buyerId = userLoggedIn.getBuyerRenterId();
            //int buyerId=1;
        int propertyId=Integer.parseInt(request.getParameter("propertyidval"));
        double amount = Double.parseDouble(request.getParameter("offerAmount"));
        int approval=0;
        String comment="";
        String currency=request.getParameter("Currency");
        String defaultDate="9999-12-30 00:00:00";
        Timestamp approvalDate=Timestamp.valueOf(defaultDate);
        
        double convertedAmount=convertCurrency(currency, amount);
        
        Timestamp currentDate = Timestamp.valueOf(ft.format(dNow));
        
        Offer offer = new Offer(buyerId, propertyId, currentDate, convertedAmount, comment, approval,approvalDate , currency);
        System.out.println(offer);
        OfferDao.makeOffer(offer);

        return "redirect:buyerRenterView.htm";

    }

    private static double convertCurrency(java.lang.String currencyName, double amountToConvert) {
        wsclient.SOAPWebSerice_Service service = new wsclient.SOAPWebSerice_Service();
        wsclient.SOAPWebSerice port = service.getSOAPWebSericePort();
        return port.convertCurrency(currencyName, amountToConvert);
    }
    
    
}
