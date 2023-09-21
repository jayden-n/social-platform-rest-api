package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    // VERSIONING: URI VERSIONING (Twitter uses this)
    @GetMapping("/v1/person")
    public PersonV1 getFirstPersonOfPerson() {
        return new PersonV1("Jayden Nguyen");
    }
    @GetMapping("/v2/person")
    public PersonV2 getSecondPersonOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // VERSIONING: GETTING PARAMS person?version=1 (Amazon uses this)
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstPersonOfPersonRequestParameter() {
        return new PersonV1("Bob Chars");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondPersonOfPersonRequestParameter() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }


    // VERSIONING: CUSTOM HEADERS (Microsoft uses this)
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstPersonOfPersonRequestHeader() {
        return new PersonV1("Bob Chars");
    }
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondPersonOfPersonRequestHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

}
