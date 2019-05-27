package io.codelex.orders;

import io.codelex.orders.api.AddPrivateCustomer;
import io.codelex.orders.api.InquirePrivateCustomer;
import io.codelex.orders.api.IssuePrivateCard;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    List<PrivateCustomer> inqiure(@Valid @RequestBody InquirePrivateCustomer inquirePrivateCustomer) {
        return service.inquire(inquirePrivateCustomer);
    }
}