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
    private NetworkSwitch switch0;

   public Team(String teamName) {
        setTeamName(teamName);
        users = new ArrayList<>();
      
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<User> getUsers() {
        return users;
    }


 
}
