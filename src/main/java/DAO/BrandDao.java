
package DAO;

import Conexao.DB;
import Conexao.DBException;
import Entidades.Brand;
import java.util.List;
import java.util.stream.Collectors;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.exceptions.NitriteException;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

public class BrandDao {
    
    // Repositório para armazenar objetos da classe 'Brand' no banco de dados Nitrite.
    private static ObjectRepository<Brand> repBrand;
    
    // Bloco estático que inicializa o repositório 'repBrand' ao carregar a classe.
    static {
        repBrand = DB.getDB().getRepository(Brand.class);
    }
    
    // Método para inserir uma nova marca no banco de dados.
    public static void insert(Brand brand) {
        try {
            repBrand.insert(brand); // Insere o objeto 'brand' no repositório.
        } catch (NitriteException e) {
            throw new DBException(e.getMessage()); // Lança uma exceção personalizada se ocorrer um erro.
        }
    }
    
    // Método para atualizar uma marca existente no banco de dados.
    public static void update(Brand brand) {
        // Procura uma marca no banco de dados que tenha o mesmo nome.
        Brand temp = repBrand.find(ObjectFilters.eq("name", brand.getName()))
                .firstOrDefault();
        
        // Verifica se a marca encontrada é igual à marca a ser atualizada ou se não existe no banco.
        if (brand.equals(temp) || temp == null) {
            repBrand.update(brand); // Atualiza a marca no banco de dados.
            
            // Atualiza as marcas dos produtos que estão associados à marca atualizada.
            ProductDao.findAll().stream().filter(p -> p.getBrand().equals(brand))
                    .collect(Collectors.toList()).forEach(p -> {
                        p.setBrand(brand);
                        ProductDao.update(p); // Atualiza cada produto com a marca nova.
                    });
            
        } else {
            // Lança uma exceção personalizada se outra marca com o mesmo nome já existir.
            throw new DBException("A marca digitada já existe.");
        }
    }
    
    // Método para buscar marcas com base em uma expressão regular aplicada ao nome.
    public static List<Brand> search(String arg0) {
        List<Brand> list = repBrand.find(ObjectFilters.regex("name", arg0),
                FindOptions.sort("name", SortOrder.Ascending)).toList(); // Retorna uma lista de marcas que correspondem ao padrão fornecido.
        
        return list;
    }
    
    // Método para retornar todas as marcas do banco de dados, ordenadas por nome.
    public static List<Brand> findAll() {
        List<Brand> list = repBrand.find(FindOptions
                .sort("name", SortOrder.Ascending)).toList();
        return list;
    }
    
    // Método para encontrar uma marca pelo seu identificador único (NitriteId).
    public static Brand findById(NitriteId id) {
        Brand c = repBrand.getById(id); // Retorna a marca correspondente ao ID.
        return c;
    }
    
    // Método para encontrar uma marca pelo seu nome.
    public static Brand findByName(String name) {
        Brand brand = repBrand.find(ObjectFilters.eq("name", name)).firstOrDefault(); // Retorna a primeira marca que corresponde ao nome fornecido.
        return brand;
    }
    
    // Método para remover uma marca específica do banco de dados.
    public static void remove(Brand brand) {
        repBrand.remove(brand); // Remove o objeto 'brand' do repositório.
    }
    
    // Método para remover uma marca pelo seu identificador único.
    public static void removeById(NitriteId id) {
        Brand brand = findById(id); // Encontra a marca pelo ID.
        remove(brand); // Remove a marca encontrada.
    }
}

