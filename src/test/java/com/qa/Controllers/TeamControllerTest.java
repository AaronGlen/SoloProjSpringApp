package com.qa.Controllers;


import com.qa.controllers.TeamController;
import com.qa.model.Team;
import com.qa.repository.TeamRepository;
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

public class TeamControllerTest {

    @InjectMocks
    private TeamController teamController;

    @Mock
    private TeamRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

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



}
