/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import model.dao.BuyerRenterDao;
import model.dao.EstateAgentDao;
import model.dao.LoginServiceDao;
import model.pojo.BuyerRenter;
import model.pojo.EstateAgent;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sawan_000
 */
public class EstateAgentController {

    @RequestMapping(value = "/estateAgentView")
    public String estateMVC(Model model,EstateAgent estateAgent , HttpSession session) {
        if (session.getAttribute("user") != null) {
            EstateAgent userLoggedIn = (EstateAgent) session.getAttribute("user");
            int userId = userLoggedIn.getEstateAgentId();
            String agentId = String.valueOf(userId);

//           List<BuyerRenter> buyerRenterDetails = LoginServiceDao.getLogin(userLoggedIn);
//                String BuyerRenterUserId = userLoggedIn.toString();
             //   System.out.println("//////////////" + buyerId);
            //buyuerRenter = (BuyerRenter) session.getAttribute("verifyUser");
            List<EstateAgent> estateAgentDetails = EstateAgentDao.estateAgentDetails(agentId);
           // System.out.println("//////////////" + buyerRenterDetails);
            

            model.addAttribute("estateAgentList", estateAgentDetails);
            return "estateAgentView";

        } else {
            return "estateAgentView";
        }
    }
}
