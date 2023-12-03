package br.com.unincor.web.model.dao;

import br.com.unincor.web.model.domain.Cliente;
import br.com.unincor.web.model.domain.Conta;
import br.com.unincor.web.model.domain.ContaCorrente;
import br.com.unincor.web.model.domain.Emprestimo;
import jakarta.persistence.Query;
import java.util.List;


public class ContaDao extends GenericDao<Conta, Long>{
    public List<Conta> buscaContaCliente(Cliente cliente){
        String sql = "from Conta c where c.cliente = :cliente";
        
        Query query = getEntityManager().createQuery(sql, Cliente.class)
                .setParameter("cliente", cliente);
        return query.getResultList();

    }

    public Conta buscaContaPorNumero(Integer numero) {
        String sql = "from Conta c where c.numero = :numero";
        
        Query query = getEntityManager().createQuery(sql, Cliente.class)
                .setParameter("numero", numero);
         var resultado = query.getResultList();
        return resultado.isEmpty() ? null : (Conta) resultado.get(0);
            }
    
    public ContaCorrente buscaContaCorrentePorCliente(Cliente cliente){
        String sql = "from Conta c where c.cliente = :cliente and c.tipo = CORRENTE";
        
        Query query = getEntityManager().createQuery(sql, Cliente.class)
                .setParameter("cliente", cliente);
         var resultado = query.getResultList();
        return resultado.isEmpty() ? null : (ContaCorrente) resultado.get(0);
    }
    
    public ContaCorrente buscaContaPoupancaPorCliente(Cliente cliente){
        String sql = "from Conta c where c.cliente = :cliente and c.tipo = POUPANCA";
        
        Query query = getEntityManager().createQuery(sql, Cliente.class)
                .setParameter("cliente", cliente);
         var resultado = query.getResultList();
        return resultado.isEmpty() ? null : (ContaCorrente) resultado.get(0);
    }
    
    public List<Emprestimo> buscaEmprestimoPorCliente(Conta conta){
        String sql = "from Emprestimo e where e.conta = :conta and e.status = Pendente";
        
        Query query = getEntityManager().createQuery(sql, Conta.class)
                .setParameter("conta", conta);
         return query.getResultList();
        
    }
    
     public List<Emprestimo> buscaEmprestimo(Conta conta){
        String sql = "from Emprestimo e where e.conta = :conta";
        
        Query query = getEntityManager().createQuery(sql, Conta.class)
                .setParameter("conta", conta);
         return query.getResultList();
        
    }
}
