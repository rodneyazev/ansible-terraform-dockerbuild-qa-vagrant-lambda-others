package br.com.caelum.clines.shared.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aircraft_models")
public class AircraftModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;


    public AircraftModel(String description) {
        this.description = description;
    }
}
