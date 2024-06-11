package ar.edu.utn.frc.tup.lc.iii.dtos;

import ar.edu.utn.frc.tup.lc.iii.Enum.MatchDifficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {

    private Long id;
    private MatchDifficulty matchDifficulty;
    private Integer remainingTries;
}
