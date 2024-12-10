package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Certificates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "horizon_id")
    private Horizon horizon;

    private String certificate_name;
    private String standard;

    private LocalDate issue_date;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Horizon getHorizon() {
        return horizon;
    }

    public void setHorizon(Horizon horizon) {
        this.horizon = horizon;
    }

    public LocalDate getIssuanceDate() {
        return issue_date;
    }

    public void setIssuanceDate(LocalDate issuanceDate) {
        this.issue_date = issuanceDate;
    }

    public String getCertificate_name() {
        return certificate_name;
    }

    public void setCertificate_name(String certificate_name) {
        this.certificate_name = certificate_name;
    }

    public String getStandart() {
        return standard;
    }

    public void setStandart(String standart) {
        this.standard = standart;
    }
}
