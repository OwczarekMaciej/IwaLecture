package pl.dmcs.iwalecture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.iwalecture.model.Fibonacci;

@Controller
class FibonacciController {
    @RequestMapping("/fibonacci")
    public String Fibonacci(Model model){
        model.addAttribute("message", "Calculate nth fibonacci number");
        Fibonacci newFibonacci = new Fibonacci();
        model.addAttribute("fibonacci", newFibonacci);
        return "fibonacci";
    }

    @RequestMapping(value = "/calcNumber.html", method = RequestMethod.POST)
    public String calcNumber(@ModelAttribute("fibonacci") Fibonacci fibonacci)
    {
        System.out.println(fibonacci.getNumber());
        return "redirect:fibonacci";
    }
}
