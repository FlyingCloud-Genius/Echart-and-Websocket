package org.example.demo.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String getPage() {
        return "upload";
    }
}
