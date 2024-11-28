package DAO;

import Conexao.DB;
import Conexao.DBException;
import Entidades.SizePattern;
import java.util.Arrays;
import java.util.List;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

public class SizePatternDao {
    
    private static ObjectRepository<SizePattern> repSizePattern;
    
    static {
        // Obtém o repositório de SizePattern
        repSizePattern = DB.getDB().getRepository(SizePattern.class);
        
        // Verifica se o repositório está vazio
        if (repSizePattern.size() == 0) {
            // Cria e insere padrões de tamanhos iniciais no repositório
            
            SizePattern sp1 = new SizePattern("N1");
            List<String> sizeList = Arrays.asList("34", "36", "38", "40", "42",
                    "44", "46", "48", "50", "52", "54");
            sp1.getSizes().addAll(sizeList);
            
            SizePattern sp2 = new SizePattern("N2");
            sizeList = Arrays.asList("PP", "P", "M", "G", "GG", "XG", "XGG", "EG",
                    "EGG");
            sp2.getSizes().addAll(sizeList);
            // Insere os padrões no repositório
            repSizePattern.insert(sp1, sp2);
        }
    }
    
    // Retorna todos os padrões de tamanhos
    public static List<SizePattern> findAll() {
        List<SizePattern> list = repSizePattern.find().toList();
        return list;
    }
    
    // Encontra um padrão de tamanhos pelo ID
    public static SizePattern findById(NitriteId id) {
        SizePattern sp = repSizePattern.getById(id);
        return sp;
    }
    
    // Encontra um padrão de tamanhos pelo nome
    public static SizePattern findByName(String name) {
        SizePattern sp = repSizePattern.find(ObjectFilters.eq("name", name))
                .firstOrDefault();
        
        // Lança uma exceção se não encontrar o padrão com o nome especificado
        if (sp == null) {
            throw new DBException("Não existe um padrão salvo com esse nome.");
        }
        return sp;
    }
    
    // Insere um novo padrão de tamanhos
    public static void insert(SizePattern sp) {
        repSizePattern.insert(sp);
    }
    
    // Atualiza um padrão de tamanhos existente
    public static void update(SizePattern sp) {
        // Verifica se já existe um padrão com o mesmo nome
        SizePattern temp = repSizePattern.find(ObjectFilters.eq("name", sp.getName()))
                .firstOrDefault();
        
        // Atualiza o padrão se não houver conflito ou se não encontrar nenhum padrão com o nome especificado
        if (sp.equals(temp) || temp == null) {
            repSizePattern.update(sp);
        }
        else {
            throw new DBException("Já existe um padrão com esse nome no sistema.");
        }
    }
    
    // Remove um padrão de tamanhos
    public static void remove(SizePattern sp) {
        repSizePattern.remove(sp);
    }
}
