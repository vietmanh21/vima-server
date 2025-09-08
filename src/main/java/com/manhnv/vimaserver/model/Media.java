package com.manhnv.vimaserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "media")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DBMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;

    @ManyToOne
    @JoinColumn(name = "pitch_id", nullable = false)
    private DBCluster pitch;
}
