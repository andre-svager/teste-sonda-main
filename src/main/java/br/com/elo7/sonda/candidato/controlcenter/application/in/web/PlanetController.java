package br.com.elo7.sonda.candidato.controlcenter.application.in.web;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.DomainProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetController {

	@Autowired
	private DomainProbeService probeService;

	@GetMapping("/{name}")
    public ResponseEntity<Planet> register(@RequestParam String name) {
		return ResponseEntity.ok(probeService.getPlanet(name));
    }

	@GetMapping
	public ResponseEntity<List<Planet>> listAllPlanets() {

		return ResponseEntity.ok(probeService.getAllPlanets());
	}
}
