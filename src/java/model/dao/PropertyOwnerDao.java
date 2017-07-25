/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.pojo.BuyerRenter;
import model.pojo.Offer;
import model.pojo.PropertyOwner;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sawan_000
 */
public class PropertyOwnerDao {
    
    public static List<PropertyOwner> propertyOwnerDetails (String  PropertyOwnerUserId){
       // BuyerRenter buyerRenter;
        List<PropertyOwner> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String str ="SELECT u from PropertyOwner u WHERE u.propertyOwnerId = '" +PropertyOwnerUserId+ "'";
            Query query = session.createQuery(str);
            lst = query.list();
            System.out.println(lst); // for debugging purpose
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lst;        
    }

    public static List<PropertyOwner> getOwners() {
        List<PropertyOwner> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String str ="SELECT u from PropertyOwner u";
            Query query = session.createQuery(str);
            lst = query.list();
            System.out.println(lst); // for debugging purpose
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    
    public static List <Offer> getOwnerOffer(int ownerId){
            List<Offer> os =null;
            try{
                Session ses = HibernateUtil.getSessionFactory().openSession();
                String str = "select o from Offer o, PropertyPosts p, PropertyOwner f where o.propertyPostsID = p.idpropertyPosts and p.propertyOwner = f.propertyOwnerId and o.approval=0 and f.propertyOwnerId =" + ownerId;
                Query qry = ses.createQuery(str);
                os= qry.list();
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return os;
    }
    
    public static void decideOffer(int offerId, int status){
        
        
        Session ses = HibernateUtil.getSessionFactory().openSession();
        String queary = "update Offer f set f.approval = '"+status+"', f.approvalDate=CURRENT_DATE() where f.idoffer = " + offerId;
        //String queary = "update Offer f set f.approval = '"+status+"'and f.approvalDate='"+currentDate+"' where f.idoffer = " + offerId;
        Transaction transaction = ses.beginTransaction();
        Query qu = ses.createQuery(queary);
        qu.executeUpdate();
        transaction.commit();
        ses.close();
    
    }
    
    public static void updateProperty(int propertyid){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        String queary = "update PropertyPosts f set f.postingStatus = 0 where idpropertyPosts = " + propertyid;
        Transaction transaction = ses.beginTransaction();
        Query qu = ses.createQuery(queary);
        qu.executeUpdate();
        transaction.commit();
        ses.close();
    
    }
}
