package com.nevitoniuri.rinhabackend.repository;

import com.nevitoniuri.rinhabackend.model.Transacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

  List<Transacao> findByClienteId(Long clienteId);
}
