
package ch.lab.unil.eventicketrestfulservice.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventId", query = "SELECT e FROM Event e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.name = :name"),
    @NamedQuery(name = "Event.findByEventPrice", query = "SELECT e FROM Event e WHERE e.price = :price"),
   //@NamedQuery(name = "Event.updateEventById", query = "UPDATE Event SET e.nbplace = :nbplace WHERE e.eventId = :eventId"),
    @NamedQuery(name = "Event.findByEventLocation", query = "SELECT e FROM Event e WHERE e.location = :location")})

public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVENT_ID")
    private int eventId;
    
    @Size(max = 50)
    @Column(name = "EVENT_NAME")
    private String name;
  
    
    @Column(name = "EVENT_DATE")
    private Date date;
    
    @Size(max = 50)
    @Column(name = "EVENT_LOCATION")
    private String location;
    
    @Size(max = 500)
    @Column(name = "EVENT_DESCRIPTION")
    private String description;
    
    @Size(max = 250)
    @Column(name = "EVENT_IMG")
    private String img;
    
  //@Max(value=1000)  @Min(value=0)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EVENT_PRICE")
    private Double price;
    
    @Column(name = "EVENT_PLACES")
    private int nbplace;
    
    @Size(max = 100)
    @Column(name = "EVENT_SECURITY")
    private String security;
    
    @Size(max = 100)
    @Column(name = "EVENT_STATUS")
    private String status;
  
    public Event() {
        this.name = "";
        this.date = new Date();
        this.description = "";
        this.img = "";
        this.nbplace = 0;
        this.security = "";
        this.status = "";
        this.price = 0.0;
    }

    public Event(Integer eventId) {
        this.eventId= eventId;
    }

    public Integer getEventId() {
        return eventId;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name ){
        this.name = name;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img ){
        this.img = img;
    }
    public Date getDate() {
        
        return this.date;
    }
    public void setDate(Date dateandtime){
        this.date = dateandtime;
    }
    public String getLocation() {
        return this.location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

  
    public double getPrice() {
        return this.price;
    }

   
    public void setPrice(double price){
        this.price = price;
    }
  
    public int  getNbPlace(){
        return this.nbplace;
    }
   
     public void setNbPlace(int _nbplace){
        this.nbplace = _nbplace;
    }

    
    public String getSecurity(){
        return security;
    }
    
    public void setSecurity(String security){
        this.security = security;
    }

    public String getStatus(){
        return status;
        
    }

    public void setStatus(String _status){
        this.status = _status;
    }
    
     
}
