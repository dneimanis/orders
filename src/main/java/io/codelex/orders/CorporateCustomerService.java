package io.codelex.orders;

import io.codelex.orders.api.AddCorporateCustomer;
import io.codelex.orders.api.InquireCorporateCustomer;
import io.codelex.orders.api.IssueCorporateCard;
import org.springframework.stereotype.Component;

import static io.codelex.orders.ValidationResult.VALID;

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
        
        System.out.println("Corporate client registered");
    }

    void issueCard(String id, IssueCorporateCard issueCorporateCard) {
        
        DocumentValidationService documentValidationService = new DocumentValidationService();
        
        ValidationResult validateId = documentValidationService.validateIdCard(issueCorporateCard.getIdCard());
        ValidationResult validateExtract = documentValidationService.validateExtractFromRegister(issueCorporateCard.getExtractFromRegister());

        if(validateId == VALID && validateExtract == VALID) {
            System.out.println("Corporate customer card issued");
        } else {
            System.out.println("Documents not valid");
        }
    }

    void inquire(String id, InquireCorporateCustomer inquireCorporateCustomer) {
        
        DocumentValidationService documentValidationService = new DocumentValidationService();
        
        ValidationResult validateExtract = documentValidationService.validateExtractFromRegister(inquireCorporateCustomer.getExtractFromRegister());
        ValidationResult validatePlace = documentValidationService.validatePlaceOfRegistration(inquireCorporateCustomer.getPlaceOfRegistration());
        
        if(validateExtract == VALID && validatePlace == VALID) {
            System.out.println("Info on customer");
        } else {
            System.out.println("Documents not valid");
        }
    }
}
