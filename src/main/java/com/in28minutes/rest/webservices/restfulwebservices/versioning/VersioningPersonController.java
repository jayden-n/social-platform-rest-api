package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstPersonOfPerson() {
        return new PersonV1("Jayden Nguyen");
    }
    @GetMapping("/v2/person")
    public PersonV2 getSecondPersonOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
