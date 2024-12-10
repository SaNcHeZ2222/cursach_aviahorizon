package org.example.repository;

import org.example.model.Features;
import org.example.model.Horizon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeaturesRepository extends JpaRepository<Features, Long> {
    List<Features> findByHorizon(Horizon horizon);
}
