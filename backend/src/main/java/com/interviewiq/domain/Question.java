package com.interviewiq.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="questions")
public class Question extends BaseEntity {
    @Column(nullable=false,length=1600) private String prompt;
    @Column(nullable=false) private String type;
    @Column(nullable=false) private String topic;
    @Column(nullable=false) private String difficulty;
    @ElementCollection(fetch=FetchType.EAGER) @CollectionTable(name="question_options",joinColumns=@JoinColumn(name="question_id")) @OrderColumn(name="option_order") @Column(name="option_text") private List<String> options=new ArrayList<>();
    private String correctAnswer;
    @Column(length=1200) private String explanation;
    @Column(length=1000) private String expectedConcepts;
    @Column(nullable=false) private boolean active=true;
    public Question() {}
    public Question(String p,String t,String topic,String d,List<String> o,String answer,String explanation,String concepts){this.prompt=p;this.type=t;this.topic=topic;this.difficulty=d;this.options=o;this.correctAnswer=answer;this.explanation=explanation;this.expectedConcepts=concepts;}
    public String getPrompt(){return prompt;} public String getType(){return type;} public String getTopic(){return topic;} public String getDifficulty(){return difficulty;} public List<String> getOptions(){return options;} public String getCorrectAnswer(){return correctAnswer;} public String getExplanation(){return explanation;} public String getExpectedConcepts(){return expectedConcepts;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
}
