package org.example.crudgeneral.models;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Data
@Table(name = "user_list")
public class UserTables implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String login;

    @Column
    private String parol;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private int year;

    @Column
    private String description;

}
