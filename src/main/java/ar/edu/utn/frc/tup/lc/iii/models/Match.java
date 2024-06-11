package ar.edu.utn.frc.tup.lc.iii.models;

import ar.edu.utn.frc.tup.lc.iii.Enum.MatchDifficulty;
import ar.edu.utn.frc.tup.lc.iii.Enum.MatchStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    private Long id;
    private Long userId;
    private MatchDifficulty matchDifficulty;
    private Integer numberToGuess;
    private Integer remainingTries;
    private MatchStatus matchStatus;
}
