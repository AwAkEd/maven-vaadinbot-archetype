package ${package}.security;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity  
@Table(name="USERS")
public class User implements Serializable {
    
    private static final long serialVersionUID = -8623370875041220981L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable = false)
    private long id;
    
    @Column(name="USERNAME", nullable = false)
    private String username;
    
    @Column(name="PASSWORD", nullable = false)
    private String password;
    
    @Column(name="EMAIL", nullable = true)
    private String email;
    
    @Column(name="BLOCKED", nullable = false, columnDefinition = "tinyint default false")
    private boolean blocked = false;
    
    @Column(name="LOGIN_ATTEMPTS", nullable = false, columnDefinition = "integer default 0")
    private int loginAttempts = 0;
    
    @Column(name="LASTLOGIN", nullable = true)
    private Date lastLogin; 

    @OneToOne(cascade=CascadeType.ALL)  
    @JoinTable(name="USER_GROUPS",  
        joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="ID")},  
        inverseJoinColumns = {@JoinColumn(name="GROUP_ID", referencedColumnName="ID")}  
    )  
    private Group group;

    public User() {
    }

    public User(String name, Date lastLogin) {
    	this.setUsername(name);
    	this.setLastLogin(lastLogin);
    }

    public User(String username, String password, String email) {
    	this.setUsername(username);
    	this.setPassword(password);
    	this.setEmail(email);
    }
    
    public long getId() {  
        return id;  
    }  
  
    public void setId(long id) {  
        this.id = id;  
    }
    
    public String getUsername() {
    	return username;
    }

    public void setUsername(String username) {
    	this.username = username;
    }

    public String getPassword() {
    	return password;
    }

    public void setPassword(String password) {
    	this.password = password;
    }

    public Group getGroup() {  
        return group;  
    }  
  
    public void setGroup(Group group) {  
        this.group = group;  
    }

    public String getEmail() {
    	return email;
    }

    public void setEmail(String email) {
    	this.email = email;
    }

    public boolean isBlocked() {
    	return blocked;
    }

    public void setBlocked(boolean blocked) {
    	this.blocked = blocked;
    }

    public int getLoginAttempts() {
    	return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
    	this.loginAttempts = loginAttempts;
    }

    public Date getLastLogin() {
    	return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
    	this.lastLogin = lastLogin;
    }

}
