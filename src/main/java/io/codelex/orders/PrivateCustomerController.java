package io.codelex.orders;

import io.codelex.orders.api.AddPrivateCustomer;
import io.codelex.orders.api.IssuePrivateCard;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/private-customers/{id}")
@RestController
public class PrivateCustomerController {
    
    private final PrivateCustomerService service;

    public PrivateCustomerController(PrivateCustomerService service) {
        this.service = service;
    }


    @PostMapping("/register")
    void register(@PathVariable String id, @Valid @RequestBody AddPrivateCustomer addPrivateCustomer) {
        service.register(id, addPrivateCustomer);
    }

    @PostMapping("/issue-card")
    void issueCard(@PathVariable String id, @Valid @RequestBody IssuePrivateCard issuePrivateCard) {
        service.issueCard(id, issuePrivateCard);

    }

    @GetMapping
    void inqiure(@PathVariable String id) {
        service.inqiure(id);
    }
}