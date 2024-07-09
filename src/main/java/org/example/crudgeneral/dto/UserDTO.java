package org.example.crudgeneral.dto;

import lombok.Data;

@Data
public class UserDTO {

    private int id;
    private String login;
    private String parol;
    private String email;
    private String address;
    private int year;
    private String description;
}
