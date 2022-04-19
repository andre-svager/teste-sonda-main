package br.com.elo7.sonda.candidato.application.controller;

import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.service.DomainProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planet")
public class PlanetController {

	@Autowired
	private DomainProbeService probeService;

	@GetMapping("/{id}")
    public ResponseEntity<Planet> register(@RequestParam Integer id) {
		return ResponseEntity.ok(probeService.getPlanet(id));
    }
}
