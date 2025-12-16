package com.manhnv.vimaserver.repository;

import com.manhnv.vimaserver.model.Clap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClapRepository extends JpaRepository<Clap, Long> {
}
