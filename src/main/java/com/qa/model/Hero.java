package com.qa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String heroName;
    String issueOne;
    String description;

public Hero(){
    super();
}
    public Hero(String heroName, String issueOne, String description) {
    super();
        this.heroName = heroName;
        this.issueOne = issueOne;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
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

    public void setHero(Hero hero){

        this.heroName = hero.heroName;
        this.issueOne = hero.issueOne;
        this.description = hero.description;
    }


}
