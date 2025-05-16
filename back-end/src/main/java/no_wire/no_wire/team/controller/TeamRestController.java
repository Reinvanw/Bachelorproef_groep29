package no_wire.no_wire.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import no_wire.no_wire.networkswitch.model.NetworkSwitch;
import no_wire.no_wire.team.model.Team;
import no_wire.no_wire.team.service.TeamService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/team")
public class TeamRestController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{teamId}")
    public Team getTeamById(@PathVariable long teamId) {
        return teamService.getTeamById(teamId);
    }

    @GetMapping("/{teamId}/switch")
    public NetworkSwitch getSwitchOfTeam(@PathVariable long teamId) {
        return teamService.getSwitchOfTeam(teamId);
    }

    @PostMapping("/{teamId}/assign/switch/{switchId}")
    public Team addSwitchToTeam(@PathVariable long teamId, @PathVariable long switchId) {
        return teamService.addSwitchToTeam(teamId, switchId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeam(@PathVariable long id) {
        teamService.deleteTeam(id);
    }

    @PostMapping("/{teamId}/add/{userId}")
    public Team addUserToTeam(@PathVariable long teamId, @PathVariable long userId) {
        return teamService.addUserToTeam(teamId, userId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ IllegalArgumentException.class })
    public Map<String, String> handleIllegalArgumentExceptions(IllegalArgumentException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }
}