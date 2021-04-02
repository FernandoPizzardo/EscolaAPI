package br.com.mentorama.alomundo;

import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;


public class AlunoService {
    public List<String> findAll() {
        String caminho = AlunoService.class.getClassLoader()
                .getResource("br/com/mentorama/alomundo/alunos.txt")
                .getFile();
        try {
            return Files.readAllLines(Path.of(caminho));
        } catch(IOException ioException){
            throw new RuntimeException("Arquivo não encontrado");
        }
    }
    public String findAluno(String nome) throws AlunoNaoEncontradoException {
        return   findAll().stream().filter(aluno -> aluno.equals(nome))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontradoException(nome));
    }
}
