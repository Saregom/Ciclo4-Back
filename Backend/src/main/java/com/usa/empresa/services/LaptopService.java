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

    public Optional<Laptop> getIdLaptop(Integer id) {
        return LaptopRepository.getIdLaptop(id);
    }

    public Laptop save(Laptop laptop) {
        if (laptop.getModel() != null) {
            return LaptopRepository.save(laptop);
        } else {
            return laptop;
        }
    }

    public Laptop update(Laptop laptop) {
        if (laptop.getModel() != null) {
            Optional<Laptop> laptopAux = LaptopRepository.getIdLaptop(laptop.getId());
            if (!laptopAux.isEmpty()) {
                if (laptop.getBrand()!= null) {
                    laptopAux.get().setBrand(laptop.getBrand());
                }
                if (laptop.getModel()!= null) {
                    laptopAux.get().setBrand(laptop.getBrand());
                }
                if (laptop.getProcesor()!= null) {
                    laptopAux.get().setBrand(laptop.getBrand());
                }
                if (laptop.getOs()!= null) {
                    laptopAux.get().setDescription(laptop.getDescription());
                }
                if (laptop.getDescription()!= null) {
                    laptopAux.get().setDescription(laptop.getDescription());
                }
                if (laptop.getMemory()!= null) {
                    laptopAux.get().setDescription(laptop.getDescription());
                }
                if (laptop.getHardDrive()!= null) {
                    laptopAux.get().setDescription(laptop.getDescription());
                }
                if (laptop.getAvailability()!= null) {
                    laptopAux.get().setDescription(laptop.getDescription());
                }
                if (laptop.getPrice() != 0.0) {
                    laptopAux.get().setPrice(laptop.getPrice());
                }
                if (laptop.getQuantity() != 0) {
                    laptopAux.get().setQuantity(laptop.getQuantity());
                }
                if (laptop.getPhotography() != null) {
                    laptopAux.get().setPhotography(laptop.getPhotography());
                }
                //accesoryDb.get().setAvailability(laptop.isAvailability());
                LaptopRepository.update(laptopAux.get());
                return laptopAux.get();
            } else {
                return laptop;
            }
        } else {
            return laptop;
        }
    }

    public boolean delete(Integer id) {
        Optional<Laptop> laptop = getIdLaptop(id);
        if (laptop.isPresent()) {
            LaptopRepository.delete(laptop.get());
            return true;
        }
        return false;
    }
}