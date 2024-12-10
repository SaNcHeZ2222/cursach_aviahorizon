package org.example.repository;

import org.example.model.Certificates;
import org.example.model.Horizon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CertificatesRepository extends JpaRepository<Certificates, Long> {
    List<Certificates> findByHorizon(Horizon horizon);
    List<Certificates> findByHorizonId(Long horizonId);
}
