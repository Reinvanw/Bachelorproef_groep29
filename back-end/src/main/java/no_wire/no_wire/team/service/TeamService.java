package no_wire.no_wire.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no_wire.no_wire.team.model.Team;
import no_wire.no_wire.team.repository.TeamRepository;



@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

}