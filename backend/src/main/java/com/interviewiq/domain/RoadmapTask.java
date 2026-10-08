package com.interviewiq.domain;
import jakarta.persistence.*;
@Entity @Table(name="roadmap_tasks") public class RoadmapTask extends BaseEntity {
 @ManyToOne(optional=false) private AppUser user;@Column(nullable=false) private String title;@Column(nullable=false) private String topic;@Column(length=500) private String rationale;@Column(length=500) private String practiceTask;@Column(nullable=false) private String status="NOT_STARTED";private String estimate;
 public RoadmapTask(){} public RoadmapTask(AppUser u,String title,String topic,String rationale,String task,String estimate){this.user=u;this.title=title;this.topic=topic;this.rationale=rationale;this.practiceTask=task;this.estimate=estimate;}
 public AppUser getUser(){return user;}public String getTitle(){return title;}public String getTopic(){return topic;}public String getRationale(){return rationale;}public String getPracticeTask(){return practiceTask;}public String getStatus(){return status;}public void setStatus(String v){status=v;}public String getEstimate(){return estimate;}
}
