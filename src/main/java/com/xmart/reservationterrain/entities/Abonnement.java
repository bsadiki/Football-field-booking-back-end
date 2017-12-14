package com.xmart.reservationterrain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Abonnement implements Serializable{
    @Id @GeneratedValue
    private Long abonnementId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tel_client")
    private Client client;
    private LocalDate start;
    private LocalDate end;
    private int duree;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "seance_id")
    private Seance seance;
    private int type;

    public Abonnement() {
    }

    public Abonnement(Client client, LocalDate start, LocalDate end, int duree, Seance seance, int type) {
        this.client = client;
        this.start = start;
        this.end = end;
        this.duree = duree;
        this.seance = seance;
        this.type = type;
    }

    public Long getAbonnementId() {
        return abonnementId;
    }

    public void setAbonnementId(Long abonnementId) {
        this.abonnementId = abonnementId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public int getDuree() {

        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
