package org.example.model;

import jakarta.persistence.*;
import org.example.model.Horizon;

@Entity
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "horizon_id")
    private Horizon horizon;

    private String featureName;
    private String featureDescription;

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

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }
}
