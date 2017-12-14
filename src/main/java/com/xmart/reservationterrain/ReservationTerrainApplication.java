package com.xmart.reservationterrain;

import com.xmart.reservationterrain.Repository.ClientRepository;
import com.xmart.reservationterrain.Repository.ReparationLumiereRepository;
import com.xmart.reservationterrain.Repository.TerrainRepository;
import com.xmart.reservationterrain.entities.Client;
import com.xmart.reservationterrain.entities.ReparationLumiere;
import com.xmart.reservationterrain.entities.Terrain;
import com.xmart.reservationterrain.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@EnableSwagger2
@SpringBootApplication
public class ReservationTerrainApplication implements CommandLineRunner {
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private TerrainRepository terrainRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ReparationLumiereRepository reparationLumiereRepository;
	public static void main(String[] args) {
		SpringApplication.run(ReservationTerrainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
