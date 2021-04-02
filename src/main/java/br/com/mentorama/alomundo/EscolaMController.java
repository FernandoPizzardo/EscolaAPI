package br.com.mentorama.alomundo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/olamundo")
public class EscolaMController  {
  private final List<Message> messages;
    public EscolaMController() throws AlunoNaoEncontradoException{
        // AlunoService buscaAluno = new AlunoService();
        // buscaAluno.findAluno("Frederico");
         this.messages = new ArrayList<>();
        Message aluno1 = new Message( 1, "Luna");
        Message aluno2 = new Message( 2, "Fernando");
        Message aluno3 = new Message( 3, "Saori");
        Message aluno4 = new Message( 4, "Samara");
        Message aluno5 = new Message( 5, "Fátima");
        Message aluno6 = new Message( 6, "Frederico");
        Message aluno7 = new Message( 7, "Matilda");
        Message aluno8 = new Message( 8, "Márcio");
        Message aluno9 = new Message( 9, "Felipe");
        Message aluno10 = new Message( 10, "Nina");
        this.messages.add(aluno1);
        this.messages.add(aluno2);
        this.messages.add(aluno3);
        this.messages.add(aluno4);
        this.messages.add(aluno5);
        this.messages.add(aluno6);
        this.messages.add(aluno7);
        this.messages.add(aluno8);
        this.messages.add(aluno9);
        this.messages.add(aluno10);

    }
    @GetMapping
    public List<Message> findAll(@RequestParam(required = false) String message){
        if(message != null) {
            return messages.stream()
                    .filter(msg -> msg.getMessage().contains(message))
                    .collect(Collectors.toList());
        }
        return messages;
    }
    @GetMapping("/{Id}")
    public Message findById(@PathVariable("id") Integer id){
    return this.messages.stream().filter(msg -> msg.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Message message){
        if(message.getId() == null){
            message.setId(messages.size() + 1);

        }
        messages.add(message);
        return new ResponseEntity<>(message.getId(), HttpStatus.CREATED);

    }
    @PutMapping
    public ResponseEntity update(@RequestBody final Message message){
        messages.stream()
        .filter(msg -> msg.getId().equals(message.getId()))
                .forEach(msg -> msg.setMessage(message.getMessage()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping
    public ResponseEntity delete(@PathVariable("id") Integer id){
        messages.removeIf(msg -> msg.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
