package com.manhnv.vimaserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DBUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String role; // e.g., "USER", "ADMIN"
    @Builder.Default
    private Boolean isActive = true;

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<DBCluster> clusters = new ArrayList<>();
}
