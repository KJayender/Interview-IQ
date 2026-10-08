package com.interviewiq.repository;
import com.interviewiq.domain.Assessment; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface AssessmentRepository extends JpaRepository<Assessment,Long>{ List<Assessment> findByUserIdOrderByCreatedAtDesc(Long userId); }
