package org.example.demo.log;

import lombok.extern.slf4j.Slf4j;
import org.example.demo.domain.Man;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String getPage() {
        return "upload";
    }

    @RequestMapping("/entity")
    private Map upload(Man man) {
        man.getLove();
        return new HashMap() {{
            put("code", 0);
        }};
    }
}
