package no_wire.no_wire;

import no_wire.no_wire.networkswitch.model.NetworkSwitch;
import no_wire.no_wire.team.model.Team;
import no_wire.no_wire.user.model.User;
import no_wire.no_wire.user.model.Role;
import no_wire.no_wire.team.repository.TeamRepository;
import no_wire.no_wire.user.repository.UserRepository;
import no_wire.no_wire.networkswitch.repository.NetworkSwitchRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataBaseSeeder {

@Bean
public CommandLineRunner seedData(UserRepository userRepository,
        TeamRepository teamRepository,
        NetworkSwitchRepository networkSwitchRepository, PasswordEncoder passwordEncoder) {
    return args -> {

        // Delete all existing data
        userRepository.deleteAll();
        teamRepository.deleteAll();
        networkSwitchRepository.deleteAll();

        // Create lecturer
        User lecturer = new User("robin@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_LECTURER);
        userRepository.save(lecturer);

        // Create students
        User user1 = new User("user1@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_STUDENT);
        userRepository.save(user1);
        User user2 = new User("user2@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_STUDENT);
        userRepository.save(user2);
        User user3 = new User("user3@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_STUDENT);
        userRepository.save(user3);
        User user4 = new User("user4@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_STUDENT);
        userRepository.save(user4);
        User user5 = new User("user5@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_STUDENT);
        userRepository.save(user5);
        User user6 = new User("user6@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_STUDENT);
        userRepository.save(user6);
        User user7 = new User("user7@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_STUDENT);
        userRepository.save(user7);
        User user8 = new User("user8@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_STUDENT);
        userRepository.save(user8);
        User user9 = new User("user9@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_STUDENT);
        userRepository.save(user9);
        User user10 = new User("user10@ucll.be", passwordEncoder.encode("password123"), Role.ROLE_STUDENT);
        userRepository.save(user10);

        // Create switches
        NetworkSwitch networkSwitch1 = new NetworkSwitch("192.168.1.1", "switch1");
        networkSwitchRepository.save(networkSwitch1);
        NetworkSwitch networkSwitch2 = new NetworkSwitch("10.0.0.254", "switch2");
        networkSwitchRepository.save(networkSwitch2);
        NetworkSwitch networkSwitch3 = new NetworkSwitch("172.16.0.0", "switch3");
        networkSwitchRepository.save(networkSwitch3);
        NetworkSwitch networkSwitch4 = new NetworkSwitch("192.168.10.1", "switch4");
        networkSwitchRepository.save(networkSwitch4);
        NetworkSwitch networkSwitch5 = new NetworkSwitch("10.10.10.1", "switch5");
        networkSwitchRepository.save(networkSwitch5);

        // Create teams
        List usersOfTeam1 = new ArrayList<User>();
        usersOfTeam1.add(user1);
        usersOfTeam1.add(user2);
        Team team1 = new Team("Team Alpha", networkSwitch1, usersOfTeam1);
        teamRepository.save(team1);

        List usersOfTeam2 = new ArrayList<User>();
        usersOfTeam2.add(user3);
        usersOfTeam2.add(user4);
        Team team2 = new Team("Team Beta", networkSwitch2, usersOfTeam2);
        teamRepository.save(team2);

        List usersOfTeam3 = new ArrayList<User>();
        usersOfTeam3.add(user5);
        Team team3 = new Team("Team Gamma", networkSwitch3, usersOfTeam3);
        teamRepository.save(team3);

        List usersOfTeam4 = new ArrayList<User>();
        usersOfTeam4.add(user6);
        usersOfTeam4.add(user7);
        Team team4 = new Team("Team Delta", null, usersOfTeam4); // team zonder switch
        teamRepository.save(team4);

        Team team5 = new Team("Team Epsilon", networkSwitch4, null); // team zonder users
        teamRepository.save(team5);

        Team team6 = new Team("Team Zeta", null, null); // volledig lege team
        teamRepository.save(team6);

        List usersOfTeam7 = new ArrayList<User>();
        usersOfTeam7.add(user8);
        usersOfTeam7.add(user9);
        usersOfTeam7.add(user10);
        Team team7 = new Team("Team Theta", networkSwitch5, usersOfTeam7);
        teamRepository.save(team7);

        System.out.println("Database seeded successfully with extended mock data!");
    };
}

}
