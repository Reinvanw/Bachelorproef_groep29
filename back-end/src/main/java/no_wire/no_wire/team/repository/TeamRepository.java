package no_wire.no_wire.team.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import no_wire.no_wire.team.model.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    public Team findById(long id);

    public List<Team> findAll();



}
