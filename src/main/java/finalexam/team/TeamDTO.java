package finalexam.team;

import finalexam.player.PlayerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {


    private Long id;
    private String name;
    private List<PlayerDTO> players;

}
