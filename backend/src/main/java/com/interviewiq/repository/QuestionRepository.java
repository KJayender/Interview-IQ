package com.interviewiq.repository;
import com.interviewiq.domain.Question; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface QuestionRepository extends JpaRepository<Question,Long>{ List<Question> findByActiveTrue(); }
