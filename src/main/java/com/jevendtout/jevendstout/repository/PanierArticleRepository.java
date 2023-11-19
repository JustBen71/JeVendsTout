package com.jevendtout.jevendstout.repository;

import com.jevendtout.jevendstout.model.Article;
import com.jevendtout.jevendstout.model.Panier;
import com.jevendtout.jevendstout.model.Panier_Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PanierArticleRepository extends JpaRepository<Panier_Article, Integer> {

}
