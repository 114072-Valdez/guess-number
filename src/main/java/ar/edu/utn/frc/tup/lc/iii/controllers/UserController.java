package ar.edu.utn.frc.tup.lc.iii.controllers;

import ar.edu.utn.frc.tup.lc.iii.Enum.MatchDifficulty;
import ar.edu.utn.frc.tup.lc.iii.dtos.MatchDto;
import ar.edu.utn.frc.tup.lc.iii.dtos.UserDto;
import ar.edu.utn.frc.tup.lc.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.lc.iii.models.Match;
import ar.edu.utn.frc.tup.lc.iii.models.User;
import ar.edu.utn.frc.tup.lc.iii.services.MatchService;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guess-number/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Qualifier("modelMapper")
    @Autowired
    private ModelMapper _modelMapper;

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        User user = userService.createUser(userDto.getUserName(),userDto.getEmail());
        UserDto userDtoCreated = _modelMapper.map(user, UserDto.class);

        return ResponseEntity.ok(userDtoCreated);
    }

    @PostMapping("/{userId}/matches/{difficulty}")
    public ResponseEntity<MatchDto> createUserMatch(@PathVariable Long userId, @PathVariable MatchDifficulty difficulty) {

        Match match = userService.createUserMatch(userId,difficulty);
        MatchDto matchDtoCreated = _modelMapper.map(match, MatchDto.class);

        return ResponseEntity.ok(matchDtoCreated);
    }

}
