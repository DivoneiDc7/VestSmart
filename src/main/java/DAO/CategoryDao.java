
package DAO;

import Conexao.DB;
import Conexao.DBException;
import Entidades.Category;
import java.util.List;
import java.util.stream.Collectors;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.exceptions.NitriteException;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

public class CategoryDao {
    // Repositório para armazenar objetos da classe 'Category' no banco de dados Nitrite.
    private static ObjectRepository<Category> repCategory;
    
    // Bloco estático que inicializa o repositório 'repCategory' ao carregar a classe.
    static {
        repCategory = DB.getDB().getRepository(Category.class);
    }
    
    // Método para inserir uma nova categoria no banco de dados.
    public static void insert(Category c) {
        try {
            repCategory.insert(c); // Insere o objeto 'Category' no repositório.
        } catch (NitriteException e) {
            throw new DBException(e.getMessage()); // Lança uma exceção personalizada em caso de erro.
        }
    }
   
    // Método para atualizar uma categoria existente no banco de dados.
    public static void update(Category c) {
        // Procura uma categoria no banco de dados que tenha o mesmo nome.
        Category temp = repCategory.find(ObjectFilters.eq("category", c.getCategory()))
                .firstOrDefault();
        
        // Verifica se a categoria encontrada é igual à categoria a ser atualizada ou se não existe no banco.
        if (c.equals(temp) || temp == null) {
            repCategory.update(c); // Atualiza a categoria no banco de dados.
            
            // Atualiza as categorias dos produtos que estão associados à categoria atualizada.
            ProductDao.findAll().stream().filter(p -> p.getCategory().equals(c))
                    .collect(Collectors.toList()).forEach(p -> {
                        p.setCategory(c);
                        ProductDao.update(p); // Atualiza cada produto com a nova categoria.
                    });
        } else {
            // Lança uma exceção personalizada se outra categoria com o mesmo nome já existir.
            throw new DBException("Essa categoria já existe.");
        }
    }
    
    // Método para retornar todas as categorias do banco de dados, ordenadas por nome.
    public static List<Category> findAll() {
        FindOptions fo = FindOptions.sort("category", SortOrder.Ascending);
        List<Category> list = repCategory.find(fo).toList();
        return list;
    }
    
    // Método para encontrar uma categoria pelo seu identificador único (NitriteId).
    public static Category findById(NitriteId id) {
        Category c = repCategory.getById(id); // Retorna a categoria correspondente ao ID.
        return c;
    }
    
    // Método para encontrar uma categoria pelo seu nome.
    public static Category findByName(String name) {
        Category category = repCategory.find(ObjectFilters.eq("category", name)).firstOrDefault(); // Retorna a primeira categoria que corresponde ao nome fornecido.
        return category;
    }
    
    // Método para buscar categorias com base em uma expressão regular aplicada ao nome.
    public static List<Category> search(String arg0) {
        List<Category> list = repCategory.find(ObjectFilters.regex("category", arg0),
                FindOptions.sort("category", SortOrder.Ascending)).toList(); // Retorna uma lista de categorias que correspondem ao padrão fornecido.
        
        return list;
    }
    
    // Método para remover uma categoria específica do banco de dados.
    public static void remove(Category c) {
        repCategory.remove(c); // Remove o objeto 'Category' do repositório.
    }
    
    // Método para remover uma categoria pelo seu identificador único.
    public static void removeById(NitriteId id) {
        Category c = findById(id); // Encontra a categoria pelo ID.
        remove(c); // Remove a categoria encontrada.
    }
}

