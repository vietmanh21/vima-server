package com.falcon.serverdb.model;

import com.falcon.serverdb.model.common.AbstractAuditEntity;
import com.falcon.serverdb.model.enumeration.TripStatus;
import com.falcon.serverdb.model.enumeration.TripType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Table(name = "trip")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trip extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TripType tripType;

    private String licensePlate;

    private Instant startTime;

    private Instant endTime;

    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_point", referencedColumnName = "id")
    private Address departurePoint;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_point", referencedColumnName = "id")
    private Address destinationPoint;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TripStatus tripStatus = TripStatus.OPEN;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();
}
