package com.xmart.reservationterrain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class ReparationLumiere implements Serializable {
    @Id
    @GeneratedValue
    private Long reparationLumiereId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;
    private LocalDateTime heure;

    public ReparationLumiere() {
    }

    public ReparationLumiere(Terrain terrain, LocalDateTime heure) {
        this.terrain = terrain;
        this.heure = heure;
    }

    public Long getReparationLumiereId() {
        return reparationLumiereId;
    }

    public void setReparationLumiereId(Long reparationLumiereId) {
        this.reparationLumiereId = reparationLumiereId;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public LocalDateTime getHeure() {
        return heure;
    }

    public void setHeure(LocalDateTime heure) {
        this.heure = heure;
    }
}
