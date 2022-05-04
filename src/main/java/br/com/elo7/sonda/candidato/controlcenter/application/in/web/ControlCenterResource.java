package br.com.elo7.sonda.candidato.controlcenter.application.in.web;

import br.com.elo7.sonda.candidato.controlcenter.application.out.web.PlanetResponse;
import br.com.elo7.sonda.candidato.controlcenter.domain.exceptions.CoordinateException;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ControlCenterResource {

	@Autowired
	private ProbeService service;

	@RequestMapping(value = "/planet", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<PlanetResponse> createPlanet(@RequestBody PlanetRequest input) {
		try {
				return new ResponseEntity<PlanetResponse>(
										new PlanetResponse( service.load( input.toCoordinates())),
										HttpStatus.CREATED);
		} catch (CoordinateException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "", e);
		}
	}

}
