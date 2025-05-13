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
    private Long switchID;

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

    // Getters and Setters

    private String generateUsername() {
        return "switch-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase();
    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(12);
    }

    public Long getId() {
        return switchID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getManagementIP() {
        return managementIP;
    }

    public String getHostname() {
        return hostname;
    }

    public void setId(Long id) {
        this.switchID = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setManagementIP(String managementIP) {
        this.managementIP = managementIP;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
