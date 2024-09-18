package com.ndbk.uber.service;

import com.ndbk.uber.dto.CreateClientRequest;
import com.ndbk.uber.dto.UpdateClientRequest;
import com.ndbk.uber.model.Client;
import com.ndbk.uber.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

  @Autowired
  final ClientRepository _clientRepository;

  public ClientService(ClientRepository clientRepository) {
    _clientRepository = clientRepository;
  }

  public Optional<Client> getClient(int id){
    return _clientRepository.findById(id);
  }

  public void deleteClient(int clientId){
    if(!_clientRepository.existsById(clientId)){
      return;
    }

    _clientRepository.deleteById(clientId);
  }

  public Client create(CreateClientRequest createClientRequest){
    Client newClient = new Client();
    newClient.setName(createClientRequest.name);
    newClient.setGender(createClientRequest.gender);

    return _clientRepository.save(newClient);
  }

  public Client update(UpdateClientRequest updateClientRequest){
    return _clientRepository
            .findById(updateClientRequest.id)
            .map(client -> {
              client.setName(updateClientRequest.name);
              client.setGender(updateClientRequest.gender);
              return _clientRepository.save(client);
            })
            .orElse(null);
  }
}
