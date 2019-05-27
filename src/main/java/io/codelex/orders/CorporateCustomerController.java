package io.codelex.orders;

import io.codelex.orders.api.AddCorporateCustomer;
import io.codelex.orders.api.InquireCorporateCustomer;
import io.codelex.orders.api.IssueCorporateCard;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/corporate-customers/{id}")
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
    void issueCard(@PathVariable String id, @Valid @RequestBody IssueCorporateCard issueCorporateCard, CorporateCustomerRecord corporateCustomerRecord) {
        service.issueCard(id, issueCorporateCard);
    }

    @GetMapping
    List<CorporateCustomer> inqiure(@Valid @RequestBody InquireCorporateCustomer inquireCorporateCustomer) {
        return service.inquire(inquireCorporateCustomer);
    }
}