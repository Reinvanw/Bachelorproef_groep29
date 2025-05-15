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

@Configuration
public class DataBaseSeeder {

    @Bean
    public CommandLineRunner seedData(UserRepository userRepository,
            TeamRepository teamRepository,
            NetworkSwitchRepository networkSwitchRepository) {
        return args -> {

            // Delete all existing data
            userRepository.deleteAll();
            teamRepository.deleteAll();
            networkSwitchRepository.deleteAll();

            // Create lecturer
            User lecturer = new User("robin@example.com", "password789", Role.ROLE_LECTURER);
            userRepository.save(lecturer);

            // Create students
            User user1 = new User("user1@example.com", "password123", Role.ROLE_STUDENT);
            userRepository.save(user1);
            User user2 = new User("user2@example.com", "password456", Role.ROLE_STUDENT);
            userRepository.save(user2);
            User user3 = new User("user3@example.com", "password123", Role.ROLE_STUDENT);
            userRepository.save(user3);
            User user4 = new User("user4@example.com", "password456", Role.ROLE_STUDENT);
            userRepository.save(user4);
            User user5 = new User("user5@example.com", "password456", Role.ROLE_STUDENT);
            userRepository.save(user5);

            // Create switches
            NetworkSwitch networkSwitch1 = new NetworkSwitch("192.168.1.1", "switch1");
            networkSwitchRepository.save(networkSwitch1);
            NetworkSwitch networkSwitch2 = new NetworkSwitch("10.0.0.254", "switch2");
            networkSwitchRepository.save(networkSwitch2);
            NetworkSwitch networkSwitch3 = new NetworkSwitch("172.16.0.0", "switch3");
            networkSwitchRepository.save(networkSwitch3);

            // Create a Team instance using constructor
            List usersOfTeam1 = new ArrayList<User>();
            usersOfTeam1.add(user1);
            usersOfTeam1.add(user2);
            usersOfTeam1.add(user3);
            Team team1 = new Team("Team Alpha", networkSwitch1, usersOfTeam1);
            teamRepository.save(team1);

            List usersOfTeam2 = new ArrayList<User>();
            usersOfTeam2.add(user4);
            usersOfTeam2.add(user5);
            Team team2 = new Team("Team Beta", networkSwitch2, usersOfTeam2);
            teamRepository.save(team2);

            Team team3 = new Team("Team Beta", null, null);
            teamRepository.save(team3);

            System.out.println("Database seeded successfully!");
        };
    }
}
