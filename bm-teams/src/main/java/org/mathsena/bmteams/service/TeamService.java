package org.mathsena.bmteams.service;

import org.mathsena.bmteams.model.Team;
import org.mathsena.bmteams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teemRepository;

    public Team createTeam(Team team) {
        return teemRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teemRepository.findAll();
    }

    public Optional<Team> getTeamById(String id) {
        return teemRepository.findById(id);
    }

    public Team updateTeam(String id, Team updatedTeam) {
        if (teemRepository.existsById(id)) {
            updatedTeam.setId(id);
            return teemRepository.save(updatedTeam);
        }
        return null;
    }

    public void deleteTeam(String id) {
        teemRepository.deleteById(id);
    }
}
