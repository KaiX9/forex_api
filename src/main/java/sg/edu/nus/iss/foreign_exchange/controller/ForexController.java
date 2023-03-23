package sg.edu.nus.iss.foreign_exchange.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.foreign_exchange.model.Forex;
import sg.edu.nus.iss.foreign_exchange.service.ForexService;

@Controller
@RequestMapping
public class ForexController {
    
    @Autowired
    private ForexService forexSvc;

    @GetMapping(path="{baseCode}")
    public String getRates(@PathVariable(required=true) String baseCode, Model m) throws IOException {
        Optional<Forex> forex = forexSvc.getRates(baseCode);
        m.addAttribute("forex", forex.get());
        return "forex";
    }
}
