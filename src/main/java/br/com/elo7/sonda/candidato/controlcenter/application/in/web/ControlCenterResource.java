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
@RequestMapping("/control-center")
public class ControlCenterResource {

	@Autowired
	private ControlCenterService service;

	@RequestMapping(value = "/planet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PlanetResponse> createPlanet(@RequestBody PlanetRequest request) {
		try {
			return new ResponseEntity<PlanetResponse>(
					new PlanetResponse( service.generateAPlanet( request.toCoordinates() ) ), HttpStatus.CREATED);
		} catch (CoordinateException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<List<ProbeResponse>>
				createProbe(@RequestBody ProbeRequest request) throws DirectionException {
		try {
				return ResponseEntity.ok(ProbeResponse.convertTo(
						service.registerAProbeInAPlanet(request.getPlanetId(),
														request.getX(),
														request.getY(),
														request.getDirection(),
														request.getCommands())));
			} catch (CommandException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			}catch (PlanetNotFoundException e){
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			}
	}

	@PatchMapping(value = "/probe/{id}/move/{commands}")
	@ResponseBody
	ResponseEntity<Void> move( @PathVariable int id,
							   @RequestBody String commands) throws Exception {
		//ProbeResponse explorer = service.findExplorer(id);
		//service.move(explorer, command);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/planet/{id}", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<PlanetResponse> getPlanet(@PathVariable int id) {
		return ResponseEntity.ok(PlanetResponse.convertTo(service.findPlanet(id)));
	}
}
