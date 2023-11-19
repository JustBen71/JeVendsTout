package com.jevendtout.jevendstout.repository;

import com.jevendtout.jevendstout.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
