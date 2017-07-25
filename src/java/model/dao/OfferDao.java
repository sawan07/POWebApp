/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.BuyerRenter;
import model.pojo.Offer;
import model.pojo.PropertyPosts;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sawan_000
 */
public class OfferDao {
     public static void makeOffer (Offer offer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(offer);
        transaction.commit();
        session.close();      
    }
     public static List<Offer> getOffer (int id){
        List<Offer> offer = null;
        //System.out.println("Name: " + uname + " password: " + password);
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String str ="SELECT u from Offer u WHERE u.buyerRenterID ="+id;
            Query query = session.createQuery(str);
            //login = query.list();
            if(query.list().size()>0){
                offer = query.list();
            }
            else{
                
            }
            
            System.out.println(offer); // for debugging purpose
        } catch(Exception e) {
            e.printStackTrace();
        }
        return offer;   
}
}
