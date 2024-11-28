package DAO;

import Conexao.DB;
import Entidades.Product;
import Util.CodeGenerator;
import java.util.List;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

public class ProductDao {

    // Repositórios para Product e CodeGenerator
    private static ObjectRepository<Product> repProduct;
    private static ObjectRepository<CodeGenerator> repCode;
    private static CodeGenerator codeGenerator;
    
    static {
        // Inicializa o repositório de CodeGenerator
        repCode = DB.getDB().getRepository(CodeGenerator.class);
        
        // Verifica se já existe um repositório para Product
        if (!DB.getDB().hasRepository(Product.class)) {
            // Se não existir, cria um novo CodeGenerator e o insere no repositório
            codeGenerator = new CodeGenerator(Product.class.getSimpleName(), 0L);
            repCode.insert(codeGenerator);
        } else {
            // Se existir, recupera o CodeGenerator existente
            codeGenerator = repCode.find(ObjectFilters.eq("classType", Product.class.getSimpleName()))
                    .firstOrDefault();
        }
        
        // Inicializa o repositório de Product
        repProduct = DB.getDB().getRepository(Product.class);
    }
    
    // Retorna o repositório de Product
    public static ObjectRepository<Product> getProductRepository() {
        return repProduct;
    }
    
    // Insere um novo Product no repositório
    public static void insert(Product p) {
        // Atualiza o código do produto usando CodeGenerator
        codeGenerator.setLastCode(codeGenerator.getLastCode() + 1);
        p.setId(codeGenerator.getLastCode());
        
        // Insere o produto e atualiza o CodeGenerator
        repProduct.insert(p);
        repCode.update(codeGenerator);
    }
   
    // Atualiza um Product existente no repositório
    public static void update(Product p) {
        repProduct.update(p);
    }
    
    // Pesquisa produtos por descrição ou ID
    public static List<Product> search(String arg0) {
        String str = arg0.toUpperCase();
        Long id;
        
        try {
            // Tenta converter o argumento para Long (ID)
            id = Long.parseLong(arg0);
        } catch (NumberFormatException e) {
            id = null;
        }
        
        // Pesquisa por descrição ou ID, ordenando por descrição
        List<Product> list = repProduct.find(ObjectFilters.or(
                ObjectFilters.regex("description", str),
                ObjectFilters.eq("id", id)),
                FindOptions.sort("description", SortOrder.Ascending))
                .toList();
        
        return list;
    }
    
    // Retorna todos os produtos ordenados por descrição
    public static List<Product> findAll() {
        FindOptions fo = FindOptions.sort("description", SortOrder.Ascending);
        List<Product> list = repProduct.find(fo).toList();
        return list;
    }
    
    // Encontra um produto pelo ID
    public static Product findById(Long id) {
        Product p = repProduct.find(ObjectFilters.eq("id", id))
                .firstOrDefault();
        return p;
    }
    
    // Remove um Product do repositório
    public static void remove(Product p) {
        repProduct.remove(p);
    }
    
    // Remove um Product do repositório pelo ID
    public static void removeById(Long id) {
        Product p = findById(id);
        remove(p);
    }
}
