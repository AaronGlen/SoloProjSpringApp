package com.qa.controllers;


import com.qa.model.Hero;
import com.qa.repository.HeroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class HeroControllerTest {

    @InjectMocks
    private HeroController heroController;

    @Mock
    private HeroRepository repository;

    @Test
    public void testHero(){
        List<Hero> heroList = new ArrayList<>();
        Hero hero = new Hero();
        Hero heroine = new Hero("she-hulk","hulk#51","hulks cousin");
        hero.setHeroName("iron fist");
        hero.setIssueOne("defenders#1");
        hero.setDescription("one punch man");
        hero.setId(0l);
        heroine.getHeroName();
        heroine.getDescription();
        heroine.getIssueOne();
        heroine.getId();
        heroList.add(hero);
        heroList.add(heroine);

        when(repository.findAll()).thenReturn(heroList);

        assertEquals(heroController.listAllHeroes().get(0).getHeroName(),"iron fist");
        assertEquals(heroController.listAllHeroes().get(0).getDescription(),"one punch man");
        assertEquals(heroController.listAllHeroes().get(0).getIssueOne(),"defenders#1");

    }
    @Test
    public void testGetAllHeroes(){
        List<Hero> heroesList = new ArrayList<>();
        Hero hero = new Hero();
        hero.setDescription("good guy");
        hero.setHeroName("hero");
        hero.setIssueOne("#1");
        heroesList.add(hero);

        when(repository.findAll()).thenReturn(heroesList);

        assertEquals(heroController.listAllHeroes().get(0).getHeroName(), "hero");
    }
    @Test
    public void testGetHero(){

        Hero hero= new Hero();
        hero.setDescription("okay guy");
        hero.setHeroName("blake");
        hero.setId(3l);


        when(repository.findOne(3l)).thenReturn(hero);
        assertEquals(heroController.getHero(3l).getHeroName(), "blake");
    }

    @Test
    public void testAddHero(){
        Hero hero = new Hero();
        hero.setDescription("director");
        hero.setHeroName("russo");
        hero.setId(1l);

        when(repository.saveAndFlush(hero)).thenReturn(hero);
        assertEquals(heroController.addHero(hero).getHeroName(),"russo");

    }
    @Test
    public void testDeleteHero(){

        Hero hero = new Hero();
        hero.setDescription("best hero");
        hero.setHeroName("captain cool");
        hero.setId(7l);
        when(repository.findOne(7l)).thenReturn(hero);
        repository.delete(7l);
        assertEquals( heroController.deleteHero(7l),hero);
    }
    @Test
    public void testUpdateHero(){

        Hero hero= new Hero();
        hero.setId(1L);
        hero.setHeroName("IronMan");
        hero.setDescription("man of fe");

        when(repository.findOne(1L)).thenReturn(hero);
        assertEquals(heroController.updateHero(1L, hero).getHeroName(), "IronMan");
    }




}
