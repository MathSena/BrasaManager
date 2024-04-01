package org.mathsena.bmteams.controller;

import org.mathsena.bmteams.model.Team;
import org.mathsena.bmteams.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team Team) {
        Team createdTeam = teamService.createTeam(Team);
        return ResponseEntity.ok(createdTeam);
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable String id) {
        Optional<Team> Team = teamService.getTeamById(id);
        return Team.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable String id, @RequestBody Team updatedTeam) {
        Team Team = teamService.updateTeam(id, updatedTeam);
        if (Team != null) {
            return ResponseEntity.ok(Team);
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable String id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok()
                .build();
    }


}
