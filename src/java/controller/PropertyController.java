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
import model.dao.LoginServiceDao;
import model.dao.PropertyDao;
import model.dao.RegistrationDao;
import model.pojo.BuyerRenter;
import model.pojo.EstateAgent;
import model.pojo.PropertyPosts;
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
public class PropertyController {

    @RequestMapping(value = "/newProperty", method = RequestMethod.POST)
    public String newPropertyEntry(Model model, HttpServletRequest request, HttpSession session) {

        //if (buyerRenter != null && buyerRenter.getBuyerRenterUname()!= null && buyerRenter.getPassword()!= null) {
        int garage=0,garden=0,parking=0;
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        String title = request.getParameter("property_title");
        String description = request.getParameter("property_desc");
        String type = request.getParameter("property_type");
        String address = request.getParameter("property_address");
        int bathroom_count = Integer.parseInt(request.getParameter("property_bathroom_count"));
        String postcode = request.getParameter("property_postcode");
       int bedroom_count= Integer.parseInt(request.getParameter("property_bedroom_count"));
        String furnishing_status = request.getParameter("property_furnishing");
        
        String garageAvailablity = request.getParameter("garage_availability");
        String gardenAvailablity = request.getParameter("garden_availability");
        String parkingAvailablity = request.getParameter("parking_availability");
        
        if(garageAvailablity.equals("yes")){
            garage=1;
        }
        if(gardenAvailablity.equals("yes")){
            garden=1;
        }
        if(parkingAvailablity.equals("yes")){
            parking=1;
        }
        Double size=Double.parseDouble(request.getParameter("property_size"));
        String adType=request.getParameter("ad_type");
        int price = Integer.parseInt(request.getParameter("property_price"));
        int posting_status=1;
        Timestamp post_date = Timestamp.valueOf(ft.format(dNow));
        String image = "";
        String ownerId = request.getParameter("owners");
        
        EstateAgent userLoggedIn = (EstateAgent) session.getAttribute("user");
         int userId = userLoggedIn.getEstateAgentId();
        
        PropertyPosts propertyPosts;
        //propertyPosts = new PropertyPosts(ownerId, userId,title, description, type,address, postcode, bedroom_count, bathroom_count, furnishing_status,garage, garden, parking, size, adType, price, posting_status,post_date, image);
        //PropertyDao.saveUser(propertyPosts);

        return "redirect:home.htm";

    }
    
    @RequestMapping(value="/searchProperty", method = RequestMethod.POST)
    public String searchProperty(Model model, @ModelAttribute("PropertyPosts") PropertyPosts propertyPosts,HttpServletRequest request, HttpSession session){
            
        //if (buyerRenter != null && buyerRenter.getBuyerRenterUname()!= null && buyerRenter.getPassword()!= null) {
          if(1==1){  
            String address = request.getParameter("searchPropertyInput");
           
            
            List<PropertyPosts> propertyPostsDetails = PropertyDao.getProperty(address);
                        

            if (propertyPostsDetails == null) {
                
                model.addAttribute("error", "No results found");
                return "buyerRenterView";
            } else {
                
                //PropertyPosts userLog = propertyPostsDetails.get(0);
                session.setAttribute("property", propertyPostsDetails);
                
                
                    return "buyerRenterView";
                
            }
        } else {
            return "redirect:index";
        }    

    }
    
}
