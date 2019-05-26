package io.codelex.orders;

import io.codelex.orders.api.AddCorporateCustomer;
import io.codelex.orders.api.InquireCorporateCustomer;
import io.codelex.orders.api.IssueCorporateCard;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static io.codelex.orders.ValidationResult.VALID;

@Component
class CorporateCustomerService {

    private final CorporateCustomerRepository corporateCustomerRepository;
    private DocumentValidationService documentValidationService = new DocumentValidationService();

    CorporateCustomerService(CorporateCustomerRepository corporateCustomerRepository) {
        this.corporateCustomerRepository = corporateCustomerRepository;
    }

    void register(String id, AddCorporateCustomer addCorporateCustomer) {

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(id);
        corporateCustomer.setIdCard(addCorporateCustomer.getIdCard());
        corporateCustomer.setExtractFromRegister(addCorporateCustomer.getExtractFromRegister());
        corporateCustomer.setPlaceOfRegistration(addCorporateCustomer.getPlaceOfRegistration());
        corporateCustomer.setTrustworthiness("Not trustworthy");

        ValidationResult validateExtract = documentValidationService.validateExtractFromRegister(addCorporateCustomer.getExtractFromRegister());

        if (corporateCustomer.getTrustworthiness().equals("Not trustworthy") && validateExtract == VALID) {
            corporateCustomerRepository.save(corporateCustomer);
            System.out.println("Corporate client registered");
        } else if (corporateCustomer.getTrustworthiness().equals("Trustworthy")) {
            corporateCustomerRepository.save(corporateCustomer);
            System.out.println("Corporate client registered");
        } else {
            System.out.println("Document not valid");
        }
    }

    void issueCard(String id, IssueCorporateCard issueCorporateCard) {

        CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(id);

        ValidationResult validateId = documentValidationService.validateIdCard(issueCorporateCard.getIdCard());
        ValidationResult validateExtract = documentValidationService.validateExtractFromRegister(issueCorporateCard.getExtractFromRegister());

        if (corporateCustomer.getTrustworthiness().equals("Not trustworthy") && validateId == VALID && validateExtract == VALID) {
            corporateCustomer.setIsCardIssued(LocalDate.now().toString());
            System.out.println("Corporate customer card issued");
        } else if(corporateCustomer.getTrustworthiness().equals("Trustworthy")){
            corporateCustomer.setIsCardIssued(LocalDate.now().toString());
            System.out.println("Corporate customer card issued");
        } else {
            System.out.println("Documents not valid");
        }
    }

    void inquire(String id, InquireCorporateCustomer inquireCorporateCustomer) {

        ValidationResult validateExtract = documentValidationService.validateExtractFromRegister(inquireCorporateCustomer.getExtractFromRegister());
        ValidationResult validatePlace = documentValidationService.validatePlaceOfRegistration(inquireCorporateCustomer.getPlaceOfRegistration());

        if (validateExtract == VALID && validatePlace == VALID) {
            System.out.println("Info on customer");
        } else {
            System.out.println("Documents not valid");
        }
    }
}
