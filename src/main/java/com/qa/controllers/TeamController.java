package com.qa.controllers;


import com.qa.repository.HeroRepository;
import com.qa.model.Hero;
import com.qa.model.Team;
import com.qa.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin()
public class TeamController {

    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping(value = "teams", method = RequestMethod.GET)
    public List<Team> listAllTeams() {
        return teamRepository.findAll();
    }

    @RequestMapping(value = "team", method = RequestMethod.POST)
    public Team addTeam(@RequestBody Team team) {
        return teamRepository.saveAndFlush(team);
    }

    @RequestMapping(value = "team/{id}", method = RequestMethod.GET)
    public Team getTeam(@PathVariable Long id) {
        return teamRepository.findOne(id);
    }

    @RequestMapping(value = "team/{id}", method = RequestMethod.DELETE)
    public Team deleteTeam(@PathVariable Long id) {
        Team existing = teamRepository.findOne(id);
        teamRepository.delete(existing);
        return existing;
    }

    @Transactional
    @RequestMapping(value = "team/{id}", method = RequestMethod.PUT)
    public Team updateTeam(@PathVariable Long id, @RequestBody Team team) {
        Team ex = teamRepository.findOne(id);
        ex.setTeam(team);
        return ex;
    }
}
