package com.Vcube.Asserts.SB.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vcube.Asserts.SB.modal.Asset;
import com.Vcube.Asserts.SB.service.AssetService;

@RestController
@RequestMapping("/assets")
public class AssetController {

	
	  @GetMapping("/")
	    public String home() {
	        return "Application Running Successfully!";
	    }
    @Autowired
    private AssetService service;

    @PostMapping("/insertassert")
    public Asset addAsset(@RequestBody Asset asset) {
        return service.addAsset(asset);
    }

    @GetMapping("/getallassert")
    public List<Asset> getAllAssets() {
        return service.getAllAssets();
    }
    
    @PutMapping("/updateassertby{id}")
    public Asset modifybyid(@PathVariable Long id,@RequestBody Asset asset) {
    	return service.update(id,asset);
    			
     }
    
    @DeleteMapping("/deleteby{id}")
    	public String deletebyid(@PathVariable Long id ) {
    	return service.delete(id);
    }
    
}