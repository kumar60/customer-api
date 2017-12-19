package in.javahome.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.javahome.customer.service.CustomerService;

@SpringBootApplication
@RestController
public class Application {
	

    @RequestMapping("/")
    public String home() {
        return "<h1>Welcome to customer App</h1>";
    }
    @RequestMapping(path="customer/{id}",method=RequestMethod.GET)
    public String customer(@PathVariable("id") int custId) {
    		StringBuffer data = new StringBuffer();
    		data.append("<h3> Customer </h3>")
    		.append("Customer Id "+CustomerService.getCustomer(custId))
    		.append("\n <h3> Orders </h3>")
    		.append(OrdersClientAPI.callOrderApi(custId));
        return data.toString();
    }
    

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
