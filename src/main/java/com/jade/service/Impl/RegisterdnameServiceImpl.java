package com.jade.service.Impl;

import com.jade.domain.Registerdname;
import com.jade.repository.RegisterdnameRepository;
import com.jade.service.RegisterdnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterdnameServiceImpl implements RegisterdnameService{

    private static RegisterdnameService service = null;

    @Autowired
    private RegisterdnameRepository repository;


    @Override
    public List<Registerdname> getAll() {
        return repository.findAll();
    }

    @Override
    public Registerdname create(Registerdname registerdname) {
        return this.repository.save(registerdname);
    }

    @Override
    public Registerdname update(Registerdname registerdname) {
        return this.repository.save(registerdname);
    }

    @Override
    public Registerdname read(String s) {
        Optional<Registerdname> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
