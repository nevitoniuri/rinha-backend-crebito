package com.nevitoniuri.rinhabackend.service;

import com.nevitoniuri.rinhabackend.controller.request.CriarTransacaoRequest;
import com.nevitoniuri.rinhabackend.model.Cliente;
import com.nevitoniuri.rinhabackend.model.Transacao;
import com.nevitoniuri.rinhabackend.repository.TransacaoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransacaoService {

  private final TransacaoRepository transacaoRepository;

  public List<Transacao> findByClienteId(Long clienteId) {
    return transacaoRepository.findByClienteId(clienteId);
  }

  public void criarTransacao(Cliente cliente, CriarTransacaoRequest request) {
    
  }
}
