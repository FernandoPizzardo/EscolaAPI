package br.com.mentorama.alomundo;

public class AlunoNaoEncontradoException extends Exception{

    public AlunoNaoEncontradoException(String nome) {
        super("aluno (a)" + nome + "Não encontrad@");
    }
}
