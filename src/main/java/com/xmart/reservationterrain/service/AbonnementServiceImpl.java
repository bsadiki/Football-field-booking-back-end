package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.Repository.AbonnementRepository;
import com.xmart.reservationterrain.Repository.ClientRepository;
import com.xmart.reservationterrain.Repository.TerrainRepository;
import com.xmart.reservationterrain.entities.Abonnement;
import com.xmart.reservationterrain.entities.Client;
import com.xmart.reservationterrain.entities.Seance;
import com.xmart.reservationterrain.entities.Terrain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AbonnementServiceImpl implements AbonnementService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AbonnementRepository abonnementRepository;
    @Autowired
    SeanceService seanceService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    TerrainRepository terrainRepository;

    @Override
    public Abonnement ajouterAbonnement(String client_id, LocalDate start, int duree, DayOfWeek jour, LocalTime heure, int type) throws Exception {
        if (start.isBefore(LocalDate.now()))
            throw new Exception("Impossible de commencer l'abonnement avant la date d'aujourd'hui");
        Client client = clientRepository.findOne(client_id);
        if (client == null)
            throw new Exception("Client introuvable");
        if(client.isBlackList())
            throw new Exception("impossible de reserver: client dans la liste noire");
        Seance seance = seanceService.seanceParJourEtHeure(jour, heure);
        if (seance == null)
            seance = seanceService.ajouterSeance(jour, heure);
        LocalDate journee = start;
        while (journee.getDayOfWeek() != jour)
            journee = journee.plusDays(1);
        while (journee.isBefore(start.plusMonths(duree))||journee.equals(start.plusMonths(duree))) {
            List<Terrain> terrains = terrainRepository.findByType(type);
            LocalDateTime dateEtHeure = LocalDateTime.of(journee, heure);
            for (Terrain terrain : terrains) {
                reservationService.reserver(client_id, terrain.getTerrainId(), dateEtHeure);
                break;
            }
            journee = journee.plusWeeks(1);
        }
        Abonnement abonnement = new Abonnement(client, start, start.plusMonths(duree), duree, seance, type);
        return abonnementRepository.save(abonnement);
    }

    @Override
    public List<Abonnement> abonnementDansUneDate(LocalDateTime localDateTime) {
        Seance seance = seanceService.seanceParJourEtHeure(localDateTime.getDayOfWeek(), localDateTime.toLocalTime());
        if (seance == null)
            return null;
        else
            return abonnementRepository.findBySeanceAndStartBeforeAndEndAfter(seance, localDateTime.toLocalDate(), localDateTime.toLocalDate());
    }

    @Override
    public Page<Abonnement> abonnementsCourants(int page, int size) {
        return  abonnementRepository.findByStartBeforeAndEndAfter(LocalDate.now(),LocalDate.now(), new PageRequest(page,size));
    }
}
