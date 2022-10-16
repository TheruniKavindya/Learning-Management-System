package com.lms.springbootbackend.controller.dto;

import lombok.Data;

@Data
public class RoleDTO {

    private String rolename;
    private Integer[] rolePermissios;
    private Boolean status;
}
