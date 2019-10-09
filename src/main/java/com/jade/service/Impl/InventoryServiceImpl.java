package com.jade.service.Impl;

import com.jade.domain.Inventory;
import com.jade.repository.InventoryRepository;
import com.jade.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private static InventoryService service = null;

    @Autowired
    private InventoryRepository repository;

    @Override
    public List<Inventory> getAll() {
        return repository.findAll();
    }

    @Override
    public Inventory create(Inventory inventory) {
        return this.repository.save(inventory);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return this.repository.save(inventory);
    }

    @Override
    public Inventory read(String s) {
        Optional<Inventory> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
