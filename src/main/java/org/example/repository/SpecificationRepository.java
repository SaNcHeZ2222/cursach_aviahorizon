package org.example.repository;

import org.example.model.Specifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationRepository extends JpaRepository<Specifications, Long> {
    List<Specifications> findByHorizonId(Long horizonId);
    List<Specifications> findByHorizonIdAndMaterial(Long horizonId, String material);


}