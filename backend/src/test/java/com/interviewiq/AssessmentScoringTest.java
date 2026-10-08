package com.interviewiq;
import com.interviewiq.service.ScoringPolicy;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class AssessmentScoringTest {
 @Test void objectiveAndWrittenScoresUseConfiguredWeights(){var policy=new ScoringPolicy(.7,.3,80,60,40);assertEquals(76,policy.combine(80,65,true,true));}
 @Test void objectiveOnlyAssessmentStaysDeterministic(){var policy=new ScoringPolicy(.7,.3,80,60,40);assertEquals(75,policy.combine(75,0,true,false));}
 @Test void skillBandsAreClearlyClassified(){var policy=new ScoringPolicy(.7,.3,80,60,40);assertEquals("Strong",policy.classify(80));assertEquals("Good",policy.classify(60));assertEquals("Needs Improvement",policy.classify(40));assertEquals("Weak",policy.classify(39));}
}
