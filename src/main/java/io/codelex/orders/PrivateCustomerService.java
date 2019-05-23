package io.codelex.orders;

import io.codelex.orders.api.AddPrivateCustomer;
import io.codelex.orders.api.IssuePrivateCard;
import org.springframework.stereotype.Component;

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
        
        System.out.println(addPrivateCustomer.getIdCard());
    }

    void issueCard(String id, IssuePrivateCard issuePrivateCard) {
        DocumentValidationService documentValidationService = new DocumentValidationService();
        documentValidationService.validateIdCard(issuePrivateCard.getIdCard());
    }

    void inqiure(String id) {
        System.out.println(id);
    }
}
