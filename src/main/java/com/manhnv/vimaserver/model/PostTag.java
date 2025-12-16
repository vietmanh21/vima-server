package com.manhnv.vimaserver.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "post_tag")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
