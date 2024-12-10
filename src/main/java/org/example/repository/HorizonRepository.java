package org.example.repository;

import org.example.model.Horizon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface HorizonRepository extends JpaRepository<Horizon, Long> {
    List<Horizon> findByBrandAndModel(String brand, String model);

    List<Horizon> findByBrand(String brand);

    @Query(value = "SELECT h.id, h.name, h.brand, h.model, h.description, h.year_of_manufacture, h.production_status, " +
            "m.id AS manufacturer_id, m.name AS manufacturer_name, m.country AS manufacturer_country, " +
            "m.contact_details AS manufacturer_contact_details, m.website AS manufacturer_website " +
            "FROM horizon h " +
            "JOIN manufacturer m ON h.manufacturer_id = m.id " +
            "WHERE h.id = :id", nativeQuery = true)
    Optional<Object[]> findHorizonById(@Param("id") Long id);

    @Query(value = """
        SELECT h.id AS id, h.name AS name, h.brand AS brand, h.model AS model, 
               h.description AS description, h.year_of_manufacture AS yearOfManufacture, 
               h.production_status AS productionStatus, 
               MAX(s.min_operating_temperature) AS minOperatingTemperature, 
               MAX(s.max_operating_temperature) AS maxOperatingTemperature, 
               MAX(s.accuracy) AS accuracy 
        FROM horizon h 
        JOIN specifications s ON s.horizon_id = h.id 
        WHERE s.accuracy BETWEEN :minAccuracy AND :maxAccuracy
        GROUP BY h.id, h.name, h.brand, h.model, h.description, h.year_of_manufacture, h.production_status
        """, nativeQuery = true)
    List<Map<String, Object>> findHorizonsByAccuracyRange(@Param("minAccuracy") BigDecimal minAccuracy,
                                                          @Param("maxAccuracy") BigDecimal maxAccuracy);



}

