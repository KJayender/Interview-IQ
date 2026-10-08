package com.interviewiq.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="assessments")
public class Assessment extends BaseEntity {
    @ManyToOne(optional=false) private AppUser user;
    @Column(nullable=false) private String title;
    private String targetRole;
    private Integer score;
    private Integer questionCount;
    @Column(length=8000) private String resultJson;
    @ManyToMany(fetch=FetchType.EAGER) @JoinTable(name="assessment_questions",joinColumns=@JoinColumn(name="assessment_id"),inverseJoinColumns=@JoinColumn(name="question_id")) private List<Question> questions=new ArrayList<>();
    public Assessment(){}
    public Assessment(AppUser user,String title,String targetRole,List<Question> questions){this.user=user;this.title=title;this.targetRole=targetRole;this.questions=questions;this.questionCount=questions.size();}
    public AppUser getUser(){return user;} public String getTitle(){return title;} public String getTargetRole(){return targetRole;} public Integer getScore(){return score;} public void setScore(Integer v){score=v;} public Integer getQuestionCount(){return questionCount;} public String getResultJson(){return resultJson;} public void setResultJson(String v){resultJson=v;} public List<Question> getQuestions(){return questions;}
}
