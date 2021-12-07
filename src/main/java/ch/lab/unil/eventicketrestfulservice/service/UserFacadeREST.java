
package ch.lab.unil.eventicketrestfulservice.service;
import ch.lab.unil.eventicketrestfulservice.models.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@Path("ch.lab.unil.eventicketrestfulservice.models.User")
public class UserFacadeREST extends AbstractFacade<User> {

   @PersistenceContext(unitName = "ET_PU")
    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
    }

    @POST
    @Path("/create")
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(User entity) {
        super.create(entity);
    }
    
    @PUT
    @Path("/edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, User entity) {
        super.edit(entity);
    }
    
    @DELETE
    @Path("/remove/{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }
    
     @GET
    @Path("/find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("/findByName/{name}")
    public User findByName(@PathParam("name") String userName) {
        return super.findByName("User.findByUsername", "username", userName);
    }

    @GET
    @Path("/emailExists/{email}")
    public boolean emailExists(@PathParam("email") String email) {
        Query query = em.createNamedQuery("User.findByEmail");
        List<User> results = query.setParameter("email", email).getResultList();
        return results.size() == 1;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
