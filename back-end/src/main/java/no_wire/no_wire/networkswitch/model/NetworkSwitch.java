package no_wire.no_wire.networkswitch.model;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "switch")
public class NetworkSwitch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long switchID;

    @NotBlank(message = "Username is required")
    private String userName;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Management IP is required")
    @Pattern(regexp = "^([0-9]{1,3}\\.){3}[0-9]{1,3}$", message = "Invalid IP format")
    private String managementIP;

    @NotBlank(message = "Hostname is required")
    private String hostname;

    public NetworkSwitch(String managementIP, String hostname) {
        this.userName = generateUsername();
        this.password = generatePassword();
        this.managementIP = managementIP;
        this.hostname = hostname;
    }

    private String generateUsername() {
        return "switch-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase();
    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(12);
    }
}
