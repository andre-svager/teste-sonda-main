package br.com.elo7.sonda.candidato.infrastructure.repository.cassandra;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCassandraOrderRepository extends CassandraRepository<ProbeEntity, UUID> {
}