package pl.dmcs.iwalecture.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class HelloController {
    @RequestMapping("/")
    public String hello() { return "hello"; }
}
