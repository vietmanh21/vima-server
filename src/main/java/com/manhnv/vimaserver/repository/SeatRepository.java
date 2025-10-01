package com.falcon.serveradmin.repository;

import com.falcon.serverdb.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findBySeatCodeAndIsReservedIsFalse(String seatCode);
}
