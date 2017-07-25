/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.LoginServiceDao;
import model.pojo.BuyerRenter;
import model.pojo.EstateAgent;
import model.pojo.PropertyOwner;
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
public class LoginController {
     @RequestMapping(value="/home")
     public String homeview(){
         
         return "home";
         
         
     }
     @RequestMapping(value="/verifyUser", method = RequestMethod.POST)
    public String adminLogin(Model model, @ModelAttribute("BuyerRenter") BuyerRenter buyerRenter,HttpServletRequest request, HttpSession session){
            
        //if (buyerRenter != null && buyerRenter.getBuyerRenterUname()!= null && buyerRenter.getPassword()!= null) {
         //if(1==1){  
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("//////////////////////////////////////////// "+ 1);
            List<BuyerRenter> buyerRenterDetails = LoginServiceDao.getLogin(username, password);
                        System.out.println("//////////////////////////////////////////// "+ 2 + " " + username + password);

            if (buyerRenterDetails.isEmpty()) {
                System.out.println("//////////////////////////////////////////// "+ 3);
                model.addAttribute("error", "Incorrect details");
                return "home";
            } else {
                System.out.println("//////////////////////////////////////////// "+ 4);
               BuyerRenter userLog = buyerRenterDetails.get(0);
                System.out.println( 5);
                session.setAttribute("user", userLog);
                
                
                    return "redirect:buyerRenterView.htm";
                
            }
       // } 
//         else {
//            return "redirect:home";
//        }    

    }
    
    @RequestMapping(value="/verifyAgent", method = RequestMethod.POST)
    public String agentLogin(Model model, @ModelAttribute("EstateAgent") EstateAgent estateAgent,HttpServletRequest request, HttpSession session){
            
        //if (buyerRenter != null && buyerRenter.getBuyerRenterUname()!= null && buyerRenter.getPassword()!= null) {
//          if(1==1){  
            String username = request.getParameter("agent_username");
            String password = request.getParameter("agent_password");
            System.out.println("//////////////////////////////////////////// "+ 1);
            List<EstateAgent> estateAgentDetails = LoginServiceDao.getAgentLogin(username, password);
                        System.out.println("//////////////////////////////////////////// "+ 2 + " " + username + password);

            if (estateAgentDetails.isEmpty()) {
                System.out.println("//////////////////////////////////////////// "+ 3);
                model.addAttribute("error", "Incorrect details");
                return "home";
            } else {
                System.out.println("//////////////////////////////////////////// "+ 4);
                EstateAgent userLog = estateAgentDetails.get(0);
                System.out.println( 5);
                session.setAttribute("user", userLog);
                
                
                    return "redirect:estateAgentView.htm";
                
            }
//        } else {
//            return "redirect:index";
//        }    

    }
    @RequestMapping(value="/verifyOwner", method = RequestMethod.POST)
    public String agentLogin(Model model, @ModelAttribute("PropertyOwner") PropertyOwner propertyOwner,HttpServletRequest request, HttpSession session){
            
        //if (buyerRenter != null && buyerRenter.getBuyerRenterUname()!= null && buyerRenter.getPassword()!= null) {
//          if(1==1){  
            String username = request.getParameter("owner_username");
            String password = request.getParameter("owner_password");
            System.out.println("//////////////////////////////////////////// "+ 1);
            List<PropertyOwner> propertyOwnerDetails = LoginServiceDao.getOwnerLogin(username, password);
                        System.out.println("//////////////////////////////////////////// "+ 2 + " " + username + password);

            if (propertyOwnerDetails.isEmpty()) {
                System.out.println("//////////////////////////////////////////// "+ 3);
                model.addAttribute("error", "Incorrect details");
                return "home";
            } else {
                System.out.println("//////////////////////////////////////////// "+ 4);
                PropertyOwner userLog = propertyOwnerDetails.get(0);
                System.out.println( 5);
                session.setAttribute("user", userLog);
                
                
                    return "redirect:propertyOwnerView.htm";
                
            }
//        } else {
//            return "redirect:index";
//        }    

    }
    @RequestMapping("/userLogout")
    public String logout (HttpSession session){
        session.setAttribute("user", null);
        session.invalidate();
        return "home";
    }
    
}
