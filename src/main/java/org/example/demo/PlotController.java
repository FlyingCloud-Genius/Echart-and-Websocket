package org.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlotController {

    @ResponseBody
    @GetMapping("/plotting")
    public Plots plotting() {

    }
}
