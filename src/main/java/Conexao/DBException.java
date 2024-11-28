package Conexao;

public class DBException extends RuntimeException { // A classe DBException estende RuntimeException, criando uma exceção personalizada.

    // Construtor da classe DBException que aceita uma mensagem de erro.
    public DBException(String msg) {
        super(msg); // Chama o construtor da classe pai (RuntimeException) passando a mensagem de erro.
    }
}
