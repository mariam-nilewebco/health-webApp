package com.nileweb.healthwebapp.symptoms;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomsRepository extends Neo4jRepository<Symptoms, Long> {

}
