package com.nevitoniuri.rinhabackend.controller.response;

import java.io.Serializable;

public record ClienteResponse(String nome, Integer limite, Integer saldo) implements Serializable {

}