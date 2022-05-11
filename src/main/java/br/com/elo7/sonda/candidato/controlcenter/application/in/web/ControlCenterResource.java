package br.com.elo7.sonda.candidato.controlcenter.application.in.web;

import br.com.elo7.sonda.candidato.controlcenter.application.out.web.PlanetResponse;
import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.CoordinateException;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.ControlCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class ControlCenterResource {

	@Autowired
	private ControlCenterService service;

	@RequestMapping(value = "/planet", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<PlanetResponse> createPlanet(@RequestBody PlanetRequest input) {
		try {
			return new ResponseEntity<PlanetResponse>(
							new PlanetResponse( service.generateAPlanet( input.toCoordinates())), HttpStatus.CREATED);
		} catch (CoordinateException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "", e);
		}
	}

	@RequestMapping(value = "/explorer", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<ExplorerRO> createExplorer(@RequestBody ExplorerRO input) {
		final URI location = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/explorer/{id}").build().expand(explorer.getId()).toUri();
		Explorer explorer = service.createExplorer( input.getPlateauId(), new Coordinate(input.getLat(), input.getLng()), input.getDirection());
		return ResponseEntity.created(location).body(Converter.convert(explorer, ExplorerRO.class));
	}

	@RequestMapping(value = "/explorer/{id}/move", method = RequestMethod.PUT)
	@ResponseBody
	ResponseEntity<Void> move(@PathVariable int id, @RequestBody String command)
			throws Exception {
		Explorer explorer = service.findExplorer(id);
		service.move(explorer, command);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/explorer/{id}", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<ExplorerRO> getExplorer(@PathVariable int id) {
		Explorer explorer = service.findExplorer(id);
		return ResponseEntity.ok(Converter.convert(explorer, ExplorerRO.class));
	}

	@RequestMapping(value = "/plateau/{id}", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<PlanetRequest> getPlateau(@PathVariable int id) {
		Plateau plateau = service.findPlateau(id);
		return ResponseEntity.ok(Converter.convert(plateau, PlanetRequest.class));
	}

}

