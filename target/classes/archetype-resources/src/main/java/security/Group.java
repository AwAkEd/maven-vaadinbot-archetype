package ${package}.security;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity  
@Table(name="GROUPS")
public class Group implements Serializable {

    private static final long serialVersionUID = -2530932886073069499L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable = false)
    private long id;
    
    @Column(name="NAME", nullable = false)
    private String name;
    
    @OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="USER_GROUPS",   
        joinColumns = {@JoinColumn(name="GROUP_ID", referencedColumnName="ID")},  
        inverseJoinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="ID")}  
    )  
    private Set<User> users;    
    
    public Group() {
    }

    public Group(String name) {
        this.setName(name);
    }

    public long getId() {  
        return id;  
    }  
  
    public void setId(long id) {  
        this.id = id;  
    }  
    

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }
    
    public Set<User> getUsers() {  
        return users;  
    }  
  
    public void setUsers(Set<User> users) {  
        this.users = users;  
    }  

}
