package com.xmart.reservationterrain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
public class ChangementPelouse implements Serializable {
    @Id
    @GeneratedValue
    private Long changementPelouseId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;
    private LocalDate journee;

    public ChangementPelouse() {
    }

    public ChangementPelouse(Terrain terrain, LocalDate journee) {
        this.terrain = terrain;
        this.journee = journee;
    }

    public Long getChangementPelouseId() {

        return changementPelouseId;
    }

    public void setChangementPelouseId(Long changementPelouseId) {
        this.changementPelouseId = changementPelouseId;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public LocalDate getJournee() {
        return journee;
    }

    public void setJournee(LocalDate journee) {
        this.journee = journee;
    }
}
