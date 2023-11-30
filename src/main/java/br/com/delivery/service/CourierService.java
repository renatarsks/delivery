package br.com.delivery.service;

import java.util.List;

import br.com.delivery.entity.Courier;

public interface CourierService {
	
	Courier insertCourier(Courier courier);
    List<Courier> getAllCouriers();
    void deleteCourier(String cpf);
    Courier updateCourier(String cpf, Courier updatedCourier);
    Courier getCourierByCpf(String cpf);

}
