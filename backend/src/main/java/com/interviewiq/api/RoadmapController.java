package com.interviewiq.api;
import com.interviewiq.service.*;import org.springframework.security.core.Authentication;import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController @RequestMapping("/api/roadmap") public class RoadmapController {private final AuthService auth;private final RoadmapService roadmap;public RoadmapController(AuthService a,RoadmapService r){auth=a;roadmap=r;}
 @GetMapping public List<RoadmapService.TaskView> get(Authentication a){return roadmap.get(auth.require(a.getName()));}
 @PatchMapping("/items/{id}") public RoadmapService.TaskView update(@PathVariable Long id,@RequestBody StatusRequest r,Authentication a){return roadmap.update(auth.require(a.getName()),id,r.status());}
 public record StatusRequest(String status){}
}
