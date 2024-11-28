package Conexao; 

import org.dizitart.no2.Nitrite; 

public class DB {
    
    // Variável estática privada que armazena a instância do banco de dados Nitrite.
    private static Nitrite db = null;
    
    /**
     * Inicia a conexão com o banco de dados caso a variável 'db' seja nula.
     * Isso garante que a conexão só será estabelecida uma vez.
     */
    public static void start() {
        if (db == null) { // Verifica se a conexão já foi iniciada.
            db = Nitrite.builder() // Cria uma nova instância do banco de dados Nitrite.
                    .compressed() // Configura o banco de dados para usar compressão.
                    .filePath("bancoDeDados.db") // Define o caminho do arquivo do banco de dados.
                    .openOrCreate("root", "root"); // Abre ou cria o banco de dados com um usuário e senha.
        }
    }
    
    /**
     * Retorna a instância do banco de dados Nitrite.
     * Se a conexão ainda não foi iniciada, chama o método 'start()' para iniciar.
     * @return O banco de dados Nitrite.
     */
    public static Nitrite getDB() {
        if (db == null) { // Verifica se a conexão ainda não foi iniciada.
            start(); // Inicia a conexão se necessário.
        }
        return db; // Retorna a instância do banco de dados.
    }
    
    /**
     * Fecha a conexão com o banco de dados Nitrite.
     * É importante chamar este método quando o banco de dados não for mais necessário.
     */
    public static void close() {
        if (db != null) { // Verifica se o banco de dados está conectado.
            db.close(); // Fecha a conexão.
        }
    }
    
    /**
     * Verifica se a conexão com o banco de dados está fechada.
     * @return Retorna 'true' se o banco de dados estiver fechado, caso contrário, 'false'.
     */
    public static boolean isClosed() {
        if (db != null) return db.isClosed(); // Verifica se o banco de dados está fechado.
        return true; // Retorna 'true' se 'db' for nulo (conexão não foi iniciada).
    }
    
}
