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
public class BuyerRenterDao {
    
    public static List<BuyerRenter> buyerRenterDetails(String  BuyerRenterUserId){
       // BuyerRenter buyerRenter;
        List<BuyerRenter> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String str ="SELECT u from BuyerRenter u WHERE u.buyerRenterId = '" +BuyerRenterUserId+ "'";
            Query query = session.createQuery(str);
            lst = query.list();
            System.out.println(lst); // for debugging purpose
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lst;        
    }
    
    public static List <Offer> getOfferBuyer(int buyerId){
            List<Offer> obuy =null;
            try{
                Session ses = HibernateUtil.getSessionFactory().openSession();
                String str = "select o from Offer o, PropertyPosts p, BuyerRenter b where o.propertyPostsID = p.idpropertyPosts and o.buyerRenterID = b.buyerRenterId and o.approval=0 and b.buyerRenterId=" + buyerId;
                Query qry = ses.createQuery(str);
                obuy= qry.list();
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return obuy;
    }
    
    public static List <Offer> getAcceptedOfferBuyer(int buyerId){
            List<Offer> obuy =null;
            try{
                Session ses = HibernateUtil.getSessionFactory().openSession();
                String str = "select o from Offer o, PropertyPosts p, BuyerRenter b where o.propertyPostsID = p.idpropertyPosts and o.buyerRenterID = b.buyerRenterId and o.approval=1 and b.buyerRenterId=" + buyerId;
                Query qry = ses.createQuery(str);
                obuy= qry.list();
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return obuy;
    }
    
    public static void updateOffer(int offerId, double bid, String currency){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        String queary = "update Offer f set f.amount = " +bid+ ", f.currency = '"+currency+"' where f.idoffer = "+offerId+" ";
        Transaction transaction = ses.beginTransaction();
        Query qu = ses.createQuery(queary);
        qu.executeUpdate();
        transaction.commit();
        ses.close();
    
    }
    
   public static void deleteOffer(int offerId){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        String queary = "delete Offer f where f.idoffer = "+offerId+" ";
        Transaction transaction = ses.beginTransaction();
        Query qu = ses.createQuery(queary);
        qu.executeUpdate();
        transaction.commit();
        ses.close();
    
    }
   
   public static List <PropertyPosts> getPropertyBuyer(int buyerId){
            List<PropertyPosts> osp =null;
            try{
                Session ses = HibernateUtil.getSessionFactory().openSession();
                String str = "select p from Offer o, PropertyPosts p, BuyerRenter b where o.propertyPostsID = p.idpropertyPosts and o.buyerRenterID = b.buyerRenterId and b.buyerRenterId =" + buyerId;
                Query qry = ses.createQuery(str);
                osp= qry.list();
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return osp;
    }
    
}
