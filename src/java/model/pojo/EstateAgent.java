package model.pojo;
// Generated 21-Mar-2017 20:47:39 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * EstateAgent generated by hbm2java
 */
public class EstateAgent  implements java.io.Serializable {


     private Integer estateAgentId;
     private String name;
     private String password;
     private String address;
     private String email;
     private String telephone;
     private String estateAgentUname;
     private Set propertyPostses = new HashSet(0);

    public EstateAgent() {
    }

	
    public EstateAgent(String name, String password, String address, String email, String telephone, String estateAgentUname) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.estateAgentUname = estateAgentUname;
    }
    public EstateAgent(String name, String password, String address, String email, String telephone, String estateAgentUname, Set propertyPostses) {
       this.name = name;
       this.password = password;
       this.address = address;
       this.email = email;
       this.telephone = telephone;
       this.estateAgentUname = estateAgentUname;
       this.propertyPostses = propertyPostses;
    }
   
    public Integer getEstateAgentId() {
        return this.estateAgentId;
    }
    
    public void setEstateAgentId(Integer estateAgentId) {
        this.estateAgentId = estateAgentId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getEstateAgentUname() {
        return this.estateAgentUname;
    }
    
    public void setEstateAgentUname(String estateAgentUname) {
        this.estateAgentUname = estateAgentUname;
    }
    public Set getPropertyPostses() {
        return this.propertyPostses;
    }
    
    public void setPropertyPostses(Set propertyPostses) {
        this.propertyPostses = propertyPostses;
    }




}


