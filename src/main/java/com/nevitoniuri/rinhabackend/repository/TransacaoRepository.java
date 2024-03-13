package com.nevitoniuri.rinhabackend.repository;

import com.nevitoniuri.rinhabackend.model.Cliente;
import com.nevitoniuri.rinhabackend.model.Transacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

  @Query("SELECT t FROM Transacao t WHERE t.cliente = :cliente ORDER BY t.data DESC LIMIT 10")
  List<Transacao> findFirst10ByClienteOrderByDataDesc(Cliente cliente);
}
