package com.interviewiq.api;
import java.util.*;
public final class AssessmentDtos {private AssessmentDtos(){} public record CreateRequest(String targetRole,String difficulty,List<String> topics,Integer questionCount,List<String> types){} public record QuestionView(Long id,String question,String type,String topic,String difficulty,List<String> options){} public record AssessmentView(Long id,String title,String targetRole,Integer questionCount,List<QuestionView> questions,Integer score,String createdAt){} public record SubmitRequest(Map<Long,String> answers){} }
