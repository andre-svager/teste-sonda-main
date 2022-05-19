package br.com.elo7.sonda.candidato.controlcenter.application.in.web;

import br.com.elo7.sonda.candidato.controlcenter.application.out.web.PlanetResponse;
import br.com.elo7.sonda.candidato.controlcenter.application.out.web.ProbeResponse;
import br.com.elo7.sonda.candidato.controlcenter.domain.*;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.ControlCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/planet-with-probes")
public class ControlCenterResource {

	@Autowired
	private ControlCenterService service;

	@RequestMapping(value = "/planet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PlanetResponse> createPlanet(@RequestBody PlanetRequest request) {
		try {
			return new ResponseEntity<PlanetResponse>(
					new PlanetResponse( service.generateAPlanet( request.getX(),
																 request.getY() ) ), HttpStatus.CREATED);
		} catch (CoordinateException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PostMapping("/probes")
	public ResponseEntity<ProbeResponse> createProbe(@RequestBody ProbeRequest request) throws DirectionException {
		try {
			try {
				return ResponseEntity.ok(ProbeResponse.convertTo(
						service.registerAProbeInAPlanet(request.getPlanetId(),
														request.getX(),
														request.getY(),
														request.getDirection(),
														request.getCommands())));
			} catch (CommandException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			}
		}catch (PlanetException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping(value = "/probes/{planetId}")
	public ResponseEntity<List<ProbeResponse>> recoverAllProbesInAPlanet(
													@PathVariable Integer planetId) throws DirectionException {
		try {
				return ResponseEntity.ok(ProbeResponse.convertTo(service.findAllProbesInAPlanet(planetId)));
		}catch (PlanetException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PatchMapping(value = "/probe/{id}/move/{commands}")
	@ResponseBody
	ResponseEntity<ProbeResponse> move( @PathVariable int id,
										@PathVariable String commands) throws Exception {
		try {
			return ResponseEntity.ok(
						ProbeResponse.convertTo(service.movementAProbe(id, commands)));
		} catch (DirectionException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@RequestMapping(value = "/planet/{id}", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<PlanetResponse> getPlanet(@PathVariable int id) {
		return ResponseEntity.ok(PlanetResponse.convertTo(service.findPlanet(id)));
	}

	@RequestMapping(value = "/planet/all", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<List<PlanetResponse>> getAllPlanets() {
		return ResponseEntity.ok(PlanetResponse.convertTo(service.getAllPlanets()));
	}

}
