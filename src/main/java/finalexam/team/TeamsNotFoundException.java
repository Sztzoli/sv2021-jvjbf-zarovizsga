package finalexam.team;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class TeamsNotFoundException extends AbstractThrowableProblem {

    public TeamsNotFoundException(Long id) {
        super(
                URI.create("teams/not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("Teams not found by id: %d", id)
        );
    }
}
