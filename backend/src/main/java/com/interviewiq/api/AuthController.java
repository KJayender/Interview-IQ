package com.interviewiq.api;
import com.interviewiq.api.AuthDtos.*;import com.interviewiq.service.AuthService;import jakarta.validation.Valid;import org.springframework.security.core.Authentication;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api") public class AuthController {private final AuthService auth;public AuthController(AuthService a){auth=a;}
 @PostMapping("/auth/register") public AuthResponse register(@Valid @RequestBody Register r){return auth.register(r);}
 @PostMapping("/auth/login") public AuthResponse login(@Valid @RequestBody Login r){return auth.login(r);}
 @GetMapping("/profile") public Profile profile(Authentication a){return auth.profile(auth.require(a.getName()));}
 @PutMapping("/profile") public Profile update(@RequestBody ProfileUpdate p,Authentication a){return auth.update(a.getName(),p);}
 public record ProfileUpdate(String college,String degree,String branch,Integer graduationYear,String experienceLevel,String targetRole,String goal){}
}
