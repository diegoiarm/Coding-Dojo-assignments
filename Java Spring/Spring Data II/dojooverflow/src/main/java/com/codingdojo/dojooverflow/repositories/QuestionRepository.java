package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<Question> findAll();

}