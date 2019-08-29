package com.jacky.learn.shiro.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TBL_USER")
public class User extends BaseEntity {
    private String userName;
    private String loginName;
    private String sex;

    @ManyToMany
//    @JoinTable(
//            name = "tbl_user_role",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "role_id")}
//    )
    private Set<Role> roles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
