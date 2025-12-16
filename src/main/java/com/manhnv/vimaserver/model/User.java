package com.manhnv.vimaserver.model;

import com.manhnv.vimaserver.model.common.BaseEntity;
import com.manhnv.vimaserver.model.enumeration.ROLE;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String bio;

    private String avatar;

    private Instant lastLogin;

    @Enumerated(EnumType.STRING)
    private ROLE role;
}
