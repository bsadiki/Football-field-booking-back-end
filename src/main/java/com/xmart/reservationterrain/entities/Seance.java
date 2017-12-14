package com.xmart.reservationterrain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Seance implements Serializable {
    @Id
    @GeneratedValue
    private long seanceId;
    private DayOfWeek jour;
    private LocalTime heure;
    @OneToMany(mappedBy = "seance")
    private List<Abonnement> abonnements;
    public Seance() {
    }

    public Seance(DayOfWeek jour, LocalTime heure) {
        this.jour = jour;
        this.heure = heure;
    }

    public Seance(DayOfWeek jour, LocalTime heure, List<Abonnement> abonnements) {
        this.jour = jour;
        this.heure = heure;
        this.abonnements = abonnements;
    }

    public long getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(long seanceId) {
        this.seanceId = seanceId;
    }

    public DayOfWeek getJour() {
        return jour;
    }

    public void setJour(DayOfWeek jour) {
        this.jour = jour;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }
    @JsonIgnore
    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }
}
