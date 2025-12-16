package com.manhnv.vimaserver.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "collection_tag")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CollectionTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = false)
    private Collection collection;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
