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

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.models.Vehicle;
import com.kindsonthegenius.fleetapp.services.EmployeeService;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.VehicleMakeService;
import com.kindsonthegenius.fleetapp.services.VehicleModelService;
import com.kindsonthegenius.fleetapp.services.VehicleService;
import com.kindsonthegenius.fleetapp.services.VehicleStatusService;
import com.kindsonthegenius.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleTypeService vehicleTypeService;
	@Autowired
	private VehicleMakeService vehicleMakeService;
	@Autowired
	private VehicleStatusService vehicleStatusService;
	@Autowired
	private VehicleModelService vehicleModelService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LocationService locationService;

	@GetMapping("/vehicles")
	public String getVehicles(Model model) {
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuss());
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("locations", locationService.getLocations());
		return "vehicle";
	}

	@RequestMapping("/vehicles/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}

	@RequestMapping("/vehicles/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id) {
		return vehicleService.findById(id);

	}

	@RequestMapping(value = "/vehicles/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}

	@RequestMapping(value = "/vehicles/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleService.delete(id);
		return "redirect:/vehicles";
	}

}
