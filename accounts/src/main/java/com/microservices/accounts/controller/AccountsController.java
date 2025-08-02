package com.microservices.accounts.controller;


import com.microservices.accounts.dto.AccountsContactInfoDto;
import com.microservices.accounts.gateway.LoanGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountsController {

    @Value("${build.version}")
    private String buildVersion;

    private final Environment environment;

    private final LoanGateway loanGateway;;

    private final AccountsContactInfoDto accountsContactInfoDto;


    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(buildVersion);
    }

    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }


    @GetMapping("/contact-info")
    public ResponseEntity<AccountsContactInfoDto> getContactInfo() {
        System.out.println("Hello World");

        System.out.println(accountsContactInfoDto.toString());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountsContactInfoDto);
    }


    @GetMapping("/loan-info")
    public ResponseEntity<String> getLoanInfo() {
        System.out.println("call for loan info");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanGateway.getLoanContactInfo());
    }

}
