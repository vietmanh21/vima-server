package com.manhnv.vimaserver.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "seats")
@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatCode;

    @Column(name = "is_reserved", nullable = false)
    private Boolean isReserved = false;  // default not reserved

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @OneToOne(mappedBy = "seat")
    private Ticket ticket;
}
