package finalexam.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select count(p) from Player p where p.team.id= :id and p.positionType= :type")
    int countPositionByTeam(Long id, PositionType type);
}
