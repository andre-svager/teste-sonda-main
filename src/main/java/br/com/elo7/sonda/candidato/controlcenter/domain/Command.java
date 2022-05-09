package br.com.elo7.sonda.candidato.controlcenter.domain;

import java.util.stream.Stream;

public enum Command {
	LEFT("L"), RIGHT("R"), MOVE("M");

	private String cmd;

	private Command(String cmd) { this.cmd = cmd; }

	public static Command toCommand(String cmd) throws CommandException {
		return Stream.of(values())
					 .filter(d -> d.cmd.equals(cmd))
					 .findFirst().orElseThrow(() -> new CommandException(cmd));
	}
}
