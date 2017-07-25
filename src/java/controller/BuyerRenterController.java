/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.BuyerRenterDao;
import model.dao.LoginServiceDao;
import model.pojo.BuyerRenter;
import model.pojo.Offer;
import model.pojo.PropertyPosts;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sawan_000
 */
public class BuyerRenterController {

    @RequestMapping(value = "/buyerRenterView")
    public String userMVC(Model model, BuyerRenter buyuerRenter, HttpSession session) {
        if (session.getAttribute("user") != null) {
            BuyerRenter userLoggedIn = (BuyerRenter) session.getAttribute("user");
            int userId = userLoggedIn.getBuyerRenterId();
            String buyerId = String.valueOf(userId);

//           List<BuyerRenter> buyerRenterDetails = LoginServiceDao.getLogin(userLoggedIn);
//                String BuyerRenterUserId = userLoggedIn.toString();
             //   System.out.println("//////////////" + buyerId);
            //buyuerRenter = (BuyerRenter) session.getAttribute("verifyUser");
            List<BuyerRenter> buyerRenterDetails = BuyerRenterDao.buyerRenterDetails(buyerId);
           // System.out.println("//////////////" + buyerRenterDetails);
            

            model.addAttribute("buyerRenterList", buyerRenterDetails);
            return "buyerRenterView";

        } else {
            return "home";
        }
    }
    
    @RequestMapping(value = "/userOffers", method = RequestMethod.GET) 
    public String property (Model view, HttpServletRequest request, HttpSession session){
        
        BuyerRenter userLoggedIn = (BuyerRenter) session.getAttribute("user");
        int buyerId = userLoggedIn.getBuyerRenterId();
        
         try {
            List<Offer> offers = BuyerRenterDao.getOfferBuyer(buyerId);
            view.addAttribute("user_offers", offers);

            List<PropertyPosts> ps = BuyerRenterDao.getPropertyBuyer(buyerId);
            view.addAttribute("myof", ps);
        } catch (Exception e) {
     }  
     return "userOffers";  
    } 
    
    @RequestMapping(value = "/acceptedOffers", method = RequestMethod.GET) 
    public String acceptedOfferList (Model view, HttpServletRequest request, HttpSession session){
        
        BuyerRenter userLoggedIn = (BuyerRenter) session.getAttribute("user");
        int buyerId = userLoggedIn.getBuyerRenterId();
        
         try {
            List<Offer> offers = BuyerRenterDao.getAcceptedOfferBuyer(buyerId);
            view.addAttribute("user_accepted_offers", offers);

            List<PropertyPosts> ps = BuyerRenterDao.getPropertyBuyer(buyerId);
            view.addAttribute("myof", ps);
        } catch (Exception e) {
     }  
     return "acceptedOffers";  
    } 
    
    @RequestMapping(value = "/editOffer", method = RequestMethod.POST) 
    public String MyOffer(Model view, HttpServletRequest request,HttpSession session){
        
        BuyerRenter userLoggedIn = (BuyerRenter) session.getAttribute("user");
        int buyerId = userLoggedIn.getBuyerRenterId();
        int offer = Integer.parseInt(request.getParameter("offeridval"));
        Double amount = Double.parseDouble(request.getParameter("offerAmount"));
        String currency = request.getParameter("Currency");
        double convertedAmount=convertCurrency(currency, amount);
        BuyerRenterDao brDao = new BuyerRenterDao();
        brDao.updateOffer(offer, convertedAmount, currency);
        List<Offer> offers = BuyerRenterDao.getOfferBuyer(buyerId);
            view.addAttribute("user_offers", offers);

            List<PropertyPosts> ps = BuyerRenterDao.getPropertyBuyer(buyerId);
            view.addAttribute("myof", ps);
        return "userOffers";
    }
    
   @RequestMapping(value = "/deleteOffer", method = RequestMethod.POST) 
    public String MyOfferDelete(Model view, HttpServletRequest request,HttpSession session){
        BuyerRenter userLoggedIn = (BuyerRenter) session.getAttribute("user");
        int buyerId = userLoggedIn.getBuyerRenterId();
       int offer = Integer.parseInt(request.getParameter("offeridval2"));
        BuyerRenterDao.deleteOffer(offer);
        List<Offer> offers = BuyerRenterDao.getOfferBuyer(buyerId);
            view.addAttribute("user_offers", offers);

            List<PropertyPosts> ps = BuyerRenterDao.getPropertyBuyer(buyerId);
            view.addAttribute("myof", ps);
        return "userOffers";
        
    
    }
    
    private static double convertCurrency(java.lang.String currencyName, double amountToConvert) {
        wsclient.SOAPWebSerice_Service service = new wsclient.SOAPWebSerice_Service();
        wsclient.SOAPWebSerice port = service.getSOAPWebSericePort();
        return port.convertCurrency(currencyName, amountToConvert);
    }
    
}
