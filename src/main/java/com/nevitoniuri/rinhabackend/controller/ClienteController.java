package com.nevitoniuri.rinhabackend.controller;

import com.nevitoniuri.rinhabackend.controller.response.TransacaoResponse;
import com.nevitoniuri.rinhabackend.helper.ClienteHelper;
import com.nevitoniuri.rinhabackend.model.Transacao;
import com.nevitoniuri.rinhabackend.service.TransacaoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ClienteController {

  private final TransacaoService transacaoService;

  @GetMapping("/{clienteId}/extrato")
  public List<TransacaoResponse> getExtrato(@PathVariable Long clienteId) {
   return transacaoService.findByClienteId(clienteId)
       .stream().map(ClienteHelper::toTransacaoResponse)
       .toList();
  }

}
