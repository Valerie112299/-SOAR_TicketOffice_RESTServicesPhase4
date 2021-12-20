package ch.lab.unil.eventicketrestfulservice.service;

import ch.lab.unil.eventicketrestfulservice.models.Event;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author valer
 */
public  abstract class AbstractFacade<T> {
    
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }
    public void editqta(Event entity) {
         int newqta = entity.getNbPlace() - 1;
         entity.setNbPlace(newqta);
         getEntityManager().merge(entity);
         
         /*in case the first method does't work
                String sqlq = "UPDATE Event x SET x.nbplace = '"+newqta+"'" + " WHERE x.eventId =:eventId";
                Query query = getEntityManager().createQuery(sqlq);
                query.setParameter("eventId",entity.getEventId());
                query.executeUpdate(); 
        */
       
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public T findByName(Object namedQuery, Object parameterName, Object name) {
        Query query = getEntityManager().createNamedQuery((String) namedQuery);
        List<T> results = query.setParameter((String) parameterName, (String) name).getResultList();
        if(results.size() > 0) {
            return results.get(0);
        }
        return null;
    }
    public List<T> findAllEventWithLocation(Object namedQuery, Object parameterLoc, Object location) {
        Query query = getEntityManager().createNamedQuery((String) namedQuery);
        List<T> results = query.setParameter((String) parameterLoc, (String) location).getResultList();
        if(results.size() > 0) {
            return results;
        }
        return null;
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
