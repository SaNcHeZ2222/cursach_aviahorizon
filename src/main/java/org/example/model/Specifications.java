package org.example.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Specifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "horizon_id", nullable = false)
    private Horizon horizon;

    private BigDecimal minOperatingTemperature;
    private BigDecimal maxOperatingTemperature;
    private BigDecimal minStorageTemperature;
    private BigDecimal maxStorageTemperature;
    private BigDecimal operatingVoltage;
    private BigDecimal powerConsumption;
    private BigDecimal maxOverload;
    private BigDecimal minAngleRoll;
    private BigDecimal maxAngleRoll;
    private BigDecimal minAnglePitch;
    private BigDecimal maxAnglePitch;
    private BigDecimal accuracy;
    private BigDecimal responseSpeed;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal depth;
    private BigDecimal weight;
    private String protectionLevel;
    private BigDecimal vibrationResistance;
    private String material;
    private String mountingType;
    private BigDecimal radiationResistance;
    private BigDecimal altitudeOperability;
    private Boolean diagnosticSupport;
    private Boolean autoCalibration;

    public Horizon getHorizon() {
        return horizon;
    }

    public void setHorizon(Horizon horizon) {
        this.horizon = horizon;
    }

    public BigDecimal getMinOperatingTemperature() {
        return minOperatingTemperature;
    }

    public void setMinOperatingTemperature(BigDecimal minOperatingTemperature) {
        this.minOperatingTemperature = minOperatingTemperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMaxOverload() {
        return maxOverload;
    }

    public void setMaxOverload(BigDecimal maxOverload) {
        this.maxOverload = maxOverload;
    }

    public BigDecimal getMinAngleRoll() {
        return minAngleRoll;
    }

    public void setMinAngleRoll(BigDecimal minAngleRoll) {
        this.minAngleRoll = minAngleRoll;
    }

    public BigDecimal getMaxAngleRoll() {
        return maxAngleRoll;
    }

    public void setMaxAngleRoll(BigDecimal maxAngleRoll) {
        this.maxAngleRoll = maxAngleRoll;
    }

    public BigDecimal getMinAnglePitch() {
        return minAnglePitch;
    }

    public void setMinAnglePitch(BigDecimal minAnglePitch) {
        this.minAnglePitch = minAnglePitch;
    }

    public BigDecimal getMaxAnglePitch() {
        return maxAnglePitch;
    }

    public void setMaxAnglePitch(BigDecimal maxAnglePitch) {
        this.maxAnglePitch = maxAnglePitch;
    }

    public BigDecimal getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

    public BigDecimal getResponseSpeed() {
        return responseSpeed;
    }

    public void setResponseSpeed(BigDecimal responseSpeed) {
        this.responseSpeed = responseSpeed;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getVibrationResistance() {
        return vibrationResistance;
    }

    public void setVibrationResistance(BigDecimal vibrationResistance) {
        this.vibrationResistance = vibrationResistance;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMountingType() {
        return mountingType;
    }

    public void setMountingType(String mountingType) {
        this.mountingType = mountingType;
    }

    public BigDecimal getRadiationResistance() {
        return radiationResistance;
    }

    public void setRadiationResistance(BigDecimal radiationResistance) {
        this.radiationResistance = radiationResistance;
    }

    public BigDecimal getAltitudeOperability() {
        return altitudeOperability;
    }

    public void setAltitudeOperability(BigDecimal altitudeOperability) {
        this.altitudeOperability = altitudeOperability;
    }

    public Boolean getDiagnosticSupport() {
        return diagnosticSupport;
    }

    public void setDiagnosticSupport(Boolean diagnosticSupport) {
        this.diagnosticSupport = diagnosticSupport;
    }

    public Boolean getAutoCalibration() {
        return autoCalibration;
    }

    public void setAutoCalibration(Boolean autoCalibration) {
        this.autoCalibration = autoCalibration;
    }

    public BigDecimal getMaxOperatingTemperature() {
        return maxOperatingTemperature;
    }

    public void setMaxOperatingTemperature(BigDecimal maxOperatingTemperature) {
        this.maxOperatingTemperature = maxOperatingTemperature;
    }

    public BigDecimal getMinStorageTemperature() {
        return minStorageTemperature;
    }

    public void setMinStorageTemperature(BigDecimal minStorageTemperature) {
        this.minStorageTemperature = minStorageTemperature;
    }

    public BigDecimal getMaxStorageTemperature() {
        return maxStorageTemperature;
    }

    public void setMaxStorageTemperature(BigDecimal maxStorageTemperature) {
        this.maxStorageTemperature = maxStorageTemperature;
    }

    public String getProtectionLevel() {
        return protectionLevel;
    }

    public void setProtectionLevel(String protectionLevel) {
        this.protectionLevel = protectionLevel;
    }

    public BigDecimal getOperatingVoltage() {
        return operatingVoltage;
    }

    public void setOperatingVoltage(BigDecimal operatingVoltage) {
        this.operatingVoltage = operatingVoltage;
    }

    public BigDecimal getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(BigDecimal powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    // Геттеры и сеттеры
}
