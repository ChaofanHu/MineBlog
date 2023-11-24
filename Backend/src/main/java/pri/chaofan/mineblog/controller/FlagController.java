package pri.chaofan.mineblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.chaofan.mineblog.pojo.Flag;
import pri.chaofan.mineblog.service.FlagService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class FlagController {

    @Autowired
    private FlagService flagService;

    @GetMapping("/getAllFlags")
    public List<Flag> getAllFlags(){
        List<Flag> flags = flagService.selectAll();
        return flags;
    }
}
