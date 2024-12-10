package org.example.service;
import org.example.model.Horizon;

import org.example.model.Specifications;
import org.example.repository.HorizonRepository;
import org.example.repository.SpecificationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HorizonService {
    private final HorizonRepository horizonRepository;
    private final SpecificationRepository specificationRepository;

    public HorizonService(HorizonRepository horizonRepository, SpecificationRepository specificationRepository) {
        this.horizonRepository = horizonRepository;
        this.specificationRepository = specificationRepository;
    }


    public List<String> getAllBrands() {
        return horizonRepository.findAll()
                .stream()
                .map(Horizon::getBrand)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getModelsByBrand(String brand) {
        return horizonRepository.findByBrand(brand)
                .stream()
                .map(Horizon::getModel)
                .collect(Collectors.toList());
    }

    public List<Horizon> getAllHorizons() {
        return horizonRepository.findAll();
    }

    public Optional<Object[]> getHorizonById(Long id) {
        return horizonRepository.findHorizonById(id);
    }

    public List<Specifications> getSpecificationsByHorizonId(Long horizonId) {
        return specificationRepository.findByHorizonId(horizonId);
    }

    public List<Map<String, Object>> getHorizonsByAccuracyRange(BigDecimal minAccuracy, BigDecimal maxAccuracy) {
        return horizonRepository.findHorizonsByAccuracyRange(minAccuracy, maxAccuracy);
    }
}
