package no_wire.no_wire.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no_wire.no_wire.team.model.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long userID;

    @Email(message = "Email should be a valid email address")
    private String email;

    @NotNull(message = "Password is required")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role is required")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "teamID")
    @JsonBackReference(value = "team-members")
    private Team team;

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}