package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleHire;
import com.kindsonthegenius.fleetapp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {

	@Autowired
	private VehicleHireRepository vehicleHireRepository;

	public List<VehicleHire> getVehicleHires() {
		return vehicleHireRepository.findAll();
	}

	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}

	public Optional<VehicleHire> findById(Integer id) {
		return vehicleHireRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleHireRepository.deleteById(id);
	}
}
