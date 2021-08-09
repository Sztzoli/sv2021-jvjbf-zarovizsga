package finalexam.player;

import finalexam.team.Team;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private PositionType positionType;

    @ManyToOne
    private Team team;


    public Player(String name, LocalDate birthDate, PositionType positionType) {
        this.name = name;
        this.birthDate = birthDate;
        this.positionType = positionType;
    }

    public Player(String name, LocalDate birthDate, PositionType positionType, Team team) {
        this.name = name;
        this.birthDate = birthDate;
        this.positionType = positionType;
        this.team = team;
    }
}
