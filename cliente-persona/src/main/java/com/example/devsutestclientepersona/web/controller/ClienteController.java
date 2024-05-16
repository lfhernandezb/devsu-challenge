package com.example.devsutestclientepersona.web.controller;

import com.example.devsutestclientepersona.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.devsutestclientepersona.persistence.entity.Cliente;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAll() {
        return new ResponseEntity<>(clienteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getByClienteId(@PathVariable("id") long clientId) {
        return clienteService.getById(clientId).map(
                cliente -> new ResponseEntity<>(cliente, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/param")
    public ResponseEntity<Cliente> getByClienteNombre(@RequestParam("nombre") String nombre) {
        return clienteService.getByNombre(nombre).map(
                cliente -> new ResponseEntity<>(cliente, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }

    @PatchMapping("/save")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long clientId) {
        if (clienteService.delete(clientId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
