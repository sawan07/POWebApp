package model.pojo;
// Generated 21-Mar-2017 20:47:39 by Hibernate Tools 4.3.1



/**
 * Feedback generated by hbm2java
 */
public class Feedback  implements java.io.Serializable {


     private Integer idfeedback;
     private PropertyPosts propertyPosts;
     private double rating;
     private String comment;
     private String givenBy;
     private String givenOn;

    public Feedback() {
    }

	
    public Feedback(double rating, String givenBy, String givenOn) {
        this.rating = rating;
        this.givenBy = givenBy;
        this.givenOn = givenOn;
    }
    public Feedback(PropertyPosts propertyPosts, double rating, String comment, String givenBy, String givenOn) {
       this.propertyPosts = propertyPosts;
       this.rating = rating;
       this.comment = comment;
       this.givenBy = givenBy;
       this.givenOn = givenOn;
    }
   
    public Integer getIdfeedback() {
        return this.idfeedback;
    }
    
    public void setIdfeedback(Integer idfeedback) {
        this.idfeedback = idfeedback;
    }
    public PropertyPosts getPropertyPosts() {
        return this.propertyPosts;
    }
    
    public void setPropertyPosts(PropertyPosts propertyPosts) {
        this.propertyPosts = propertyPosts;
    }
    public double getRating() {
        return this.rating;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getGivenBy() {
        return this.givenBy;
    }
    
    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }
    public String getGivenOn() {
        return this.givenOn;
    }
    
    public void setGivenOn(String givenOn) {
        this.givenOn = givenOn;
    }




}

