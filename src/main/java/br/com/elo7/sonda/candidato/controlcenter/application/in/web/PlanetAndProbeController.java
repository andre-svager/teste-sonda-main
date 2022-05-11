package br.com.elo7.sonda.candidato.controlcenter.application.in.web;

import br.com.elo7.sonda.candidato.controlcenter.application.out.web.ProbeResponse;
import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.ControlCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planet-with-probes")
public class PlanetAndProbeController {

	private final ControlCenterService probeService;

	@Autowired
	public PlanetAndProbeController(ControlCenterService probeService) {
		this.probeService = probeService;
	}

	@PostMapping
    public ResponseEntity<List<ProbeResponse>> register(@RequestBody InputDTO inputDto) {
		Planet planet = inputDto.concertPlanet(inputDto);

		List<ProbeResponse> probesDto = ProbeResponse.convertToDTO(
												probeService.landProbes( planet,
													 inputDto.convertProbes(planet)));
		return ResponseEntity.ok(probesDto);
    }
}
