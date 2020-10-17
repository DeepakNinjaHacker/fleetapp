package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleMaintenance;
import com.kindsonthegenius.fleetapp.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {


	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;

	public List<VehicleMaintenance> getVehicleMaintenances() {
		return vehicleMaintenanceRepository.findAll();
	}

	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}

	public Optional<VehicleMaintenance> findById(Integer id) {
		return vehicleMaintenanceRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleMaintenanceRepository.deleteById(id);
	}

}
