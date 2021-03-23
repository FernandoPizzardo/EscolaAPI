package br.com.mentorama.alomundo;

public class Message {
    public Message(Integer id,String message) {
        this.id = id;
        this.message = message;

    }
    public Integer id;
    public String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
