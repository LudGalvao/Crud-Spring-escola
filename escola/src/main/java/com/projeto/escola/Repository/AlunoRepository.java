package com.projeto.escola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.escola.Entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
    
}
