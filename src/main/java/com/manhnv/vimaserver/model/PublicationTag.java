package com.manhnv.vimaserver.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "publication_tags")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublicationTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publication_id", nullable = false)
    private Publication publication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
