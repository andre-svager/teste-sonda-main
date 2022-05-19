package br.com.elo7.sonda.candidato.service;

import br.com.elo7.sonda.candidato.controlcenter.domain.*;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.ControlCenterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static com.mongodb.assertions.Assertions.assertTrue;


@SpringBootTest
public class ProbeServiceTest {
	
	@Autowired
	private ControlCenterService subject;

	private Planet generateAPlanet(){
		return new Planet(5, 5);
	}
	
	@Test
	public void should_change_probe_direction_from_N_To_W_when_receive_the_command_L()
																		throws DirectionException, CommandException {
			String finalDirection =
					generateAPlanet().generateAProbe(1, 1, 'N').move("L").getDirection().type();

			Assertions.assertEquals("W", finalDirection);
	}

	@Test
	public void should_change_probe_direction_from_W_To_S_when_receive_the_command_L()
																		throws DirectionException, CommandException {
		String finalDirection =
				generateAPlanet().generateAProbe(1, 1, 'W').move("L").getDirection().type();

		Assertions.assertEquals("S", finalDirection);
	}
	
	@Test
	public void should_change_probe_direction_from_S_To_E_when_receive_the_command_L()
																		throws DirectionException, CommandException {
		String finalDirection =
				generateAPlanet().generateAProbe(1, 1, 'S').move("L").getDirection().type();

		Assertions.assertEquals("E", finalDirection);
	}
	
	@Test
	public void should_change_probe_direction_from_E_To_N_when_receive_the_command_L()
																		throws DirectionException, CommandException {
		String finalDirection =
				generateAPlanet().generateAProbe(1, 1, 'E').move("L").getDirection().type();

		Assertions.assertEquals("N", finalDirection);
	}
	
	@Test
	public void should_change_probe_direction_from_N_To_E_when_receive_the_command_R()
																		throws DirectionException, CommandException {
		String finalDirection =
				generateAPlanet().generateAProbe(1, 1, 'N').move("R").getDirection().type();

		Assertions.assertEquals("E", finalDirection);
	}
	
	@Test
	public void should_change_probe_direction_from_E_To_S_when_receive_the_command_R()
																		throws DirectionException , CommandException {
		String finalDirection =
				generateAPlanet().generateAProbe(1, 1, 'E').move("R").getDirection().type();

		Assertions.assertEquals("S", finalDirection);
	}
	
	@Test
	public void should_change_probe_direction_from_S_To_W_when_receive_the_command_R()
																		throws DirectionException , CommandException {
		String finalDirection =
				generateAPlanet().generateAProbe(1, 1, 'S').move("R").getDirection().type();

		Assertions.assertEquals("W", finalDirection);
	}
	
	@Test
	public void should_change_probe_direction_from_W_To_N_when_receive_the_command_R()
																		throws DirectionException , CommandException {
		String finalDirection =
				generateAPlanet().generateAProbe(1, 1, 'W').move("R").getDirection().type();

		Assertions.assertEquals("N", finalDirection);
	}

	@Test
	public void should_change_probe_position_from_1_1_N_To_1_2_N_when_receive_the_command_M()
																		throws DirectionException , CommandException {
		Probe probe =
				generateAPlanet().generateAProbe(1, 1, 'N').move("M");

		Assertions.assertEquals("N", probe.getDirection().type());
		Assertions.assertEquals(1, probe.getProbeCoordinates().x().value());
		Assertions.assertEquals(2, probe.getProbeCoordinates().y().value());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_S_To_1_0_S_when_receive_the_command_M()
																		throws DirectionException , CommandException {
		Probe probe =
				generateAPlanet().generateAProbe(1, 1, 'S').move("M");

		Assertions.assertEquals("S", probe.getDirection().type());
		Assertions.assertEquals(1, probe.getProbeCoordinates().x().value());
		Assertions.assertEquals(0, probe.getProbeCoordinates().y().value());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_W_To_0_1_W_when_receive_the_command_M()
																		throws DirectionException , CommandException {
		Probe probe =
				generateAPlanet().generateAProbe(1, 1, 'W').move("M");

		Assertions.assertEquals("W", probe.getDirection().type());
		Assertions.assertEquals(0, probe.getProbeCoordinates().x().value());
		Assertions.assertEquals(1, probe.getProbeCoordinates().y().value());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_E_To_2_1_E_when_receive_the_command_M()
																		throws DirectionException , CommandException {
		Probe probe =
				generateAPlanet().generateAProbe(1, 1, 'E').move("M");

		Assertions.assertEquals("E", probe.getDirection().type());
		Assertions.assertEquals(2, probe.getProbeCoordinates().x().value());
		Assertions.assertEquals(1, probe.getProbeCoordinates().y().value());
	}

	@Test
	public void should_throw_probe_out_of_range_exception_when_receive_command_outside_of_planet()
																		throws DirectionException , CommandException {
		Probe probe =
				generateAPlanet().generateAProbe(5, 4, 'E').move("LM");

		ProbeOutOfRangeException thrown = Assertions.assertThrows(
				ProbeOutOfRangeException.class,
				() -> probe.move("M"),
				"Probe Out Of Range"
		);

		assertTrue(thrown.getMessage().contains("Probe Out Of Range"));
	}
}
