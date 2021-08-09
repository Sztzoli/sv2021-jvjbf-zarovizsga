package finalexam.team;

import finalexam.player.Player;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
    private List<Player> players;

    public Team(String name) {
        this.name = name;
    }

    public void addNewPlayer(Player player) {
        player.setTeam(this);
        if (players == null) {
            players = new ArrayList<>();
        }
        players.add(player);
    }
}
