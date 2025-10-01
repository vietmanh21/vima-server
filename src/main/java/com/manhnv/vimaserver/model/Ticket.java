package com.falcon.serverdb.model;

import com.manhnv.vimaserver.model.enumeration.TicketStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ticket")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    private String boardingPoint;

    private String dropoffPoint;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TicketStatus status = TicketStatus.BOOKED;

    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
