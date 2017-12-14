package com.xmart.reservationterrain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
@Entity
public class Client implements Serializable {
    @Id
    private String clientId;
    private String name;
    @OneToMany(mappedBy = "client")
    private Collection<Reservation> reservations;
    @OneToMany(mappedBy = "client")
    private Collection<Abonnement> abonnements;
    private boolean blackList;

    public Client() {
    }

    public Client(String clientId, String name, Collection<Reservation> reservations, Collection<Abonnement> abonnements, boolean blackList) {

        this.clientId = clientId;
        this.name = name;
        this.reservations = reservations;
        this.abonnements = abonnements;
        this.blackList = blackList;
    }

    public String getClientId() {

        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonIgnore
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }
    @JsonIgnore
    public Collection<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(Collection<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    public boolean isBlackList() {
        return blackList;
    }

    public void setBlackList(boolean blackList) {
        this.blackList = blackList;
    }
}
