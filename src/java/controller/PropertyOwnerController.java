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
import model.dao.PropertyOwnerDao;
import model.pojo.BuyerRenter;
import model.pojo.EstateAgent;
import model.pojo.Offer;
import model.pojo.PropertyOwner;
import model.pojo.PropertyPosts;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sawan_000
 */
public class PropertyOwnerController {

    @RequestMapping(value = "/propertyOwnerView")
    public String adminMVC(Model model, PropertyOwner propertyOwner, HttpSession session) {
        if (session.getAttribute("user") != null) {
            PropertyOwner userLoggedIn = (PropertyOwner) session.getAttribute("user");
            int userId = userLoggedIn.getPropertyOwnerId();
            String ownerId = String.valueOf(userId);
            List<PropertyOwner> propertyOwnerDetails = PropertyOwnerDao.propertyOwnerDetails(ownerId);
            model.addAttribute("propertyOwnerList", propertyOwnerDetails);
            return "propertyOwnerView";

        } else {
            return "propertyOwnerView";
        }
    }
    
    @RequestMapping(value = "/ownersList")
    public String ownersName(Model model, PropertyOwner propertyOwner, HttpSession session) {
        if (session.getAttribute("user") != null) {
           EstateAgent userLoggedIn = (EstateAgent) session.getAttribute("user");
            //int userId = userLoggedIn.getPropertyOwnerId();
            //String ownerId = String.valueOf(userId);
            List<PropertyOwner> propertyOwners = PropertyOwnerDao.getOwners();
            System.out.println(propertyOwners);
            model.addAttribute("propertyOwnersList", propertyOwners);
           
            return "ownersList";

        } else {
            return "ownersList";
        }
    }
    @RequestMapping(value = "/newProperty")
    public String ownersID(Model model, PropertyOwner propertyOwner, HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
           EstateAgent userLoggedIn = (EstateAgent) session.getAttribute("user");
            //int userId = userLoggedIn.getPropertyOwnerId();
            String ownerId = request.getParameter("owners");
            System.out.println(ownerId);
            List<PropertyOwner> propertyOwners = PropertyOwnerDao.getOwners();
            
            model.addAttribute("propertyOwnersList", propertyOwners);
           
            return "ownersList";

        } else {
            return "ownersList";
        }
    }
    @RequestMapping(value = "/ownerOffers", method = RequestMethod.GET) 
    public String property (Model view, HttpServletRequest request, HttpSession session){
        
        PropertyOwner userLoggedIn = (PropertyOwner) session.getAttribute("user");
        int ownerId = userLoggedIn.getPropertyOwnerId();
        
         try {
            List<Offer> offers = PropertyOwnerDao.getOwnerOffer(ownerId);
            view.addAttribute("owner_offers", offers);

            //List<PropertyPosts> ps = PropertyOwnerDao.getPropertyBuyer(ownerId);
            //view.addAttribute("ownerpropertyposts", ps);
        } catch (Exception e) {
     }  
     return "propertyOwnerView";  
    } 
    
    @RequestMapping(value = "/acceptOffer", method = RequestMethod.POST) 
    public String OfferAccept(Model view, HttpServletRequest request,HttpSession session){
        PropertyOwner userLoggedIn = (PropertyOwner) session.getAttribute("user");
        int ownerId = userLoggedIn.getPropertyOwnerId();
        int decision = Integer.parseInt(request.getParameter("offerdecision"));
       int offer = Integer.parseInt(request.getParameter("offeridval"));
       int propertyId=Integer.parseInt(request.getParameter("propertyidval"));
       PropertyOwnerDao.decideOffer(offer,decision);
       PropertyOwnerDao.updateProperty(propertyId);
        List<Offer> offers = PropertyOwnerDao.getOwnerOffer(ownerId);
            view.addAttribute("owner_offers", offers);

           // List<PropertyPosts> ps = BuyerRenterDao.getPropertyBuyer(ownerId);
            //view.addAttribute("ownerpropertyposts", ps);
        return "propertyOwnerView";
        
    
    }
    @RequestMapping(value = "/rejectOffer", method = RequestMethod.POST) 
    public String OfferReject(Model view, HttpServletRequest request,HttpSession session){
        PropertyOwner userLoggedIn = (PropertyOwner) session.getAttribute("user");
        int ownerId = userLoggedIn.getPropertyOwnerId();
        int decision = Integer.parseInt(request.getParameter("offerdecision"));
       int offer = Integer.parseInt(request.getParameter("offeridval2"));
        PropertyOwnerDao.decideOffer(offer,decision);
        List<Offer> offers = PropertyOwnerDao.getOwnerOffer(ownerId);
            view.addAttribute("owner_offers", offers);

           // List<PropertyPosts> ps = BuyerRenterDao.getPropertyBuyer(ownerId);
            //view.addAttribute("ownerpropertyposts", ps);
        return "propertyOwnerView";
        
    
    }
    
    
}
