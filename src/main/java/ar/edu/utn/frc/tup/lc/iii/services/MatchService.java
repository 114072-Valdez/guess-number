package ar.edu.utn.frc.tup.lc.iii.services;

import ar.edu.utn.frc.tup.lc.iii.Enum.MatchDifficulty;
import ar.edu.utn.frc.tup.lc.iii.models.Match;
import ar.edu.utn.frc.tup.lc.iii.models.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface MatchService {

    Match createMatch(User user , MatchDifficulty matchDifficulty);
}
