package Facade;

import entity.Project;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FacadeProject
{

    EntityManagerFactory emf;

    public FacadeProject(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public Project getProject(int id)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            return em.find(Project.class, id);

        } finally
        {
            em.close();
        }
    }

    public List<Project> getProjects()
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            return em.createQuery("Select p from Project").getResultList();
        } finally
        {
            em.close();
        }
    }

    public void addProject(Project p)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.persist(p);
        } finally
        {
            em.close();
        }
    }
}
