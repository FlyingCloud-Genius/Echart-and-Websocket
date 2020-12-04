package org.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
public class PlotController {

    private static int index = -1;

    private Random random = new Random();

    private List<Integer> yList = new ArrayList<Integer>() {{
        for (int i = 100000; i > 0; i--) {
            add(random.nextInt(100000));
        }
    }};

    private List<Integer> xList = new ArrayList<Integer>() {{
        for (int i = 0; i < 100000; i++) {
            add(random.nextInt(100000));
        }
    }};

    @RequestMapping("/plot")
    public String getPage() {
        return "plot";
    }

    @ResponseBody
    @GetMapping("/plotting")
    public Plots plotting() {
        index++;
        log.info("plotting {} time...", index);
        return new Plots() {{
            setXAxis(xList.subList(index, index + 1500));
            setYAxis(yList.subList(index, index + 1500));
        }};
    }
}
