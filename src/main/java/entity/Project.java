
package entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Project
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name; 
    String description; 
    @Temporal(javax.persistence.TemporalType.DATE)
    Date created;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date lastModified; 
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    
}
