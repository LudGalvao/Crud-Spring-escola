package com.projeto.escola.Entity;


import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT", name = "aluno_id", nullable = false)
    private int id;

    @Column(columnDefinition = "VARCHAR", name = "aluno_nome")
    private String nome;

    @Column(columnDefinition = "VARCHAR", name = "aluno_sobrenome")
    private String sobrenome;

    @Column(columnDefinition = "VARCHAR", name = "aluno_email")
    private String email;

    @Column(columnDefinition = "DATE", name = "aluno_anivesario")
    private LocalDate aniversario;

    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private List<Matricula> matriculas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
