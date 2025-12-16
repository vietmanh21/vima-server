package com.manhnv.vimaserver.model;

import com.manhnv.vimaserver.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "follows")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Follow extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followee_user_id")
    private User followeeUser; // exactly one of followeeUser or followeePublication must be non-null
}
