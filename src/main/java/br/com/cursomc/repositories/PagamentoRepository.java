package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursomc.domains.Pagamento;

//Criar apenas da super classe, já abrange todas.
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
