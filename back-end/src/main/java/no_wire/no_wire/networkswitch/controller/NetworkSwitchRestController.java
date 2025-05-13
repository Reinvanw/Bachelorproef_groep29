package no_wire.no_wire.networkswitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import no_wire.no_wire.networkswitch.model.NetworkSwitch;
import no_wire.no_wire.networkswitch.service.NetworkSwitchService;


import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

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

}