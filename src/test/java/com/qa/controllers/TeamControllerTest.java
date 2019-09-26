package com.qa.controllers;


import com.qa.model.Team;
import com.qa.repository.TeamRepository;
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

public class TeamControllerTest {

    @InjectMocks
    private TeamController teamController;

    @Mock
    private TeamRepository repository;

    @Test
    public void testTeam(){
        List<Team> teamsList = new ArrayList<>();
        Team team = new Team();
        Team team2 = new Team("a-force","a-force#1","all female team");
        team.setTeamName("avengers");
        team.setIssueOne("avengers#1");
        team.setDescription("worlds mightiest heroes");
        team.setId(0l);
        team2.getTeamName();
        team2.getDescription();
        team2.getIssueOne();
        team2.getId();
        teamsList.add(team);
        teamsList.add(team2);

        when(repository.findAll()).thenReturn(teamsList);

        assertEquals(teamController.listAllTeams().get(0).getTeamName(),"avengers");
        assertEquals(teamController.listAllTeams().get(0).getDescription(),"worlds mightiest heroes");
        assertEquals(teamController.listAllTeams().get(0).getIssueOne(),"avengers#1");
    }

    @Test
    public void testGetAllTeams(){
        List<Team> teamsList = new ArrayList<>();
        Team team = new Team();
        team.setDescription("female super team");
        team.setTeamName("A-force");
        team.setIssueOne("#1");
        teamsList.add(team);

        when(repository.findAll()).thenReturn(teamsList);

        assertEquals(teamController.listAllTeams().get(0).getTeamName(), "A-force");
    }

    @Test
    public void testGetTeam(){

        Team team = new Team();
        team.setDescription("old x-men");
        team.setTeamName("X-men Gold");
        team.setId(3l);


        when(repository.findOne(3l)).thenReturn(team);
        assertEquals(teamController.getTeam(3l).getTeamName(), "X-men Gold");
    }

    @Test
    public void testAddTeam(){
        Team team = new Team();
        team.setDescription("young x-men");
        team.setTeamName("X-men Blue");
        team.setId(3l);



        when(repository.saveAndFlush(team)).thenReturn(team);
        assertEquals(teamController.addTeam(team).getTeamName(),"X-men Blue");
    }
    @Test
    public void testDeleteTeam(){

        Team team = new Team();
        team.setDescription("good team");
        team.setTeamName("super pet squad");
        team.setId(7l);


        when(repository.findOne(7l)).thenReturn(team);
        repository.delete(7l);
        assertEquals( teamController.deleteTeam(7l),team);
    }
    @Test
    public void testUpdateTeam(){

        Team team= new Team();
        team.setId(1L);
        team.setTeamName("Avengers");
        team.setDescription("worlds strongest heroes  ");

        when(repository.findOne(1L)).thenReturn(team);
        assertEquals(teamController.updateTeam(1L, team).getTeamName(), "Avengers");
    }




}
