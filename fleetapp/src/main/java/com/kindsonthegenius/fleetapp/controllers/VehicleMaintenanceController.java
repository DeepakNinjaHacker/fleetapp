package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.VehicleMaintenance;
import com.kindsonthegenius.fleetapp.models.Vehicle;
import com.kindsonthegenius.fleetapp.models.Supplier;
import com.kindsonthegenius.fleetapp.services.VehicleMaintenanceService;
import com.kindsonthegenius.fleetapp.services.VehicleService;
import com.kindsonthegenius.fleetapp.services.SupplierService;

@Controller
public class VehicleMaintenanceController

{
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private SupplierService supplierService;

	@GetMapping("/vehicleMaintenance")
	public String getVehicleMaintenances(Model model) {
		List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenances();
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceList);

		List<Vehicle> vehicleList = vehicleService.getVehicles();
		model.addAttribute("vehicles", vehicleList);

		List<Supplier> supplierList = supplierService.getSuppliers();
		model.addAttribute("suppliers", supplierList);
		
		return "vehicle_maintenance";
	}

	@RequestMapping("/vehicleMaintenances/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		System.out.println("Reached here vehicleMaintenances/addNew");

		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenance";
	}

	@RequestMapping("/vehicleMaintenances/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id) {
		return vehicleMaintenanceService.findById(id);

	}

	@RequestMapping(value = "/vehicleMaintenances/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenance";
	}

	@RequestMapping(value = "/vehicleMaintenances/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenance";
	}

}
