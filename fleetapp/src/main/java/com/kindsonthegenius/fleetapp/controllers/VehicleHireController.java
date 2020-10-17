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

import com.kindsonthegenius.fleetapp.models.VehicleHire;
import com.kindsonthegenius.fleetapp.models.Client;
import com.kindsonthegenius.fleetapp.models.Location;
import com.kindsonthegenius.fleetapp.models.Vehicle;
import com.kindsonthegenius.fleetapp.services.VehicleHireService;
import com.kindsonthegenius.fleetapp.services.VehicleService;
import com.kindsonthegenius.fleetapp.services.ClientService;
import com.kindsonthegenius.fleetapp.services.LocationService;

@Controller
public class VehicleHireController {
	@Autowired
	private VehicleHireService vehicleHireService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private ClientService clientService;

	@GetMapping("/vehicleHire")
	public String getVehicleHires(Model model) {
		List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
		model.addAttribute("vehicleHires", vehicleHireList);

		List<Vehicle> vehicleList = vehicleService.getVehicles();
		model.addAttribute("vehicles", vehicleList);

		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locations", locationList);
		
		List<Client> clientList = clientService.getClients();
		model.addAttribute("clients", clientList);
		
		return "vehicle_hire";
	}

	@RequestMapping("/vehicleHires/addNew")
	public String addNew(VehicleHire vehicleHire) {
		System.out.println("Reached here vehicleHires/addNew"); 
		
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHire";
	}

	@RequestMapping("/vehicleHires/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireService.findById(id);

	}

	@RequestMapping(value = "/vehicleHires/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHire";
	}

	@RequestMapping(value = "/vehicleHires/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/vehicleHire";
	}

}
