
package DAO;
import Conexao.DB;
import Conexao.DBException;
import Entidades.Customer;
import java.util.List;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.exceptions.NitriteException;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

public class CustomerDao {

    // Declaração do repositório que armazenará objetos do tipo Customer.
    private static ObjectRepository<Customer> repCustomer;

    // Bloco estático para inicializar o repositório de clientes no momento em que a classe é carregada.
    static {
        repCustomer = DB.getDB().getRepository(Customer.class);
    }

    // Método para inserir um novo cliente no banco de dados.
    public static void insert(Customer obj) {
        try {
            repCustomer.insert(obj);  // Insere o objeto do tipo Customer no repositório.
        } catch (NitriteException e) {
            // Se houver um erro durante a inserção, uma exceção personalizada é lançada.
            throw new DBException("Já existe um cliente com este CPF no sistema.");
        }
    }

    // Método para atualizar um cliente existente no banco de dados.
    public static void update(Customer obj) {
        // Verifica se já existe um cliente com o CPF especificado.
        Customer temp = repCustomer.find(ObjectFilters.eq("cpf", obj.getName()))
                .firstOrDefault();
        
        // Se o cliente for encontrado e não houver duplicidade de CPF, ele é atualizado.
        if (obj.equals(temp) || temp == null) {
            repCustomer.update(obj);          
        }
        else {
            // Se houver duplicidade de CPF, uma exceção personalizada é lançada.
            throw new DBException("Já existe um cliente com este CPF no sistema.");
        }
    }

    // Método para buscar todos os clientes no banco de dados.
    public static List<Customer> findAll() {
        // Ordena a lista de clientes por nome em ordem ascendente.
        FindOptions fo = FindOptions.sort("name", SortOrder.Ascending);
        List<Customer> listClient = repCustomer.find(fo).toList();
        return listClient;
    }

    // Método para buscar um cliente específico pelo CPF.
    public static Customer findByCpf(String cpf) {
        Customer obj = repCustomer.find(ObjectFilters.eq("cpf", cpf)).firstOrDefault();
        return obj;
    }

    // Método para remover um cliente do banco de dados.
    public static void remove(Customer obj) {
        repCustomer.remove(obj);
    }

    // Método para buscar clientes por nome ou CPF.
    public static List<Customer> search(String searchClient) {
        // Converte a string de pesquisa para maiúsculas.
        String str = searchClient.toUpperCase();

        // Busca clientes cujo nome corresponda ao padrão ou cujo CPF corresponda exatamente.
        List<Customer> list = repCustomer.find(ObjectFilters.or(
                ObjectFilters.regex("name", str),
                ObjectFilters.eq("cpf", str)),
                FindOptions.sort("name", SortOrder.Ascending))
                .toList();
        return list;
    }

}
