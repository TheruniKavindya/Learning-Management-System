package com.lms.springbootbackend.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    private String privilege_name;

    @Column(nullable = false)
    private Boolean status;

    public Privilege(String privilege_name){
        this.privilege_name=privilege_name;
    }

    public Privilege(int id, String name, Boolean active){
        this.id=id;
        this.privilege_name=name;
        this.status= active;
    }
}
