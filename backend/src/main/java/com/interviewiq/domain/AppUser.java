package com.interviewiq.domain;

import jakarta.persistence.*;

@Entity @Table(name="users")
public class AppUser extends BaseEntity {
    @Column(nullable=false) private String name;
    @Column(nullable=false, unique=true) private String email;
    @Column(nullable=false) private String passwordHash;
    @Column(nullable=false) private String role = "STUDENT";
    private String college; private String degree; private String branch; private Integer graduationYear;
    private String experienceLevel; private String targetRole; private String goal; @Column(nullable=false) private boolean enabled=true;
    public AppUser() {}
    public AppUser(String name,String email,String passwordHash) { this.name=name; this.email=email; this.passwordHash=passwordHash; }
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String v){passwordHash=v;}
    public String getRole(){return role;} public void setRole(String v){role=v;}
    public String getCollege(){return college;} public void setCollege(String v){college=v;}
    public String getDegree(){return degree;} public void setDegree(String v){degree=v;}
    public String getBranch(){return branch;} public void setBranch(String v){branch=v;}
    public Integer getGraduationYear(){return graduationYear;} public void setGraduationYear(Integer v){graduationYear=v;}
    public String getExperienceLevel(){return experienceLevel;} public void setExperienceLevel(String v){experienceLevel=v;}
    public String getTargetRole(){return targetRole;} public void setTargetRole(String v){targetRole=v;}
    public String getGoal(){return goal;} public void setGoal(String v){goal=v;}
    public boolean isEnabled(){return enabled;} public void setEnabled(boolean v){enabled=v;}
}
