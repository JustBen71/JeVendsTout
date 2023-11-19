package com.jevendtout.jevendstout.repository;

import com.jevendtout.jevendstout.model.Associer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssocierRepository extends JpaRepository<Associer, Integer> {
}
