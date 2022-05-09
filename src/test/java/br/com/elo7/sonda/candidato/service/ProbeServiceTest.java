package br.com.elo7.sonda.candidato.service;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;
import br.com.elo7.sonda.candidato.controlcenter.domain.ProbeOutOfRangeException;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.ProbeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mongodb.assertions.Assertions.assertTrue;

@SpringBootTest
public class ProbeServiceTest {
	
	@Autowired
	private ProbeService subject;
	
	@Test
	public void should_change_probe_direction_from_N_To_W_when_receive_the_command_L() {
		Probe probe = new Probe(1, 1,'N');
		probe.applyCommandToProbe('L');
		assertEquals('W', probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_W_To_S_when_receive_the_command_L() {
		Probe probe = new Probe(1, 1,'W');
		probe.applyCommandToProbe( 'L');
		assertEquals('S', probe.getDirection());		
	}
	
	@Test
	public void should_change_probe_direction_from_S_To_E_when_receive_the_command_L() {
		Probe probe = new Probe(1, 1,'S');
		probe.applyCommandToProbe( 'L');
		assertEquals('E', probe.getDirection());		
	}
	
	@Test
	public void should_change_probe_direction_from_E_To_N_when_receive_the_command_L() {
		Probe probe = new Probe(1, 1,'E');
		probe.applyCommandToProbe( 'L');
		assertEquals('N', probe.getDirection());		
	}
	
	@Test
	public void should_change_probe_direction_from_N_To_E_when_receive_the_command_R() {
		Probe probe = new Probe(1, 1,'N');
		probe.applyCommandToProbe( 'R');
		assertEquals('E', probe.getDirection());		
	}
	
	@Test
	public void should_change_probe_direction_from_E_To_S_when_receive_the_command_R() {
		Probe probe = new Probe(1, 1,'E');
		probe.applyCommandToProbe( 'R');
		assertEquals('S', probe.getDirection());		
	}
	
	@Test
	public void should_change_probe_direction_from_S_To_W_when_receive_the_command_R() {
		Probe probe = new Probe(1, 1,'S');
		probe.applyCommandToProbe( 'R');
		assertEquals('W', probe.getDirection());		
	}
	
	@Test
	public void should_change_probe_direction_from_W_To_N_when_receive_the_command_R() {
		Probe probe = new Probe(1, 1,'W');
		probe.applyCommandToProbe( 'R');
		assertEquals('N', probe.getDirection());		
	}

	@Test
	public void should_change_probe_position_from_1_1_N_To_1_2_N_when_receive_the_command_M() {
		Probe probe = new Probe(1, 1,'N');
		probe.applyCommandToProbe('M');
		assertEquals(2, probe.getY());
		assertEquals(1, probe.getX());
		assertEquals('N', probe.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_S_To_1_0_S_when_receive_the_command_M() {
		Probe probe = new Probe(1, 1,'S');
		probe.applyCommandToProbe( 'M');
		assertEquals(0, probe.getY());
		assertEquals(1, probe.getX());
		assertEquals('S', probe.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_W_To_0_1_W_when_receive_the_command_M() {
		Probe probe = new Probe(1, 1,'W');
		probe.applyCommandToProbe( 'M');
		assertEquals(0, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('W', probe.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_E_To_2_1_E_when_receive_the_command_M() {
		Probe probe = new Probe( 1, 1, 'E');
		probe.applyCommandToProbe( 'M');
		assertEquals(2, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals('E', probe.getDirection());
	}

	@Test
	public void should_throw_probe_out_of_range_exception_when_receive_command_outside_of_planet() {

		Probe probe = new Probe(new Planet(2,2, "MARS"), 2, 1, 'S', "LM");
		probe.applyCommandToProbe('M');

		ProbeOutOfRangeException thrown = assertThrows(
				ProbeOutOfRangeException.class,
				() -> probe.moveProbeWithAllCommands(),
				"Probe Out Of Planet Limit !!"
		);

		assertTrue(thrown.getMessage().contains("Probe Out Of Planet Limit !!"));
	}
}
