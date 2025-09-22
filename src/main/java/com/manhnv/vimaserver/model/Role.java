package com.manhnv.vimaserver.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // using Integer cuz we'll only have a few roles

    @Column(nullable = false, unique = true)
    private String name;  // eg: USER, ADMIN, SUPER_ADMIN

    // maybe add description field later?
}
