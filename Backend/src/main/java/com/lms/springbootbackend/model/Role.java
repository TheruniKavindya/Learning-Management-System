package com.lms.springbootbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 25, nullable = false, unique = true)
    private String role_name;

    @Column(nullable = false)
    private boolean status;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "role_privilege", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private Set<Privilege> privileges = new HashSet<>();

    public Role(){

    }

    public Role(String role_name){
        this.role_name=role_name;
    }

    public Role(String name, Boolean active){
        this.role_name=name;
        this.status= active;
    }

    public void addPrivilege(Privilege privilege){
        this.privileges.add(privilege);
    }
}
