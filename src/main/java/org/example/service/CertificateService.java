package org.example.service;

import org.example.model.Certificates;
import org.example.repository.CertificatesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {
    private final CertificatesRepository certificateRepository;

    public CertificateService(CertificatesRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    public List<Certificates> getCertificatesByHorizonId(Long horizonId) {
        return certificateRepository.findByHorizonId(horizonId);
    }
}
