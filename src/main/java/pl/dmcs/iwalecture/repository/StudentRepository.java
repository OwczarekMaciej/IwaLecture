package pl.dmcs.iwalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.iwalecture.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(long id);
}
