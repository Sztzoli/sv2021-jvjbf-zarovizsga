package finalexam.team;

import finalexam.player.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final ModelMapper mapper;

    public TeamDTO createTeam(CreateTeamCommand command) {
        Team team = teamRepository.save(new Team(command.getName()));
        return mapper.map(team, TeamDTO.class);
    }

    public List<TeamDTO> listTeams() {
        Type targetListType = new TypeToken<List<TeamDTO>>() {
        }.getType();
        return mapper.map(teamRepository.findAll(), targetListType);
    }


    @Transactional
    public TeamDTO addNewPlayerToTeam(Long id, CreatePlayerCommand command) {
        Team team = findById(id);
        Player player = playerRepository.save(new Player(command.getName(), command.getBirthDate(), command.getPositionType()));
        team.addNewPlayer(player);
        return mapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO transferCommand(Long id, UpdateWithExistingPlayerCommand command) {
        Player player = playerRepository.getById(command.getId());
        Team team = findById(id);
        if (player.getTeam() == null && positionNumber(id, player.getPositionType()) < 2) {
            team.addNewPlayer(player);
        }
        return mapper.map(team, TeamDTO.class);
    }

    private Team findById(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamsNotFoundException(id));
    }

    private int positionNumber(Long id, PositionType type) {
        return playerRepository.countPositionByTeam(id, type);
    }
}
