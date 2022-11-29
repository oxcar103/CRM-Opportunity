package org.opportunity.controller;

import org.opportunity.entity.Action;
import org.opportunity.entity.VIA;
import org.opportunity.services.Service;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/")
public class Controller {
    @GetMapping("index")
    public String getIndex() {
        if (!Service.isInactive()) {
            return "Hi!";
        }
        else{
            return Service.content;
        }
    }
    @PostMapping("Contacts")
    public List<Action> getActions(@RequestBody String body) throws Exception {
        LocalDate date = LocalDate.now();
        return List.of(
                new Action("Alice", VIA.EMAIL, date),
                new Action("Bob", VIA.PHONE, date),
                new Action("Carol", VIA.VISIT, date)
        );
    }

    @PostMapping("test")
    public void test(@RequestBody Map<String, Object> body) {
        System.out.println(body);
    }

}
