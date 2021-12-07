package ch.lab.unil.eventicketrestfulservice.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valer
 */

@Entity
@Table(name = "USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name= "User.findByPhonenumber", query = "SELECT u FROM User u WHERE u.phonenumber = :phonenumber"),
    @NamedQuery(name = "User.findByUserRole", query = "SELECT u FROM User u WHERE u.userRole = :userRole")})
    //@NamedQuery(name = "User.UpdatePassword", query = "UPDATE User u SET u.password = test2 "+ "WHERE u.userId = :userId")
public class User implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Integer userId;
    
    @Size(max = 50)
    @Column(name = "FIRST_NAME")
    private String firstname;
    
    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastname;
    
    @Size(max = 50)
    @Column(name = "USERNAME")
    private String username;

    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
 
    @Column(name = "PHONE_NUMBER")
    private String phonenumber;
    
    @Size(max = 10)
    @Column(name = "ROLE")
    private String userRole;
    
    @JoinTable(name = "TICKET_SOLD_USER", joinColumns = {
        @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")})
    @ManyToMany
    private List<Event> saleTicketList;
    

    
   
    public User(){}
     public int getId() {
        return userId;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
   
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }
   
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String _password) {
        this.password = _password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    public List<Event> getSaleTicketList() {
        return saleTicketList;
    }
    public void setSaleTicketList(Event Ticket) {
        this.saleTicketList.add(Ticket);
    }

   
    public boolean isPasswordCorrect(String _password){
        //return Integer.toString(password.hashCode()).equals(this.password);
        return this.password.equals(_password);
    }
 
}


