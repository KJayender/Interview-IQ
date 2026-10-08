package com.interviewiq.api;
import jakarta.validation.constraints.*;
public final class AuthDtos {private AuthDtos(){} public record Register(@NotBlank @Size(max=100) String name,@Email @NotBlank String email,@Size(min=8,max=100) String password){} public record Login(@Email @NotBlank String email,@NotBlank String password){} public record AuthResponse(String token,String role,Profile profile){} public record Profile(Long id,String name,String email,String role,String college,String degree,String branch,Integer graduationYear,String experienceLevel,String targetRole,String goal){} }
