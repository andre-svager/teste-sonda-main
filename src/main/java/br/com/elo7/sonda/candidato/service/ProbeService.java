package br.com.elo7.sonda.candidato.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.elo7.sonda.candidato.domain.ProbeCollisionException;
import br.com.elo7.sonda.candidato.domain.ProbeOutOfRangeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;
import br.com.elo7.sonda.candidato.dto.InputDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.domain.model.Command;
import br.com.elo7.sonda.candidato.domain.model.Direction;
import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.model.Probe;
import br.com.elo7.sonda.candidato.domain.repository.PlanetsRepository;
import br.com.elo7.sonda.candidato.domain.repository.ProbesRepository;

@Service
public class ProbeService {
	@Autowired
	private PlanetsRepository planets;
	@Autowired
	private ProbesRepository probes;
	
	public List<Probe> landProbes(InputDTO input) {
		Planet planet = input.concertPlanet(input);
		planets.save(planet);

		List<Probe> convertedProbes = convertAndMoveProbes(input, planet);
		convertedProbes.forEach(probe -> probes.save(probe));

		return convertedProbes;
	}
	
	@VisibleForTesting
	void applyCommandToProbe(Probe probe, char command) {
		switch (command) {
			case Command.R:
				probe.turnProbeRight(probe);
				break;
			case Command.L:
				probe.turnProbeLeft(probe);
				break;
			case Command.M:
				probe.moveProbeForward(probe);
				break;
		}
	}

	private List<Probe> convertAndMoveProbes(InputDTO input, Planet planet) {
		return input.getProbes()
						.stream().map(probeDto -> {
							Probe probe = probeDto.convertProbe(planet);
							moveProbeWithAllCommands(probe, probeDto);
					try {
						verifiedProbe(probe);
					} catch (ProbeOutOfRangeException e) {
						e.printStackTrace();
					}
					return probe;
						}).collect(Collectors.toList());
	}

	private void verifiedProbe(Probe probe) throws ProbeOutOfRangeException {
		if(probe.getY() >= probe.getPlanet().getHeight() && probe.getX() >= probe.getPlanet().getWidth() ) {
			throw new ProbeOutOfRangeException();
		}
	}

	private void moveProbeWithAllCommands(Probe probe, ProbeDTO probeDTO){
		for (char command : probeDTO.getCommands().toCharArray()) {
			applyCommandToProbe(probe, command);
		}
	}

}
