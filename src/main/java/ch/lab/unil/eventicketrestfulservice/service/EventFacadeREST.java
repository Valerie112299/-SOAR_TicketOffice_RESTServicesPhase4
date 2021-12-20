package ch.lab.unil.eventicketrestfulservice.service;

import ch.lab.unil.eventicketrestfulservice.models.Event;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author valer
 */
@Stateless
@Path("ch.lab.unil.eventicketrestfulservice.models.Event")
public class EventFacadeREST extends AbstractFacade<Event> {
   
    @PersistenceContext(unitName = "ET_PU")
    private EntityManager em;
    
    public EventFacadeREST() {
        super(Event.class);
    }
    /**
     * Create representation of an instance of ch.lab.unil.eventicketrestfulservice.service.EventFacadeREST
     */
    @POST
    @Path("/create")
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Event entity) {
        super.create(entity);
    }
    
    @DELETE
    @Path("/remove/{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }
    
    @PUT
    @Path("/edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Event entity) {
        super.edit(entity);
    }
    
    @PUT
    @Path("/editqta/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editqta(@PathParam("id") Integer id, Event entity) {
        super.editqta(entity);
    }
    
    @GET
    @Path("/find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Event find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("/findByName/{name}")
    public Event findByName(@PathParam("name") String eventName) {
        return super.findByName("Event.findByEventName", "name", eventName);
    }
    /*
    @GET
    public List<Event> findAllEventWithLocation(@PathParam("loaction") String eventlocation) {
        return super.findAllEventWithLocation("Event.findByEventLocation","location",eventlocation);
    }
    */

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Event> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
