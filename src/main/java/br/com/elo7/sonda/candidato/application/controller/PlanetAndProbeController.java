package br.com.elo7.sonda.candidato.application.controller;

import java.util.List;

import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.elo7.sonda.candidato.application.dto.InputDTO;
import br.com.elo7.sonda.candidato.domain.model.Probe;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planet-with-probes")
public class PlanetAndProbeController {

	private final ProbeService probeService;

	@Autowired
	public PlanetAndProbeController(ProbeService probeService) {
		this.probeService = probeService;
	}

	@PostMapping
    public ResponseEntity<List<Probe>> register(@RequestBody InputDTO inputDto) {
		Planet planet = inputDto.concertPlanet(inputDto);

		return ResponseEntity.ok(probeService
									.landProbes( planet,
												 inputDto.convertProbes(planet)));
    }
}
