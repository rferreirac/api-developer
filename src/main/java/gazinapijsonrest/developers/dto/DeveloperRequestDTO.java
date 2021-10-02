package gazinapijsonrest.developers.dto;

import gazinapijsonrest.developers.entity.Developer;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class DeveloperRequestDTO {

    private Long id;

    private String nome;

    private Character sexo;

    private Integer idade;

    private String hobby;

    private Date datanascimento;

    public DeveloperRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public DeveloperRequestDTO(String nome, Character sexo, Integer idade, String hobby, Date datanascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.hobby = hobby;
        this.datanascimento = datanascimento;
    }

    public Developer transformToDeveloper() {
        return new Developer( this.nome,  this.sexo,  this.idade,  this.hobby,  this.datanascimento);
    }

}
