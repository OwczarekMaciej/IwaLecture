package pl.dmcs.iwalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.iwalecture.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
