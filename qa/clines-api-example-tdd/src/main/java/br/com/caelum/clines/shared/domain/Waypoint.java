package br.com.caelum.clines.shared.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "waypoints")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Waypoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    @NotNull
    private LocalDateTime time;

    @NotNull
    private String gate;

    public Waypoint(Airport airport, LocalDateTime time, String gate) {
        this.airport = airport;
        this.time = time;
        this.gate = gate;
    }
}
