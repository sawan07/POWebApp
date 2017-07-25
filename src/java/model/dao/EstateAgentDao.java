/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.BuyerRenter;
import model.pojo.EstateAgent;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author sawan_000
 */
public class EstateAgentDao {
    
    public static List<EstateAgent> estateAgentDetails (String  EstateAgentUserId){
       // BuyerRenter buyerRenter;
        List<EstateAgent> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String str ="SELECT u from EstateAgent u WHERE u.estateAgentId = '" +EstateAgentUserId+ "'";
            Query query = session.createQuery(str);
            lst = query.list();
            System.out.println(lst); // for debugging purpose
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lst;        
    }
    
}
