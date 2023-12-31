package com.jevendtout.jevendstout.repository;

import com.jevendtout.jevendstout.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Integer> {

}
