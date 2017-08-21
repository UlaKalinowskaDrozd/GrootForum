package com.ula.grootforum.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Urszula Kalinowska-Drozd on 06.08.17.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Size(min = 4)
    private String userName;

    @Email
    private String email;

    @Size(min = 8)
    private String password;

    private boolean enabled = true;

    private final String role = "ROLE_USER";


    public User(){}

    public Long getUserId() {
        return userId;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public boolean isEnabled() { return enabled; }
}
