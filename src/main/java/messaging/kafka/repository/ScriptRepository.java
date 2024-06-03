package messaging.kafka.repository;

import messaging.kafka.entity.Script;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScriptRepository extends JpaRepository<Script,Long> {
    @Override
    Optional<Script> findById(Long id);
}
