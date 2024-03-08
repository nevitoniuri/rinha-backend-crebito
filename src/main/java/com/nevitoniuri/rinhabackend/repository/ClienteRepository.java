package com.nevitoniuri.rinhabackend.repository;

import com.nevitoniuri.rinhabackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
