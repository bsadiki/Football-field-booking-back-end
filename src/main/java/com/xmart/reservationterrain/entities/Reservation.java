package com.xmart.reservationterrain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue
    private Long reservationId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tel_client")
    private Client client;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;
    private LocalDateTime date;
    private boolean valide;
    public Reservation() {
    }

    public Reservation(Client client, Terrain terrain, LocalDateTime date) {
        this.client = client;
        this.terrain = terrain;
        this.date = date;
    }

    public Reservation(Client client, Terrain terrain, LocalDateTime date, boolean valide) {
        this.client = client;
        this.terrain = terrain;
        this.date = date;
        this.valide = valide;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }
}
