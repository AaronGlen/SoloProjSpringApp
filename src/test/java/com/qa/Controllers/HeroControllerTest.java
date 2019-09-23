package com.qa.Controllers;


import com.qa.controllers.HeroController;
import com.qa.model.Hero;
import com.qa.repository.HeroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
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

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

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




}
