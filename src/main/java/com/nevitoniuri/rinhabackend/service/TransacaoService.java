package com.nevitoniuri.rinhabackend.service;

import static java.lang.Math.abs;

import com.nevitoniuri.rinhabackend.model.Cliente;
import com.nevitoniuri.rinhabackend.model.Transacao;
import com.nevitoniuri.rinhabackend.model.enums.TipoTransacao;
import com.nevitoniuri.rinhabackend.repository.TransacaoRepository;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class TransacaoService {

  private final TransacaoRepository transacaoRepository;

  public List<Transacao> findByClienteId(Long clienteId) {
    return transacaoRepository.findByClienteId(clienteId);
  }

  @Transactional
  public void criarTransacao(Cliente cliente, Integer valor, String tipo, String descricao) {
    validarDescricao(descricao);
    var tipoTransacao = TipoTransacao.fromString(tipo);
    switch (tipoTransacao) {
      case DEBITO -> validarTransacaoDebito(cliente, valor);
    }
    var transacao = Transacao.builder()
        .cliente(cliente)
        .tipo(tipoTransacao)
        .valor(valor)
        .descricao(descricao)
        .build();
    transacaoRepository.save(transacao);
  }

  private void validarDescricao(String descricao) {
    if (Objects.nonNull(descricao) && descricao.length() > 10) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
          "Descrição deve ter no máximo 10 caracteres");
    }
  }

  private void validarTransacaoDebito(Cliente cliente, Integer valor) {
    var novoSaldo = cliente.getSaldo() - valor;
    if (abs(novoSaldo) > cliente.getLimite()) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Saldo insuficiente");
    }
    cliente.setSaldo(novoSaldo);
  }

}
