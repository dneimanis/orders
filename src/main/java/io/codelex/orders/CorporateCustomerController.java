package io.codelex.orders;

import io.codelex.orders.api.AddCorporateCustomer;
import io.codelex.orders.api.InquireCorporateCustomer;
import io.codelex.orders.api.IssueCorporateCard;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/corporate-customer/{id}")
@RestController
public class CorporateCustomerController {
    
    private final CorporateCustomerService service;

    public CorporateCustomerController(CorporateCustomerService service) {
        this.service = service;
    }

    @PostMapping("/register")
    void register(@PathVariable String id, @Valid @RequestBody AddCorporateCustomer addCorporateCustomer) {
        service.register(id, addCorporateCustomer);
    }

    @PostMapping("/issue-card")
    void issueCard(@PathVariable String id, @Valid @RequestBody IssueCorporateCard issueCorporateCard) {
        service.issueCard(id, issueCorporateCard);
    }

    @GetMapping
    void inqiure(@PathVariable String id, @Valid @RequestBody InquireCorporateCustomer inquireCorporateCustomer) {
        service.inquire(id, inquireCorporateCustomer);
    }
}