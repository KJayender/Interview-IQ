package com.interviewiq.ai;
import com.interviewiq.domain.Question;import java.util.List;import java.util.Map;
public interface AIService { List<Question> generate(String role,String difficulty,List<String> topics,int count,List<String> types,String experience); Map<String,Object> evaluate(String question,String expectedConcepts,String answer,boolean behavioral); }
