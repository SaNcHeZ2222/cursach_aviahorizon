package org.example.service;

import org.example.model.Compatibility;
import org.example.repository.CompatibilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompatibilityService {
    private final CompatibilityRepository compatibilityRepository;

    public CompatibilityService(CompatibilityRepository compatibilityRepository) {
        this.compatibilityRepository = compatibilityRepository;
    }

    public List<Compatibility> getCompatibilitiesByHorizonId(Long horizonId) {
        return compatibilityRepository.findByHorizonId(horizonId);
    }
}
