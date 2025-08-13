package controller;

import entity.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import repository.ClienteRepository;
import service.IClienteService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController(value = "/cliente")
public class ClienteController {

    private final IClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clienteService.deleteById(id);
    }

}
