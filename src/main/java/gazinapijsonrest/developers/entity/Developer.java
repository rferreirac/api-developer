package gazinapijsonrest.developers.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity

public class Developer implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @Column( nullable = false )
    private String nome;

    @Column( nullable = false )
    private Character sexo;

    @Column( nullable = false )
    private Integer idade;

    @Column()
    private String hobby;

    @Column( nullable = false )
    private Date datanascimento;

    public Developer() {
    }

    public Developer(String nome, Character sexo, Integer idade, String hobby, Date datanascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.hobby = hobby;
        this.datanascimento = datanascimento;
    }
}
