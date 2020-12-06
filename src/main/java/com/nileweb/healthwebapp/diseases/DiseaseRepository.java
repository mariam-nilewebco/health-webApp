package com.nileweb.healthwebapp.diseases;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends Neo4jRepository<Diseases, Long> {

}
