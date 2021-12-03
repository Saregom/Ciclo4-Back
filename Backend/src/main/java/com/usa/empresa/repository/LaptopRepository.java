package com.usa.empresa.repository;

import com.usa.empresa.entity.Laptop;
import com.usa.empresa.repository.crud.LaptopCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LaptopRepository {

    @Autowired
        private LaptopCrudRepository LaptopCrudRepository;

        public List<Laptop> getAll() {
            return LaptopCrudRepository.findAll();
        }

        public Optional<Laptop> getId(Integer id) {
            return LaptopCrudRepository.findById(id);
        }
        public Laptop create(Laptop comp) {
            return LaptopCrudRepository.save(comp);
        }

        public void update(Laptop comp) {
            LaptopCrudRepository.save(comp);
        }

        public void delete(Laptop comp) {
            LaptopCrudRepository.delete(comp);
        }
    }

