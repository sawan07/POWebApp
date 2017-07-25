/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.BuyerRenter;
import model.pojo.PropertyPosts;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sawan_000
 */
public class PropertyDao {
     public static void saveUser (PropertyPosts propertyPosts) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(propertyPosts);
        transaction.commit();
        session.close();      
    }
     
     
     public static List<PropertyPosts> getProperty (String address){
        List<PropertyPosts> property = null;
        //System.out.println("Name: " + uname + " password: " + password);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String str ="SELECT u from PropertyPosts u WHERE u.postingStatus = 1 and (u.propertyType  Like '%" + address + "%' or u.address Like '%" +address+"%')";
            Query query = session.createQuery(str);
            //login = query.list();
            if(query.list().size()>0){
                property = query.list();
            }
            else{
                
            }
            
            System.out.println(property); // for debugging purpose
        } catch(Exception e) {
            e.printStackTrace();
        }
        return property;        
    }
}
