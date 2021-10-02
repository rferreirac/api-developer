package gazinapijsonrest.developers.dto;

import gazinapijsonrest.developers.entity.Developer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class DeveloperResponseDTO {

    private long id;
    
    private String nome;
    
    private Character sexo;
    
    private int idade;
    
    private String hobby;
    
    private Date datanascimento;

    public static DeveloperResponseDTO transformToDTO( Developer developer) {
        return new DeveloperResponseDTO(developer.getId(), developer.getNome(), developer.getSexo(), developer.getIdade(), developer.getHobby(), developer.getDatanascimento());

    }

}
