package br.com.elo7.sonda.candidato.controlcenter.domain;

import java.util.stream.Stream;

public enum MessageType {
    PLANET_NOT_FOUND("Planet Not Found"),
    PLANET_DUPLICATED("Planet Duplicated");

    private String type;

    private MessageType(String type) { this.type = type; }

    public static MessageType to(String type) throws CommandException {
        return Stream.of(values())
                     .filter(d -> d.type.equals(type))
                     .findFirst().orElseThrow(() -> new CommandException(type));
    }
}
