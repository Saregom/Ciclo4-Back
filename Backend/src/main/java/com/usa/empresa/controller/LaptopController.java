package com.usa.empresa.controller;

import com.usa.empresa.entity.Laptop;
import com.usa.empresa.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/supplements")
@CrossOrigin("*")
public class LaptopController {
    @Autowired
    private LaptopService accessoryService;

    @GetMapping("/all")
    public List<Laptop> getAll() {
        return accessoryService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Laptop> getClothe(@PathVariable("reference") Integer reference) {
        return accessoryService.getcomp(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop create(@RequestBody Laptop gadget) {
        return accessoryService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") Integer reference) {
        return accessoryService.delete(reference);
    }

}
