package br.com.elo7.sonda.candidato.controlcenter.infrastructure.config;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "br.com.elo7.sonda.candidato.infrastructure.repository.mongo")
public class MongoDBConfiguration {
}