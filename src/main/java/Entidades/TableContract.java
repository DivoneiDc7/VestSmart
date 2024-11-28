package Entidades;

// Interface que define um contrato para entidades que podem ser representadas em uma tabela
public interface TableContract {
    
    // Método que retorna um array de objetos representando uma linha da tabela
    Object[] tableRowModel();
}
