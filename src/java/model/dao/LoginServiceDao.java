/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.BuyerRenter;
import model.pojo.EstateAgent;
import model.pojo.PropertyOwner;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author sawan_000
 */
public class LoginServiceDao {
    public static List<BuyerRenter> getLogin (String uname, String password){
         System.out.println("/////////////////////came here/////////////////////// ");
        List<BuyerRenter> login = null;
        System.out.println("Name: " + uname + " password: " + password);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String str ="SELECT u from BuyerRenter u WHERE u.buyerRenterUname = '" + uname + "'and u.password='" + password + "'";
            Query query = session.createQuery(str);
            login = query.list();
//            if(query.list().size()>0){
//                login = query.list();
//            }
//            else{
//                
//            }
            
            System.out.println(login); // for debugging purpose
        } catch(Exception e) {
            e.printStackTrace();
        }
        return login;        
    }
    
    public static List<EstateAgent> getAgentLogin (String uname, String password){
        List<EstateAgent> login = null;
        System.out.println("Name: " + uname + " password: " + password);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String str ="SELECT u from EstateAgent u WHERE u.estateAgentUname = '" + uname + "'and u.password='" + password + "'";
            Query query = session.createQuery(str);
            login = query.list();
            
            
            System.out.println(login); // for debugging purpose
        } catch(Exception e) {
            e.printStackTrace();
        }
        return login;        
    }
    
    
     public static List<PropertyOwner> getOwnerLogin (String uname, String password){
        List<PropertyOwner> login = null;
        System.out.println("Name: " + uname + " password: " + password);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String str ="SELECT u from PropertyOwner u WHERE u.propertyOwnerUname = '" + uname + "'and u.password='" + password + "'";
            Query query = session.createQuery(str);
            login = query.list();
            
            
            System.out.println(login); // for debugging purpose
        } catch(Exception e) {
            e.printStackTrace();
        }
        return login;        
    }
    
    
    
      
    
}
