package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.Enum.MatchDifficulty;
import ar.edu.utn.frc.tup.lc.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.lc.iii.models.Match;
import ar.edu.utn.frc.tup.lc.iii.models.User;
import ar.edu.utn.frc.tup.lc.iii.repositories.UserRepository;
import ar.edu.utn.frc.tup.lc.iii.services.MatchService;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Qualifier("modelMapper")
    @Autowired
    private ModelMapper _modelMapper;

    @Autowired
    private MatchService matchService;

    @Override
    public User createUser(String userName, String email) {

        Optional<UserEntity> optionalUserEntity = userRepository.getByEmail(email);
        User user = null;
        if (optionalUserEntity.isPresent()) {
            //TODO enviar error al usuario.
            return null;
        } else {

            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userName);
            userEntity.setEmail(email);
            userEntity = userRepository.save(userEntity); //piso para no crear otro
            user = _modelMapper.map(userEntity, User.class);
        }
        return user;
    }

    @Override
    public Match createUserMatch(Long userId, MatchDifficulty matchDifficulty) {

        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        if (optionalUserEntity.isPresent()) {
           User user = _modelMapper.map(optionalUserEntity.get(), User.class);
           return matchService.createMatch(user, matchDifficulty);
        } else {
            throw new EntityNotFoundException();
        }
    }

}
