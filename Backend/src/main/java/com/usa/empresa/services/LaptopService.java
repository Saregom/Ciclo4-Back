package com.usa.empresa.services;

import com.usa.empresa.entity.Laptop;
import com.usa.empresa.repository.LaptopRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
        private LaptopRepository LaptopRepository;

        public List<Laptop> getAll() {
            return LaptopRepository.getAll();
        }

        public Optional<Laptop> getcomp(Integer reference) {
            return LaptopRepository.getId(reference);
        }

        public Laptop create(Laptop accesory) {
            if (accesory.getModel() == null) {
                return accesory;
            } else {
                return LaptopRepository.create(accesory);
            }
        }

        public Laptop update(Laptop accesory) {

            if (accesory.getModel() != null) {
                Optional<Laptop> accesoryDb = LaptopRepository.getId(accesory.getId());
                if (!accesoryDb.isEmpty()) {

                    if (accesory.getBrand()!= null) {
                        accesoryDb.get().setBrand(accesory.getBrand());
                    }

                    if (accesory.getDescription() != null) {
                        accesoryDb.get().setDescription(accesory.getDescription());
                    }
                    if (accesory.getPrice() != 0.0) {
                        accesoryDb.get().setPrice(accesory.getPrice());
                    }
                    if (accesory.getQuantity() != 0) {
                        accesoryDb.get().setQuantity(accesory.getQuantity());
                    }
                    if (accesory.getPhotography() != null) {
                        accesoryDb.get().setPhotography(accesory.getPhotography());
                    }
                    accesoryDb.get().setAvailability(accesory.isAvailability());
                    LaptopRepository.update(accesoryDb.get());
                    return accesoryDb.get();
                } else {
                    return accesory;
                }
            } else {
                return accesory;
            }
        }

        public boolean delete(Integer reference) {
            Boolean aBoolean = getcomp(reference).map(accesory -> {
                LaptopRepository.delete(accesory);
                return true;
            }).orElse(false);
            return aBoolean;
        }


    }

