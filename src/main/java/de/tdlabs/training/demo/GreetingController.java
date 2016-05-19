package de.tdlabs.training.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by tom on 19.05.16.
 *
 * <pre>
 *     curl -i -b cookies1 -c cookies1 'http://localhost:8080/greet?name=foo'
 * </pre>
 */
@RestController
class GreetingController {

    @RequestMapping(path = "/greet", method = GET)
    ResponseEntity<String> greet(@RequestParam(name="name",defaultValue = "world") String name, HttpSession session) {

        String greeting = "Hello " + name + " Previous request: " + session.getAttribute("name");

        session.setAttribute("name", name);

        return ResponseEntity.ok(greeting);
    }
}
