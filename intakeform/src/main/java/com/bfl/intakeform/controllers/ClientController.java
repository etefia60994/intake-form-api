package com.bfl.intakeform.controllers;

import com.bfl.intakeform.model.Client;
import com.bfl.intakeform.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository){
        super();
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients")
      public Collection<Client> clients(){
        return clientRepository.findAll();
    }

    //client/2
    @GetMapping("/client/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id){
        Optional<Client> client = clientRepository.findById(id);
        return client.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }



    @PostMapping("/client")
    ResponseEntity<Client> createClient(@Valid @RequestBody Client client) throws URISyntaxException {
        Client result= clientRepository.save(client);
        return ResponseEntity.created(new URI("/api/client" + result.getId())).body(result);

    }


    @PutMapping("/client/{id}")
    ResponseEntity<Client> updateClient(@Valid @RequestBody Client client){
        Client result= clientRepository.save(client);
        return ResponseEntity.ok().body(result);
    }



    @DeleteMapping("/client/{id}")
    ResponseEntity<?> deleteClient(@PathVariable Long id){
        clientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }




}
