package Facade;

import entity.ProjectUser;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

public class FacadeProjectUser
{

    EntityManagerFactory emf;

    public FacadeProjectUser(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public ProjectUser getUser(int id)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            return em.find(ProjectUser.class, id);
        } finally
        {
            em.close();
        }
    }

    public List<ProjectUser> getUsers()
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            return em.createQuery("Select u from ProjectUser").getResultList();
        } finally
        {
            em.close();
        }
    }

    public void addUser(ProjectUser u)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.persist(u);
          
        }
        finally
        {
            em.close();
        }
    }
}
