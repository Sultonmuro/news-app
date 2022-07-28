package com.example.kunuztokenbased.entity;

import com.example.kunuztokenbased.entity.enums.RolesType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
 private String phone;
 private Integer age;
 @Enumerated
 private RolesType rolesType;

 @OneToMany
 private List<Role> roleList;
 private String password;

//    private boolean accountNonExpired = true; //accountni vaqti o'tmaganmi?
//    private boolean accountNonLocked = true; //bloklanmaganmi?
//    private boolean credentialsNonExpired = true; //parol o'zinikimi
//    private boolean enabled = true; //tizimga kimdir kirganda undan foydalanish huquqi
//
//
//    public User(Long id, String aaa, String user, String encode, boolean b) {
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.name;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return this.accountNonExpired ;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this. accountNonLocked ;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.isCredentialsNonExpired();
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.enabled;
//    }
}
