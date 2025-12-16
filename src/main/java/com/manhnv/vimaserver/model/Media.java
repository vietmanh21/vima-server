package com.manhnv.vimaserver.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "medias")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fileName", nullable = false)
    private String fileName;


    @Column(name = "fileType", nullable = false)
    private String fileType;


    @Column(name = "fileSize", nullable = false)
    private Long fileSize;

    @Column(name = "fileUrl", nullable = false)
    private String fileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


}
