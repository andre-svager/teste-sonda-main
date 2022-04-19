package br.com.elo7.sonda.candidato.infrastructure.config;


import br.com.elo7.sonda.candidato.infrastructure.repository.mongo.SpringDataMongoProbeRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoProbeRepository.class)
public class MongoDBConfiguration {
}