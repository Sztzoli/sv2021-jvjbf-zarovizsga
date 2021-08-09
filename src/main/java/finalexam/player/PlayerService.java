package finalexam.player;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final ModelMapper mapper;

    public List<PlayerDTO> listPlayers() {
        Type targetListType = new TypeToken<List<PlayerDTO>>() {
        }.getType();
        return mapper.map(playerRepository.findAll(), targetListType);
    }

    public PlayerDTO createPlayer(CreatePlayerCommand command) {
        Player player = playerRepository.save(new Player(command.getName(), command.getBirthDate(), command.getPosition()));
        return mapper.map(player, PlayerDTO.class);
    }

    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }


}
