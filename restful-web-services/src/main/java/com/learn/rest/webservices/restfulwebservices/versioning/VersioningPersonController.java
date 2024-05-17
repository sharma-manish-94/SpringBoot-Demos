package com.learn.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Manish Sharma");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Manish", "Sharma"));

    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRP(){
        return new PersonV1("Manish Sharma");
    }
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRP() {
        return new PersonV2(new Name("Manish", "Sharma"));

    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRH(){
        return new PersonV1("Manish Sharma");
    }
    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRH() {
        return new PersonV2(new Name("Manish", "Sharma"));

    }

    @GetMapping(path = "/person", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonCT(){
        return new PersonV1("Manish Sharma");
    }
    @GetMapping(path = "/person", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonCT() {
        return new PersonV2(new Name("Manish", "Sharma"));

    }



}
