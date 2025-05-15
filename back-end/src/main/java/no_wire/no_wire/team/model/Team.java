package no_wire.no_wire.team.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no_wire.no_wire.networkswitch.model.NetworkSwitch;
import no_wire.no_wire.user.model.User;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team")
public class Team {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long teamID;

    @NotNull(message = "Team name is required")
    private String teamName;

    @Builder.Default
    @OneToMany(mappedBy = "team")
    List<User> users = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "switchID")
    private NetworkSwitch networkSwitch;

    public Team(String teamName, NetworkSwitch networkSwitch, List<User> users) {
        setTeamName(teamName);
        if (networkSwitch != null)
            this.networkSwitch = networkSwitch;
        if (users != null)
            this.users = users;
    }
}