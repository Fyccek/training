package training.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import training.backend.CustomerService;

@Controller
public class HttpController {
	
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World!";
    }
    
    private CustomerService customerService;

    public HttpController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ModelAndView listEmployees() {
        var customers = customerService.listCustomers();
        return new ModelAndView("customers-page", "customerList", customers);
    }

}
