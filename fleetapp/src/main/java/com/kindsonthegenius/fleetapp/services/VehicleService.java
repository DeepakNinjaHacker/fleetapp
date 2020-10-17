package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Vehicle;
import com.kindsonthegenius.fleetapp.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();
	}

	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	public Optional<Vehicle> findById(Integer id) {
		return vehicleRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleRepository.deleteById(id);
	}
}
