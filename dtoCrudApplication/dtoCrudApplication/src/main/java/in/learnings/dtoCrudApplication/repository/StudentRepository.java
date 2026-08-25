package in.learnings.dtoCrudApplication.repository;

import in.learnings.dtoCrudApplication.Enitity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByIdAndDeletedFalse(Long id);
    List<Student> findByDeletedFalse();
    boolean existsByEmail(String email);
}


