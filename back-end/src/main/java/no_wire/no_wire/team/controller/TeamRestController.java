package no_wire.no_wire.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @GetMapping("/{teamId}/switch")
    public NetworkSwitch getSwitchOfTeam(@PathVariable String teamId) {
        return teamService.getSwitchOfTeam(teamId);
    }

    @PostMapping("/{teamId}/assign/switch/{switchId}")
    public Team addSwitchToTeam(@PathVariable String teamId, @PathVariable String switchId) {
        return teamService.addSwitchToTeam(teamId, switchId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ IllegalArgumentException.class })
    public Map<String, String> handleIllegalArgumentExceptions(IllegalArgumentException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }
}