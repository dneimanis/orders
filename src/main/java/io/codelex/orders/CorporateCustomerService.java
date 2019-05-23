package io.codelex.orders;

import io.codelex.orders.api.AddCorporateCustomer;
import io.codelex.orders.api.IssueCorporateCard;
import org.springframework.stereotype.Component;

@Component
class CorporateCustomerService {
    
    private final CorporateCustomerRepository corporateCustomerRepository;
    

    CorporateCustomerService(CorporateCustomerRepository corporateCustomerRepository) {
        this.corporateCustomerRepository = corporateCustomerRepository;
    }

    void register(String id, AddCorporateCustomer addCorporateCustomer) {
        
        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(id);
        corporateCustomer.setIdCard(addCorporateCustomer.getIdCard());
        corporateCustomer.setExtractFromRegister(addCorporateCustomer.getExtractFromRegister());
        
        corporateCustomerRepository.save(corporateCustomer);
        
        System.out.println(addCorporateCustomer.getExtractFromRegister());
    }

    void issueCard(String id, IssueCorporateCard issueCorporateCard) {
        DocumentValidationService documentValidationService = new DocumentValidationService();
        documentValidationService.validateIdCard(issueCorporateCard.getIdCard());
        documentValidationService.validateExtractFromRegister(issueCorporateCard.getExtractFromRegister());
    }

    void inquire(String id) {
        System.out.println(id);
    }
}
