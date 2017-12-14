package com.xmart.reservationterrain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
@Entity
public class Terrain implements Serializable {
    @Id
    @GeneratedValue
    private Long TerrainId;
    private int type;
    @OneToMany(mappedBy = "terrain")
    private Collection<Reservation> reservations;
    @OneToMany(mappedBy = "terrain")
    private Collection<ReparationLumiere> reparationLumieres;
    @OneToMany(mappedBy = "terrain")
    private Collection<ChangementPelouse> changementPelouses;

    public Terrain() {
    }

    public Terrain(Long terrainId, int type, Collection<Reservation> reservations, Collection<ReparationLumiere> reparationLumieres, Collection<ChangementPelouse> changementPelouses) {

        TerrainId = terrainId;
        this.type = type;
        this.reservations = reservations;
        this.reparationLumieres = reparationLumieres;
        this.changementPelouses = changementPelouses;
    }

    public Long getTerrainId() {
        return TerrainId;
    }

    public void setTerrainId(Long terrainId) {
        TerrainId = terrainId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    @JsonIgnore
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }
    @JsonIgnore
    public Collection<ReparationLumiere> getReparationLumieres() {
        return reparationLumieres;
    }

    public void setReparationLumieres(Collection<ReparationLumiere> reparationLumieres) {
        this.reparationLumieres = reparationLumieres;
    }
    @JsonIgnore
    public Collection<ChangementPelouse> getChangementPelouses() {
        return changementPelouses;
    }

    public void setChangementPelouses(Collection<ChangementPelouse> changementPelouses) {
        this.changementPelouses = changementPelouses;
    }
}
