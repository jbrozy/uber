package com.ndbk.uber.controller;

import com.ndbk.uber.dto.CreateClientRequest;
import com.ndbk.uber.dto.UpdateClientRequest;
import com.ndbk.uber.model.Client;
import com.ndbk.uber.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/client")
public class ClientController {
  private final ClientService _clientService;

  public ClientController(ClientService clientService){
    _clientService = clientService;
  }

  @GetMapping("{clientId}")
  public ResponseEntity<Client> GetClientById(@PathVariable int clientId){
    Optional<Client> client = _clientService.getClient(clientId);
    return ResponseEntity.of(client);
  }

  @DeleteMapping("{clientId}")
  public ResponseEntity deleteClient(@PathVariable int clientId){
    _clientService.deleteClient(clientId);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity<Client> Create(@RequestBody CreateClientRequest createClientRequest){
    Client createdClient = _clientService.create(createClientRequest);

    return ResponseEntity.ok().body(createdClient);
  }

  @PutMapping
  public ResponseEntity<Client> Update(@RequestBody UpdateClientRequest updateClientRequest){
    Client updatedClient = _clientService.update(updateClientRequest);

    return ResponseEntity.ok().body(updatedClient);
  }
}
