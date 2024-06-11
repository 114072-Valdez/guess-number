package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.Enum.MatchDifficulty;
import ar.edu.utn.frc.tup.lc.iii.Enum.MatchStatus;
import ar.edu.utn.frc.tup.lc.iii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lc.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.lc.iii.models.Match;
import ar.edu.utn.frc.tup.lc.iii.models.User;
import ar.edu.utn.frc.tup.lc.iii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.lc.iii.services.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    @Qualifier("modelMapper")
    @Autowired
    private ModelMapper _modelMapper;
    private final Random random = new Random();

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match createMatch(User user, MatchDifficulty matchDifficulty) {

        MatchEntity matchEntity = new MatchEntity();
        UserEntity u =_modelMapper.map(user, UserEntity.class);
        matchEntity.setUserEntity(_modelMapper.map(user, UserEntity.class));

        matchEntity.setMatchDifficulty(matchDifficulty);
        switch (matchDifficulty) {

            case EASY -> matchEntity.setRemainingTries(10);

            case MEDIUM -> matchEntity.setRemainingTries(8);

            case HARD -> matchEntity.setRemainingTries(5);
        }

        matchEntity.setMatchStatus(MatchStatus.PLAYING);
        matchEntity.setNumberToGuess(random.nextInt(101));
        matchEntity.setCreatedAt(LocalDateTime.now());
        matchEntity.setUpdatedAt(LocalDateTime.now());

        matchEntity = matchRepository.save(matchEntity);

        return _modelMapper.map(matchEntity, Match.class);
    }

}
