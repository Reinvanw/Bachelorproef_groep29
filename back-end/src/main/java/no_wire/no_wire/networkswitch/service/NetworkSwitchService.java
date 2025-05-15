package no_wire.no_wire.networkswitch.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no_wire.no_wire.networkswitch.model.NetworkSwitch;
import no_wire.no_wire.networkswitch.model.SwitchStatus;
import no_wire.no_wire.networkswitch.repository.NetworkSwitchRepository;
import no_wire.no_wire.ping.model.Ping;
import no_wire.no_wire.ping.service.PingService;

@Service
public class NetworkSwitchService {
    StringBuilder output = new StringBuilder();
    boolean reachable = false;

    @Autowired
    private NetworkSwitchRepository networkswitchRepository;

    @Autowired
    private PingService pingService;

    public List<NetworkSwitch> getAllNetworkSwitches() {
        return networkswitchRepository.findAll();
    }

    public NetworkSwitch getNetworkSwitchById(String switchId) {
        NetworkSwitch networkSwitch = networkswitchRepository.findById(Long.parseLong(switchId));
        if (networkSwitch == null)
            throw new IllegalArgumentException("Switch not found");
        return networkSwitch;
    }

    public SwitchStatus getSwitchStatus(String switchId) {
        NetworkSwitch networkSwitch = getNetworkSwitchById(switchId);
        Ping pingResponse = pingService.ping(networkSwitch.getManagementIP());
        if (pingResponse.isReachable())
            return SwitchStatus.ONLINE;
        else
            return SwitchStatus.OFFLINE;
    }

    public NetworkSwitch addNewSwitch(String hostname, String ipAddress) {
        this.isExistingIpAddress(ipAddress);
        NetworkSwitch networkSwitch = new NetworkSwitch(hostname, ipAddress);
        return networkswitchRepository.save(networkSwitch);
    }

    public void isExistingIpAddress(String ipAddress) {
        NetworkSwitch networkSwitch = networkswitchRepository.findByManagementIP(ipAddress);
        if (networkSwitch != null)
            throw new IllegalArgumentException("IP address already assigned to a switch");
    }

    public void resetSwitch(String switchId, String oldIpAddress) {
        // TODO
    }
}