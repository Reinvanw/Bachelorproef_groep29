package no_wire.no_wire.networkswitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import no_wire.no_wire.networkswitch.model.NetworkSwitch;

import java.util.List;

public interface NetworkSwitchRepository extends JpaRepository<NetworkSwitch, Long> {
    public NetworkSwitch findById(long id);

    public List<NetworkSwitch> findAll();

    public NetworkSwitch findByManagementIP(String managementIP);
}
