package no_wire.no_wire.team.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no_wire.no_wire.networkswitch.model.NetworkSwitch;
import no_wire.no_wire.networkswitch.service.NetworkSwitchService;
import no_wire.no_wire.team.model.Team;
import no_wire.no_wire.team.repository.TeamRepository;
import no_wire.no_wire.user.model.User;
import no_wire.no_wire.user.service.UserService;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private NetworkSwitchService networkSwitchService;

    @Autowired
    private UserService userService;
  

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(long teamId) {
        Team team = teamRepository.findById(teamId);
        if (team == null)
            throw new IllegalArgumentException("Team not found");
        return team;
    }

    public Team addSwitchToTeam(long teamId, long switchId) {
        Team team = getTeamById(teamId);
        if (team.getNetworkSwitch() != null)
            throw new IllegalArgumentException("Team already has a switch assigned");
        NetworkSwitch networkSwitch = networkSwitchService.getNetworkSwitchById(switchId);
        team.setNetworkSwitch(networkSwitch);
        return teamRepository.save(team);
    }

    public NetworkSwitch getSwitchOfTeam(long teamId) {
        Team team = getTeamById(teamId);
        NetworkSwitch networkSwitch = team.getNetworkSwitch();
        if (networkSwitch == null)
            throw new IllegalArgumentException("No switch assigned to this team");
        return networkSwitch;
    }
    public void deleteTeam(long id) {
        Team team = teamRepository.findById(id);
        if (team == null) {
            throw new IllegalArgumentException("Team not found");
        }
        teamRepository.deleteById(id);
    }
public Team addUserToTeam(long teamId, long userId) {
    Team team = getTeamById(teamId);
    User user = userService.getUserById(userId);
    if (user == null) {
        throw new IllegalArgumentException("User not found");
    }
    if (team.getUsers() == null) {
        team.setUsers(new ArrayList<>());
    }
    if (team.getUsers().contains(user)) {
        throw new IllegalArgumentException("User already in team");
    }
    team.getUsers().add(user);
    return teamRepository.save(team);
}

}