package org.example.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    @NotEmpty(message = "Campo login é obrigatório")
    private String login;
    @Column
    @NotEmpty(message = "Campo senha é obrigatório")
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "Campo login é obrigatório") String getLogin() {
        return login;
    }

    public void setLogin(@NotEmpty(message = "Campo login é obrigatório") String login) {
        this.login = login;
    }

    public @NotEmpty(message = "Campo senha é obrigatório") String getSenha() {
        return senha;
    }

    public void setSenha(@NotEmpty(message = "Campo senha é obrigatório") String senha) {
        this.senha = senha;
    }
}
