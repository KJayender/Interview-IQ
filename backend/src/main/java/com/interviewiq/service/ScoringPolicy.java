package com.interviewiq.service;
import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Component;
@Component public class ScoringPolicy {
 private final double objectiveWeight, writtenWeight;private final int strongThreshold, goodThreshold, needsThreshold;
 public ScoringPolicy(@Value("${assessment.objective-weight:0.7}") double objectiveWeight,@Value("${assessment.written-weight:0.3}") double writtenWeight,@Value("${assessment.strong-threshold:80}") int strongThreshold,@Value("${assessment.good-threshold:60}") int goodThreshold,@Value("${assessment.needs-threshold:40}") int needsThreshold){this.objectiveWeight=objectiveWeight;this.writtenWeight=writtenWeight;this.strongThreshold=strongThreshold;this.goodThreshold=goodThreshold;this.needsThreshold=needsThreshold;}
 public int combine(int objective,int written,boolean hasObjective,boolean hasWritten){if(!hasObjective)return written;if(!hasWritten)return objective;double total=objectiveWeight+writtenWeight;return total<=0?0:(int)Math.round((objective*objectiveWeight+written*writtenWeight)/total);}
 public String classify(int score){return score>=strongThreshold?"Strong":score>=goodThreshold?"Good":score>=needsThreshold?"Needs Improvement":"Weak";}
}
