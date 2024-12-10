package org.example.model;

import jakarta.persistence.*;

@Entity
public class Compatibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "horizon_id", nullable = false)
    private Horizon horizon;

    @Column(nullable = false)
    private String aircraftType;

    private String autopilotCompatibility;

    // Геттеры и сеттеры
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

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getAutopilotCompatibility() {
        return autopilotCompatibility;
    }

    public void setAutopilotCompatibility(String autopilotCompatibility) {
        this.autopilotCompatibility = autopilotCompatibility;
    }
}
