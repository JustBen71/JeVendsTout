package com.jevendtout.jevendstout.repository;

import com.jevendtout.jevendstout.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
