package com.interviewiq.repository;
import com.interviewiq.domain.RoadmapTask;import org.springframework.data.jpa.repository.JpaRepository;import java.util.List;
public interface RoadmapTaskRepository extends JpaRepository<RoadmapTask,Long>{List<RoadmapTask> findByUserIdOrderByIdAsc(Long userId);}
