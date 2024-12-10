package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    private String contactDetails;
    private String website;

    // Если есть обратная ссылка на Horizon, игнорируем её для предотвращения рекурсии
    @OneToMany(mappedBy = "manufacturer")
    @JsonIgnore // Это игнорирует цикл
    private List<Horizon> horizons;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // другие геттеры и сеттеры
}
