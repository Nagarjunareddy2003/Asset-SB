package com.Vcube.Asserts.SB.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vcube.Asserts.SB.exception.ResourceNotFoundException;
import com.Vcube.Asserts.SB.modal.Allocation;
import com.Vcube.Asserts.SB.modal.Asset;
import com.Vcube.Asserts.SB.modal.Employee;
import com.Vcube.Asserts.SB.repository.AllocationRepository;
import com.Vcube.Asserts.SB.repository.AssetRepository;
import com.Vcube.Asserts.SB.repository.EmployeeRepository;

@Service
@RequestMapping("assert")
public class AssetService {
	
    @Autowired
    private AssetRepository assetRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private AllocationRepository allocationRepo;
    
    public Employee addEmployee(Employee emp) {
    	return employeeRepo.save(emp);
    }
    
    public List<Employee> allemployee(){
    	return employeeRepo.findAll();
    }
	
	 public Asset addAsset(Asset asset) {
	        asset.setStatus("AVAILABLE");
	        return assetRepo.save(asset);
	    }

	    // Get All Assets
	    public List<Asset> getAllAssets() {
	        return assetRepo.findAll();
	    }
	    
	    public Asset update(Long id,Asset updatedAsset) {
	    	Asset existing= assetRepo.findById(id).orElseThrow();
	    	existing.setAssetName(updatedAsset.getAssetName());
	        existing.setCategory(updatedAsset.getCategory());
	        existing.setSerialNumber(updatedAsset.getSerialNumber());
	        existing.setStatus(updatedAsset.getStatus());
	    	return assetRepo.save(existing);
	    }
	    public String delete (Long id) {
	    	assetRepo.deleteById(id);
	    	return "delte the item";
	    }

	    // Allocate Asset
	    public String allocateAsset(Long assetId, Long employeeId) {

	        Asset asset = assetRepo.findById(assetId)
	                .orElseThrow(() -> new ResourceNotFoundException("Asset Not Found"));

	        Employee employee = employeeRepo.findById(employeeId)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));

	        if (!asset.getStatus().equals("ALLOCATED")) {
	            return "Asset is already allocated!";
	        }

	        Allocation allocation = new Allocation();
	        allocation.setAsset(asset);
	        allocation.setEmployee(employee);
	        allocation.setAllocatedDate(LocalDate.now());

	        asset.setStatus("ALLOCATED");

	        allocationRepo.save(allocation);
	        assetRepo.save(asset);

	        return "Asset Allocated Successfully!";
	    }

	    // Return Asset
	    public String returnAsset(Long allocationId) {

	        Allocation allocation = allocationRepo.findById(allocationId)
	                .orElseThrow(() -> new ResourceNotFoundException("Allocation Not Found"));

	        allocation.setReturnedDate(LocalDate.now());

	        Asset asset = allocation.getAsset();
	        asset.setStatus("AVAILABLE");

	        allocationRepo.save(allocation);
	        assetRepo.save(asset);

	        return "Asset Returned Successfully!";
	    }

}
