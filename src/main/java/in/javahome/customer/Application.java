package in.javahome.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.javahome.customer.service.CustomerService;

@SpringBootApplication
@Controller
public class Application {

	@RequestMapping("/")
	public String home() {
		return "welcome.jsp";
	}

	@RequestMapping(path = "customer/{id}", method = RequestMethod.GET)
	public ModelAndView customer(@PathVariable("id") int custId, ModelMap map) {
		String hostName = System.getenv("HOSTNAME") == null ? "localhost" : System.getenv("HOSTNAME");
		map.put("hostName", hostName);
		map.put("customerName", CustomerService.getCustomer(custId));
		map.put("orderDetails", OrdersClientAPI.callOrderApi(custId));
		ModelAndView mv = new ModelAndView("welcome.jsp",map);
		return mv;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
