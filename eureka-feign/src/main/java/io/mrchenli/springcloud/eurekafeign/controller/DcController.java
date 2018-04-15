package io.mrchenli.springcloud.eurekafeign.controller;

import io.mrchenli.springcloud.eurekafeign.interfaces.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    @Autowired
    DcClient dcClient;
    @GetMapping("/consumer")
    public String dc(){
        return dcClient.consumer();
    }


}
