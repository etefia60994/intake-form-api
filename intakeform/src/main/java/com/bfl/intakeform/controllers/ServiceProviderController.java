package com.bfl.intakeform.controllers;

import com.bfl.intakeform.model.ServiceProvider;
import com.bfl.intakeform.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ServiceProviderController {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    public ServiceProviderController(ServiceProviderRepository serviceProviderRepository){
        super();
        this.serviceProviderRepository = serviceProviderRepository;
    }

    @GetMapping("/serviceProviders")
    public Iterable<ServiceProvider> serviceProviders(){
        return serviceProviderRepository.findAll();
    }

    //serviceProvider/2
    @GetMapping("/serviceProvider/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id){
        Optional<ServiceProvider> serviceProvider = serviceProviderRepository.findById(id);
        return serviceProvider.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }



    @PostMapping("/serviceProvider")
    ResponseEntity<ServiceProvider> createServiceProvider(@Valid @RequestBody ServiceProvider serviceProvider) throws URISyntaxException {
        ServiceProvider result= serviceProviderRepository.save(serviceProvider);
        return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);

    }


    @PutMapping("/serviceProvider/{id}")
    ResponseEntity<ServiceProvider> updateServiceProvider(@Valid @RequestBody ServiceProvider serviceProvider){
        ServiceProvider result= serviceProviderRepository.save(serviceProvider);
        return ResponseEntity.ok().body(result);
    }



    @DeleteMapping("/serviceProvider/{id}")
    ResponseEntity<?> deleteServiceProvider(@PathVariable Long id){
        serviceProviderRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
