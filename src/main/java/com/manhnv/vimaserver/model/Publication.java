package com.manhnv.vimaserver.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publications")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(length = 2000)
    private String url;

    private String logo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Builder.Default
    private int views = 0;

    public void incrementViews() {
        this.views++;
    }
}
