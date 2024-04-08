package pl.dmcs.iwalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.iwalecture.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
