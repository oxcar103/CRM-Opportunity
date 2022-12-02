package org.opportunity.controller;

import org.opportunity.entity.Action;
import org.opportunity.entity.Contact;
import org.opportunity.entity.FutureAction;
import org.opportunity.entity.VIA;
import org.opportunity.services.Service;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("contacts")
    public List<Action> getActions(@RequestBody String body) throws Exception {
        LocalDate date = LocalDate.now();
        return List.of(
                new Contact("Alice", VIA.EMAIL, date, "Presentation"),
                new Contact("Bob", VIA.PHONE, date, "Sending Information"),
                new FutureAction("Carol", VIA.VISIT, date.plusDays(1))
        );
    }

    @PostMapping("test")
    public void test(@RequestBody Map<String, Object> body) {
        System.out.println(body);
    }

}
