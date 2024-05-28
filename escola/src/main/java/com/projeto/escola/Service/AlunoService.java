package com.projeto.escola.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto.escola.Entity.Aluno;
import com.projeto.escola.Repository.AlunoRepository;

import jakarta.transaction.Transactional;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // metodo GET
    public List<Aluno> getAllAlunos(){
        return alunoRepository.findAll();
    }

    // Metodo POST
    @Transactional
    public Aluno adicionarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    // Metodo PUT
    public Aluno atualizarAluno(int id, Aluno novoAluno){
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if(alunoOptional.isPresent()){
            Aluno alunoExistente = alunoOptional.get();
            alunoExistente.setNome(novoAluno.getNome());
            alunoExistente.setSobrenome(novoAluno.getSobrenome());
            alunoExistente.setEmail(novoAluno.getEmail());
            alunoExistente.setAniversario(novoAluno.getAniversario());
            return alunoRepository.save(alunoExistente);
        }
        else{
            novoAluno.setId(id);
            return alunoRepository.save(novoAluno);
        }
    }

    // Metodo DELETE
    @Transactional
    public void excluirAluno(int id){
        alunoRepository.deleteById(id);
    }

}
