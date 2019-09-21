package com.qa.controllers;

import com.qa.model.Hero;
import com.qa.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@CrossOrigin()
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @RequestMapping(value = "heroes", method = RequestMethod.GET)
    public List<Hero> listAllHeroes(){
        return heroRepository.findAll();
    }

    @RequestMapping(value = "hero", method = RequestMethod.POST)
    public Hero addHero(@RequestBody Hero hero){
        return heroRepository.saveAndFlush(hero);
    }

    @RequestMapping(value = "hero/{id}", method = RequestMethod.GET)
    public Hero getHero(@PathVariable Long id){
        return heroRepository.findOne(id);
    }

    @RequestMapping(value = "hero/{id}", method = RequestMethod.DELETE)
    public Hero deleteHero(@PathVariable Long id){
        Hero existing = heroRepository.findOne(id);
        heroRepository.delete(existing);
        return existing;
    }
    @Transactional
    @RequestMapping(value = "hero/{id}", method = RequestMethod.PUT)
    public Hero updateHero(@PathVariable Long id, @RequestBody Hero hero){
        Hero ex = heroRepository.findOne(id);
        ex.setHero(hero);
        return  ex;
    }



}
