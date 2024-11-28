package DAO;

import Conexao.DB;
import Conexao.DBException;
import Entidades.Color;
import java.util.List;
import java.util.stream.Collectors;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.exceptions.NitriteException;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

public class ColorDao {

    // Repositório para armazenar objetos da classe 'Color' no banco de dados Nitrite.
    private static ObjectRepository<Color> repColor;

    // Bloco estático que inicializa o repositório 'repColor' ao carregar a classe.
    static {
        repColor = DB.getDB().getRepository(Color.class);
    }

    // Método para inserir uma nova cor no banco de dados.
    public static void insert(Color color) {
        try {
            repColor.insert(color); // Insere o objeto 'Color' no repositório.
        } catch (NitriteException e) {
            throw new DBException(e.getMessage()); // Lança uma exceção personalizada em caso de erro.
        }
    }

    // Método para atualizar uma cor existente no banco de dados.
    public static void update(Color c) {
        // Procura uma cor no banco de dados que tenha o mesmo nome.
        Color temp = repColor.find(ObjectFilters.eq("name", c.getName()))
                .firstOrDefault();

        // Verifica se a cor encontrada é igual à cor a ser atualizada ou se não existe no banco.
        if (c.equals(temp) || temp == null) {
            repColor.update(c); // Atualiza a cor no banco de dados.

            // Atualiza as cores dos produtos que estão associados à cor atualizada.
            ProductDao.findAll().stream().filter(p -> p.getColor().equals(c))
                    .collect(Collectors.toList()).forEach(p -> {
                p.setColor(c);
                ProductDao.update(p); // Atualiza cada produto com a nova cor.
            });

        } else {
            // Lança uma exceção personalizada se outra cor com o mesmo nome já existir.
            throw new DBException("A cor digitada já existe.");
        }
    }

    // Método para buscar cores com base em uma expressão regular aplicada ao nome.
    public static List<Color> search(String arg0) {
        List<Color> list = repColor.find(ObjectFilters.regex("name", arg0),
                FindOptions.sort("name", SortOrder.Ascending)).toList(); // Retorna uma lista de cores que correspondem ao padrão fornecido.

        return list;
    }

    // Método para retornar todas as cores do banco de dados, ordenadas por nome.
    public static List<Color> findAll() {
        List<Color> list = repColor.find(FindOptions
                .sort("name", SortOrder.Ascending)).toList();
        return list;
    }

    // Método para encontrar uma cor pelo seu identificador único (NitriteId).
    public static Color findById(NitriteId id) {
        Color c = repColor.getById(id); // Retorna a cor correspondente ao ID.
        return c;
    }

    // Método para encontrar uma cor pelo seu nome.
    public static Color findByName(String name) {
        Color color = repColor.find(ObjectFilters.eq("name", name)).firstOrDefault(); // Retorna a primeira cor que corresponde ao nome fornecido.
        return color;
    }

    // Método para remover uma cor específica do banco de dados.
    public static void remove(Color color) {
        repColor.remove(color); // Remove o objeto 'Color' do repositório.
    }

    // Método para remover uma cor pelo seu identificador único.
    public static void removeById(NitriteId id) {
        Color color = findById(id); // Encontra a cor pelo ID.
        remove(color); // Remove a cor encontrada.
    }
}
