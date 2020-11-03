package org.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlotController {

    private static int index = -1;

    private List<Integer> yList = new ArrayList<Integer>() {{
        add(800);
        add(400);
        add(200);
        add(100);
        add(50);
        add(25);
        add(12);
        add(6);
        add(3);
        add(1);
    }};

    private List<Integer> xList = new ArrayList<Integer>() {{
        add(100);
        add(200);
        add(300);
        add(400);
        add(500);
        add(600);
        add(700);
        add(800);
        add(900);
        add(1000);
    }};

    @RequestMapping("/plot")
    public String getPage() {
        return "plot";
    }

    @ResponseBody
    @GetMapping("/plotting")
    public Plots plotting() {
        index++;
        return new Plots() {{
            setXAxis(xList.subList(index, index + 5));
            setYAxis(yList.subList(index, index + 5));
        }};
    }
}
