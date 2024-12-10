package org.example.repository;

import org.example.model.FirmwareUpdates;
import org.example.model.Horizon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FirmwareUpdatesRepository extends JpaRepository<FirmwareUpdates, Long> {
    List<FirmwareUpdates> findByHorizon(Horizon horizon);
}
