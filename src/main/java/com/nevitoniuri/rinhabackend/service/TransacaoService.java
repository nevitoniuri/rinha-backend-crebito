package com.nevitoniuri.rinhabackend.service;

import static java.lang.Math.abs;

import com.nevitoniuri.rinhabackend.model.Cliente;
import com.nevitoniuri.rinhabackend.model.Transacao;
import com.nevitoniuri.rinhabackend.model.enums.TipoTransacao;
import com.nevitoniuri.rinhabackend.repository.TransacaoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class TransacaoService {

  private final TransacaoRepository transacaoRepository;

  public List<Transacao> listarUltimasTransacoes(Cliente cliente) {
    return transacaoRepository.findFirst10ByClienteOrderByDataDesc(cliente);
  }

  @Transactional
  public void criarTransacao(Cliente cliente, String tipo, Integer valor, String descricao) {
    var tipoTransacao = TipoTransacao.fromString(tipo);
    var transacao = Transacao.builder()
        .cliente(cliente)
        .tipo(tipoTransacao)
        .valor(valor)
        .descricao(descricao)
        .build();

    validarTransacao(transacao);

    if (transacao.getTipo().equals(TipoTransacao.DEBITO)) {
      cliente.setSaldo(cliente.getSaldo() - valor);
      validarNovoSaldo(cliente);
    }

    if (transacao.getTipo().equals(TipoTransacao.CREDITO)) {
      cliente.setSaldo(cliente.getSaldo() + valor);
    }

    transacaoRepository.save(transacao);
  }

  private void validarTransacao(Transacao transacao) {
    if (transacao.getTipo() == null) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
          "Tipo de transação inválido");
    }
    if (transacao.getDescricao() != null && transacao.getDescricao().length() > 10) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
          "Descrição deve ter no máximo 10 caracteres");
    }
  }

  private void validarNovoSaldo(Cliente cliente) {
    if (abs(cliente.getSaldo()) > cliente.getLimite()) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Saldo insuficiente");
    }
  }

}
