package com.qa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String teamName;
    String issueOne;
    String description;


    @OneToMany(fetch = FetchType.EAGER)
    Set<Hero> heroes = new HashSet<Hero>();

    public Team(){
        super();
    }
    public Team(String teamName, String issueOne, String description) {
        super();
        this.teamName = teamName;
        this.issueOne = issueOne;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getIssueOne() {
        return issueOne;
    }

    public void setIssueOne(String issueOne) {
        this.issueOne = issueOne;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeam(Team team){

        this.teamName = team.teamName;
        this.issueOne = team.issueOne;
        this.description = team.description;
    }

    public Set<Hero> getHero(){
        return heroes;
    }
    public void setHero(Set<Hero> hero){
     this.heroes =hero;
    }

}
