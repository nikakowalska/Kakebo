package com.auth.authserviceforKakebo.controller;

import com.auth.authserviceforKakebo.dto.EmailDto;
import com.auth.authserviceforKakebo.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authentication")
@AllArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @GetMapping("/validate/{token}")
    public boolean getValidate(@PathVariable String token) {
        return authenticationService.isTokenValid(token);
    }

    @GetMapping(value = "/name/{token}")
    public EmailDto getEmailFromToken(@PathVariable String token) {
        return authenticationService.getEmailFromToken(token);
    }
@RequestBody

//userdto w jsonie

    @PostMapping("{email}/{password}")
    public boolean postUser(

            @PathVariable EmailDto email,
            @PathVariable String password
    ) {
        return authenticationService.createUser(email, password);
    }


//    @RequestMapping(value = "s1", method = RequestMethod.GET)
//    public String getString1() {
//        return "s1";
//    }
//
//
//    @GetMapping("s2")
//    public String getString2() {
//        return "s2";
//    }
//
//    @GetMapping("requestparam")
//    public String getStringPathParam(
//            @RequestParam("pies") String pies,
//            @RequestParam(value = "kotki", required = false) List<String> kotki //rozdziela sie do tablicy poniewaz jest lista,
//    ) {
//        return "URI requestparam?pies=" + pies + "&kotki=" + kotki;
//    }
//
//    @GetMapping("requestparam/map")
//    public String getStringPathParamMap(
//            @RequestParam Map<String, String> paramMap
//    ) {
//        return "URI requestparam/map?" + paramMap;
//    }
//
//    @GetMapping("requestheader")
//    public String getStringH(
//            @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
//            @RequestHeader("MyHeader") String myHeader
//    ) {
//        return testService.getHeaderRequest(language, myHeader);
//    }
//
//    @GetMapping("String")
//    public String getString() {
//        return testService.getString();
//    }
//
//    @PostMapping("sendbody")
//    public void getBodyFromJson(
//          //  @Valid
//            @RequestBody TestDto testDto
//    ) {
//        System.out.println("Body from FE: " + testDto.getName() + ", age: " + testDto.getAge());
//    }
//
//    @PostMapping("sendbody/array")
//    public void getBodyFromJson(
//            @RequestBody List<TestDto> testDtos
//    ) {
//        System.out.println(testDtos);
//        System.out.println("Body array from FE: " + testDtos.get(0).getName() + ", age: " + testDtos.get(0).getAge());
//
//    }
//    @GetMapping("read")
//    public void getRead() {
//        testService.readTestEntity();
//    }
//
//    @GetMapping("save")
//    public void getSave() {
//        testService.saveTestEntity();
//    }
}
