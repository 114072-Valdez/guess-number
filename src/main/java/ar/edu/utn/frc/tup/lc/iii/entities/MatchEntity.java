package ar.edu.utn.frc.tup.lc.iii.entities;

import ar.edu.utn.frc.tup.lc.iii.Enum.MatchDifficulty;
import ar.edu.utn.frc.tup.lc.iii.Enum.MatchStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Matches")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "user_Id")
    @ManyToOne() //muchas partidas pertenecen a un usuario, hay un usuario por match
    private UserEntity userEntity;

    @Column
    @Enumerated(EnumType.STRING) // guarda los enumeradores como string
    private MatchDifficulty matchDifficulty;

    @Column
    private Integer numberToGuess;

    @Column
    private Integer remainingTries;

    @Column
    @Enumerated(EnumType.STRING)
    private MatchStatus matchStatus;
//----------------------------------------------------------------------
    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
}
