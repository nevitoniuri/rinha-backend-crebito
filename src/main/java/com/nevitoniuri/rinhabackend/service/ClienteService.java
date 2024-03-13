package com.nevitoniuri.rinhabackend.service;

import com.nevitoniuri.rinhabackend.model.Cliente;
import com.nevitoniuri.rinhabackend.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ClienteService {

  private final ClienteRepository clienteRepository;

  public Cliente findByIdOrThrow(Long id) {
    return clienteRepository.findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
  }

  public Cliente save(Cliente cliente) {
    return clienteRepository.save(cliente);
  }
}
