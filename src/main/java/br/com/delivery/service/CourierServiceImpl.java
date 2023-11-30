package br.com.delivery.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.entity.Courier;
import br.com.delivery.repository.CourierRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired
    private CourierRepository courierRepository;

    @Override
    public Courier insertCourier(Courier courier) {
        try {
            return courierRepository.save(courier);
        } catch (Exception e) {
          
            throw new ServiceException("Error while inserting courier", e);
        }
    }

    @Override
    public Courier getCourierByCpf(String cpf) {
        try {
            Optional<Courier> courierOptional = courierRepository.findById(cpf);

            if (courierOptional.isPresent()) {
                return courierOptional.get();
            } else {
                throw new EntityNotFoundException("Courier not found with CPF: " + cpf);
            }
        } catch (Exception e) {
            
            throw new ServiceException("Error while fetching courier by CPF", e);
        }
    }
    
    @Override
    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    @Override
    public void deleteCourier(String cpf) throws EntityNotFoundException {
        try {
            courierRepository.deleteById(cpf);
        } catch (Exception e) {
            throw new ServiceException("Error while deleting courier", e);
        }
        
    }

    @Override
    public Courier updateCourier(String cpf, Courier updatedCourier) {
        try {
            Optional<Courier> existingCourierOptional = courierRepository.findById(cpf);

            if (existingCourierOptional.isPresent()) {
                Courier existingCourier = existingCourierOptional.get();
                existingCourier.setName(updatedCourier.getName());
                existingCourier.setVehicleCapacity(updatedCourier.getVehicleCapacity());

                return courierRepository.save(existingCourier);
            } else {
                
                throw new EntityNotFoundException("Courier not found with CPF: " + cpf);
            }
        } catch (Exception e) {
            
            throw new ServiceException("Error while updating courier", e);
        }
    }
}