package no_wire.no_wire;

import no_wire.no_wire.networkswitch.model.NetworkSwitch;
import no_wire.no_wire.team.model.Team;
import no_wire.no_wire.user.model.User;
import no_wire.no_wire.user.model.Role;
import no_wire.no_wire.team.repository.TeamRepository;
import no_wire.no_wire.user.repository.UserRepository;
import no_wire.no_wire.networkswitch.repository.NetworkSwitchRepository;

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

            // Create a NetworkSwitch instance using constructor
            NetworkSwitch networkSwitch = new NetworkSwitch("192.168.1.1", "switch1");
            networkSwitchRepository.save(networkSwitch);

            // Create a Team instance using constructor
            Team team = new Team("Team Alpha");
            teamRepository.save(team);

            // Create Users and associate them with the Team using constructor
            if (userRepository.findByEmail("user1@example.com").isEmpty()) {
                User user1 = new User("user1@example.com", "password123", Role.ROLE_LECTURER);
                userRepository.save(user1);
            }

            if (userRepository.findByEmail("user2@example.com").isEmpty()) {
                User user2 = new User("user2@example.com", "password456", Role.ROLE_LECTURER);
                userRepository.save(user2);
            }

            if (userRepository.findByEmail("user3@example.com").isEmpty()) {
                User user3 = new User("Robin@example.com", "password789", Role.ROLE_LECTURER);
                userRepository.save(user3);
            }

            System.out.println("Database seeded successfully!");
        };
    }
}
