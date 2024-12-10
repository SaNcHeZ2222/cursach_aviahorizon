package org.example.controller;

import org.example.model.Certificates;
import org.example.model.Compatibility;
import org.example.model.Horizon;
import org.example.model.Specifications;
import org.example.service.CompatibilityService;
import org.example.service.HorizonService;
import org.example.service.CertificateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/horizons")
public class HorizonApiController {

    private final HorizonService horizonService;
    private final CertificateService certificateService;
    private final CompatibilityService compatibilityService;

    public HorizonApiController(HorizonService horizonService, CertificateService certificateService, CompatibilityService compatibilityService) {
        this.horizonService = horizonService;
        this.certificateService = certificateService;
        this.compatibilityService = compatibilityService;
    }


    @GetMapping("/filter")
    public ResponseEntity<List<Map<String, Object>>> filterHorizonsByAccuracy(
            @RequestParam BigDecimal minAccuracy,
            @RequestParam BigDecimal maxAccuracy) {
        List<Map<String, Object>> results = horizonService.getHorizonsByAccuracyRange(minAccuracy, maxAccuracy);
        return ResponseEntity.ok(results);
    }


    @GetMapping("/brands")
    public List<String> getAllBrands() {
        return horizonService.getAllBrands(); // Возвращает список уникальных марок
    }

    @GetMapping("/models")
    public List<String> getModelsByBrand(@RequestParam String brand) {
        return horizonService.getModelsByBrand(brand); // Возвращает модели для выбранной марки
    }

    @GetMapping("/all")
    public List<Horizon> getAllHorizons() {
        return horizonService.getAllHorizons(); // Возвращает все горизонты
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getHorizonById(@PathVariable Long id) {
        Optional<Object[]> rawData = horizonService.getHorizonById(id);

        // Проверка на наличие данных
        if (rawData.isPresent()) {
            // Получаем первую строку данных
            Object[] row = (Object[]) rawData.get()[0];

            // Логирование данных для отладки
//            System.out.println("rawData: " + Arrays.deepToString(row));

            // Создаём карту для хранения данных горизонта
            Map<String, Object> horizonData = new HashMap<>();

                horizonData.put("id", row[0]);
                horizonData.put("name", row[1]);
                horizonData.put("brand", row[2]);
                horizonData.put("model", row[3]);
                horizonData.put("description", row[4]);
                horizonData.put("yearOfManufacture", row[5]);
                horizonData.put("productionStatus", row[6]);

                // Создаём и заполняем карту производителя
                Map<String, Object> manufacturer = new HashMap<>();
                manufacturer.put("id", row[7]);
                manufacturer.put("name", row[8]);
                manufacturer.put("country", row[9]);
                manufacturer.put("contactDetails", row[10]);
                manufacturer.put("website", row[11]);

                // Добавляем информацию о производителе в данные горизонта
                horizonData.put("manufacturer", manufacturer);

                // Возвращаем данные как JSON


                return ResponseEntity.ok(horizonData);
        } else {
            // Если данные по ID не найдены
            System.out.println("Ошибка: Горизонт с ID " + id + " не найден.");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{horizonId}/specifications")
    public List<Specifications> getSpecificationsByHorizonId(@PathVariable Long horizonId) {
        return horizonService.getSpecificationsByHorizonId(horizonId);
    }

    @GetMapping("/{horizonId}/certificates")
    public ResponseEntity<List<Certificates>> getCertificates(@PathVariable Long horizonId) {
        List<Certificates> certificates = certificateService.getCertificatesByHorizonId(horizonId);
        return ResponseEntity.ok(certificates);
    }

    @GetMapping("/{horizonId}/compatibilities")
    public List<Compatibility> getCompatibilitiesByHorizonId(@PathVariable Long horizonId) {
        return compatibilityService.getCompatibilitiesByHorizonId(horizonId);
    }

}
