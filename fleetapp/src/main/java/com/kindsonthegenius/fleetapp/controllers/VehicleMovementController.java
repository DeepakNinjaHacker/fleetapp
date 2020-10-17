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

import com.kindsonthegenius.fleetapp.models.VehicleMovement;
import com.kindsonthegenius.fleetapp.models.Location;
import com.kindsonthegenius.fleetapp.models.Vehicle;
import com.kindsonthegenius.fleetapp.services.VehicleMovementService;
import com.kindsonthegenius.fleetapp.services.VehicleService;
import com.kindsonthegenius.fleetapp.services.LocationService;

@Controller
public class VehicleMovementController {
	@Autowired
	private VehicleMovementService vehicleMovementService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;

	@GetMapping("/vehicleMovement")
	public String getVehicleMovements(Model model) {
		List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
		model.addAttribute("vehicleMovements", vehicleMovementList);


		List<Vehicle> vehicleList = vehicleService.getVehicles();
		model.addAttribute("vehicles", vehicleList);

		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locations", locationList);
		
		return "vehicle_movement";
	}

	@RequestMapping("/vehicleMovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		System.out.println("Reached here vehicleMovements/addNew"); 
		
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovement";
	}

	@RequestMapping("/vehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementService.findById(id);

	}

	@RequestMapping(value = "/vehicleMovements/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovement";
	}

	@RequestMapping(value = "/vehicleMovements/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovement";
	}

}
