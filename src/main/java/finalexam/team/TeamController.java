package finalexam.team;

import finalexam.player.CreatePlayerCommand;
import finalexam.player.UpdateWithExistingPlayerCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO createTeam(
            @Valid @RequestBody CreateTeamCommand command
    ) {
        return teamService.createTeam(command);
    }

    @GetMapping
    public List<TeamDTO> listTeams() {
        return teamService.listTeams();
    }

    @PostMapping("/{id}/players")
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO addNewPlayerToTeam(
            @PathVariable Long id,
            @Valid @RequestBody CreatePlayerCommand command
    ) {
        return teamService.addNewPlayerToTeam(id, command);
    }

    @PutMapping("{id}/players")
    public TeamDTO transferPlayer(
            @PathVariable Long id,
            @Valid @RequestBody UpdateWithExistingPlayerCommand command
    ) {
        return teamService.transferCommand(id, command);
    }
}
