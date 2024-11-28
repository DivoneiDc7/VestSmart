package DAO;

import Conexao.DB;
import Entidades.Sale;
import Util.CodeGenerator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

public class SaleDao {
    
    private static ObjectRepository<Sale> repSale;
    private static ObjectRepository<CodeGenerator> repCode;
    private static CodeGenerator codeGenerator;
    
    static {
        // Obtém o repositório de CodeGenerator
        repCode = DB.getDB().getRepository(CodeGenerator.class);
        
        // Verifica se o repositório de Sale já existe
        if (!DB.getDB().hasRepository(Sale.class)) {
            // Cria um novo CodeGenerator para Sale e o insere no banco de dados
            codeGenerator = new CodeGenerator(Sale.class.getSimpleName(), 0L);
            repCode.insert(codeGenerator);
        }
        else {
            // Obtém o CodeGenerator existente para Sale
            codeGenerator = repCode.find(ObjectFilters
                    .eq("classType", Sale.class.getSimpleName()))
                    .firstOrDefault();
        }
        // Obtém o repositório de Sale
        repSale = DB.getDB().getRepository(Sale.class);
    }
    
    // Insere uma nova venda e atualiza o CodeGenerator
    public static void insert(Sale sale) {
        // Incrementa o código da venda
        codeGenerator.setLastCode(codeGenerator.getLastCode() + 1);
        
        // Define o ID da venda
        sale.setId(codeGenerator.getLastCode());
        
        // Insere a venda no repositório
        repSale.insert(sale);
        // Atualiza o CodeGenerator
        repCode.update(codeGenerator);
    }
    
    // Retorna todas as vendas, ordenadas por data de forma decrescente
    public static List<Sale> findAll() {
        List<Sale> list = repSale.find(FindOptions.sort("moment", SortOrder.Descending))
                .toList();
        
        return list;
    }
    
    // Encontra uma venda pelo ID
    public static Sale findById(Long id) {
        Sale sale = repSale.find(ObjectFilters.eq("id", id)).firstOrDefault();
        return sale;
    }
    
    // Atualiza uma venda existente
    public static void update(Sale sale) {
        repSale.update(sale);
    }
    
    // Remove uma venda
    public static void remove(Sale sale) {
        repSale.remove(sale);
    }
    
    // Remove uma venda pelo ID
    public static void removeById(Long id) {
        Sale sale = findById(id);
        repSale.remove(sale);
    }
    
    // Retorna o número total de vendas
    public static Long size() {
        return repSale.size();
    }
    
    // Calcula a receita total dos últimos 'lastDays' dias
    public static Double revenues(Integer lastDays) {
        
        Double revenues = 0.0;
        Date d = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        
        List<Sale> sales;
        
        if(lastDays == 0) {
            // Se lastDays for 0, retorna todas as vendas
            sales = findAll();
        }
        else {
            // Caso contrário, retorna vendas dos últimos 'lastDays' dias
            cal.add(Calendar.DAY_OF_MONTH, - lastDays);
            sales = repSale.find(ObjectFilters.gte("moment", cal.getTime())).toList();
        }
        
        // Soma o total de todas as vendas
        for (Sale obj : sales) {
            revenues += obj.getTotal();
        }
        
        return revenues;
    }
    
    // Filtra vendas por um período específico
    public static List<Sale> filterByPeriod(Date start, Date end) {
        
        // Verifica se as datas são válidas
        if (start == null || end == null) {
            throw new IllegalArgumentException("As datas não podem ser nulas.");
        }
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException("A data inicial não pode ser depois da data final.");
        }
        
        // Ajusta a data final para o final do dia
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(end);
        calEnd.set(Calendar.HOUR_OF_DAY, 23);
        calEnd.set(Calendar.MINUTE, 59);
        calEnd.set(Calendar.SECOND, 59);
        end = calEnd.getTime();
        
        // Retorna as vendas no período especificado, ordenadas por data de forma decrescente
        List<Sale> sales = repSale.find(ObjectFilters.and(ObjectFilters.gte("moment", start),
                ObjectFilters.lte("moment", end)),
                FindOptions.sort("moment", SortOrder.Descending)).toList();
        
        return sales;
    }
}
