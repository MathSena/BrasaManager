package org.mathsena.bmteams.repository;

import org.mathsena.bmteams.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository  extends MongoRepository<Team, String> {
}
