package com.projeto.escola.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.escola.Entity.Aluno;
import com.projeto.escola.Service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunos = alunoService.getAllAlunos();
        return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.adicionarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable int id, @RequestBody Aluno novoAluno) {
        Aluno alunoAtualizado = alunoService.atualizarAluno(id, novoAluno);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAluno(@PathVariable int id) {
        alunoService.excluirAluno(id);
        return ResponseEntity.noContent().build();
    }
}
