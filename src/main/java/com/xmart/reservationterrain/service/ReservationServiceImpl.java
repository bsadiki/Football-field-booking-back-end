package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.Repository.*;
import com.xmart.reservationterrain.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ChangementPelouseRepository changementPelouseRepository;
    @Autowired
    ReparationLumiereRepository reparationLumiereRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TerrainRepository terrainRepository;
    @Override
    public Reservation reserver(String clientId, Long terrainId, LocalDateTime date) throws Exception {
        Client client = clientRepository.findOne(clientId);
        if(client==null)  throw new Exception("Client inexistant");
        if(client.isBlackList())
            throw new Exception("impossible de reserver: client dans la liste noire");
        Terrain terrain = terrainRepository.findOne(terrainId);
        LocalDateTime currentDate=LocalDateTime.now();
        date=date.minusMinutes(date.getMinute());
        if(date.isBefore(currentDate)) throw new Exception("impossible de reserver avant aujourd'hui");
        Reservation existingReservation=reservationRepository.findByTerrainAndDate(terrain,date);
        if(existingReservation!=null) throw new Exception("Ce terrain est déja réservé pendant cette date");
        LocalDate journee= date.toLocalDate();
        ChangementPelouse changementPelouse = changementPelouseRepository.findByTerrainAndJournee(terrain,journee);
        if(changementPelouse!=null) throw new Exception("Changement de pelouse pendant cette journée");
        for(int i=0;i<3;i++){
            ReparationLumiere reparationLumiere = reparationLumiereRepository.findByTerrainAndHeure(terrain,date.minusHours(i));
            if(reparationLumiere!=null) throw new Exception("Reparation de lumiere pendant cette heure");
        }
        Reservation reservation=new Reservation(client,terrain,date,true);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation annulerReservation(Long resrvationId) throws Exception {
        Reservation reservation = reservationRepository.findOne(resrvationId);
        if(reservation==null)
            throw new Exception("Reservation introuvable");
        reservation.setValide(false);
        reservation.getClient().setBlackList(true);
        clientRepository.save(reservation.getClient());
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> reservationDansUnJour(LocalDate jour) {
        return reservationRepository.findByDateBetween(jour.atStartOfDay(),jour.plusDays(1).atStartOfDay());
    }

}
