package com.nevitoniuri.rinhabackend.service;

import com.nevitoniuri.rinhabackend.exception.ServiceError;
import com.nevitoniuri.rinhabackend.exception.ServiceException;
import com.nevitoniuri.rinhabackend.model.Cliente;
import com.nevitoniuri.rinhabackend.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

  private final ClienteRepository clienteRepository;

  public Cliente findByIdOrThrow(Long id) {
    return clienteRepository.findById(id)
        .orElseThrow(() -> new ServiceException(ServiceError.CLIENTE_NAO_ENCONTRADO));
  }

}
