package com.interviewiq.api;
import com.interviewiq.api.AssessmentDtos.*;import com.interviewiq.service.*;import org.springframework.security.core.Authentication;import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/api") public class AssessmentController {private final AuthService auth;private final AssessmentService service;public AssessmentController(AuthService a,AssessmentService s){auth=a;service=s;}
 @PostMapping("/assessments") public AssessmentView create(@RequestBody CreateRequest r,Authentication a){return service.create(auth.require(a.getName()),r);}
 @GetMapping("/assessments") public List<AssessmentView> history(Authentication a){return service.history(auth.require(a.getName()));}
 @GetMapping("/assessments/{id}") public AssessmentView get(@PathVariable Long id,Authentication a){return service.get(auth.require(a.getName()),id);}
 @PostMapping("/assessments/{id}/submit") public Map<String,Object> submit(@PathVariable Long id,@RequestBody SubmitRequest r,Authentication a){return service.submit(auth.require(a.getName()),id,r);}
 @GetMapping("/results/{id}") public Map<String,Object> result(@PathVariable Long id,Authentication a){return service.result(auth.require(a.getName()),id);}
 @GetMapping("/results/history") public List<AssessmentView> results(Authentication a){return service.history(auth.require(a.getName()));}
 @GetMapping("/job-roles") public List<String> roles(){return List.of("Java Developer","Java Full Stack Developer","React Developer","Software Developer");}
 @GetMapping("/skills") public List<String> skills(){return List.of("Core Java","OOP","Collections","Java 8","Multithreading","Spring Boot","Spring Data JPA","Hibernate","REST API","SQL","React","JavaScript","Communication","Problem Solving");}
 @GetMapping("/dashboard") public Map<String,Object> dashboard(Authentication a){var user=auth.require(a.getName());var rows=service.history(user);var latest=rows.stream().filter(x->x.score()!=null).findFirst();Map<String,Object> latestResult=latest.map(x->service.result(user,x.id())).orElse(Map.of());return Map.of("name",user.getName(),"targetRole",user.getTargetRole()==null?"Software Developer":user.getTargetRole(),"readiness",latest.map(AssessmentView::score).orElse(0),"assessmentCount",rows.size(),"assessments",rows,"skillScores",latestResult.getOrDefault("skillScores",Map.of()));}
}
