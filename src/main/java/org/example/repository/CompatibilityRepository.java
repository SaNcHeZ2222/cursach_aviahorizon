package org.example.repository;

import org.example.model.Compatibility;
import org.example.model.Horizon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompatibilityRepository extends JpaRepository<Compatibility, Long> {
    List<Compatibility> findByHorizon(Horizon horizon);
    List<Compatibility> findByHorizonId(Long horizonId);

}
