package com.projeto.escola.Entity;

import java.time.LocalDateTime;


import jakarta.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT", name = "matricula_id", nullable = false)
    private int id;

    @Column(columnDefinition = "DATE", name = "matricula_data")
    private LocalDateTime matriculaData;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getMatriculaData() {
        return matriculaData;
    }

    public void setMatriculaData(LocalDateTime matriculaData) {
        this.matriculaData = matriculaData;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
