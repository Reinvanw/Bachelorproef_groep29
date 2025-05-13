package no_wire.no_wire.networkswitch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no_wire.no_wire.networkswitch.model.NetworkSwitch;
import no_wire.no_wire.networkswitch.repository.NetworkSwitchRepository;


@Service
public class NetworkSwitchService {

    @Autowired
    private NetworkSwitchRepository networkswitchRepository;

    public List<NetworkSwitch> getAllNetworkSwitches() {
        return networkswitchRepository.findAll();
    }

}