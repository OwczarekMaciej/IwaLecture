package pl.dmcs.iwalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.iwalecture.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
