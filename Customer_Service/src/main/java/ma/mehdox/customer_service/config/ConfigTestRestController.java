package ma.mehdox.customer_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestRestController {
    //--------For Injecting Value from application.properties into this field--------------//
    @Value("${global.params.p1}")
    private String p1_from_rest;
    @Value("${global.params.p2}")
    private String p2_from_rest ;
    @Autowired
    private CustomerConfigParams customerConfigParams;

    @GetMapping("/testConfig1")
    public Map<String,String> configTest(){
        return Map.of("p1",p1_from_rest,"p2",p2_from_rest);
    }
    @GetMapping("/testConfig2")
    public CustomerConfigParams configTest2(){
        return customerConfigParams;
    }
}
