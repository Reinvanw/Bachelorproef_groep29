package no_wire.no_wire.networkswitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import no_wire.no_wire.networkswitch.model.NetworkSwitch;
import no_wire.no_wire.networkswitch.model.SwitchStatus;
import no_wire.no_wire.networkswitch.service.NetworkSwitchService;

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
@RequestMapping("/networkswitch")
public class NetworkSwitchRestController {

    @Autowired
    private NetworkSwitchService networkSwitchService;

    @GetMapping("/all")
    public List<NetworkSwitch> getAllNetworkSwitchs() {
        return networkSwitchService.getAllNetworkSwitches();
    }

    @GetMapping("/status/{switchId}")
    public SwitchStatus getSwitchStatus(@PathVariable long switchId) {
        return networkSwitchService.getSwitchStatus(switchId);
    }

    @GetMapping("/reset/{switchId}/oldIpAddress/{oldIpAddress}")
    public void resetSwitch(@PathVariable long switchId, @PathVariable String oldIpAddress) {
        // networkSwitchService.resetSwitch(switchId, oldIpAddress);
    }

    @PostMapping("/add/switch/{hostname}/ipAddress/{ipAddress}")
    public NetworkSwitch addNewSwitch(@PathVariable String hostname, @PathVariable String ipAddress) {
        return networkSwitchService.addNewSwitch(hostname, ipAddress);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ IllegalArgumentException.class })
    public Map<String, String> handleIllegalArgumentExceptions(IllegalArgumentException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }
}