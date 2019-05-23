package io.codelex.orders;

import io.codelex.orders.api.AddPrivateCustomer;
import io.codelex.orders.api.InquirePrivateCustomer;
import io.codelex.orders.api.IssuePrivateCard;
import org.springframework.stereotype.Component;

import static io.codelex.orders.ValidationResult.VALID;

@Component
class PrivateCustomerService {
    
    private final PrivateCustomerRepository privateCustomerRepository;

    PrivateCustomerService(PrivateCustomerRepository privateCustomerRepository) {
        this.privateCustomerRepository = privateCustomerRepository;
    }

    void register(String id, AddPrivateCustomer addPrivateCustomer) {

        PrivateCustomer privateCustomer = new PrivateCustomer();
        privateCustomer.setId(id);
        privateCustomer.setIdCard(addPrivateCustomer.getIdCard());
        privateCustomer.setPlaceOfRegistration(addPrivateCustomer.getPlaceOfRegistration());
        
        privateCustomerRepository.save(privateCustomer);
        
        System.out.println("Private customer registered");
    }

    void issueCard(String id, IssuePrivateCard issuePrivateCard) {
        
        DocumentValidationService documentValidationService = new DocumentValidationService();
        
        ValidationResult validateId = documentValidationService.validateIdCard(issuePrivateCard.getIdCard());
        
        if(validateId == VALID) {
            System.out.println("Private customer card issued");
        } else {
            System.out.println("Document not valid");
        }
    }

    void inquire(String id, InquirePrivateCustomer inquirePrivateCustomer) {
        
        DocumentValidationService documentValidationService = new DocumentValidationService();
        
        ValidationResult validateId = documentValidationService.validateIdCard(inquirePrivateCustomer.getIdCard());
        ValidationResult validatePlace = documentValidationService.validatePlaceOfRegistration(inquirePrivateCustomer.getPlaceOfRegistration());
        
        if(validateId == VALID && validatePlace == VALID) {
            System.out.println("Info on customer");
        } else {
            System.out.println("Documents not valid");
        }
    }
}
