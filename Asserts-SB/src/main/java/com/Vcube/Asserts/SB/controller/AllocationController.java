package com.Vcube.Asserts.SB.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Vcube.Asserts.SB.service.AssetService;

@RestController
@RequestMapping("/allocation")
public class AllocationController {

    @Autowired
    private AssetService service;

    @PostMapping("/allocate")
    public String allocate(@RequestParam Long assetId,
                           @RequestParam Long employeeId) {
        return service.allocateAsset(assetId, employeeId);
    }

    @PostMapping("/return")
    public String returnAsset(@RequestParam Long allocationId) {
        return service.returnAsset(allocationId);
    }
}