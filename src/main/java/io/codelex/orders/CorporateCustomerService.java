package io.codelex.orders;

import io.codelex.orders.api.AddCorporateCustomer;
import io.codelex.orders.api.InquireCorporateCustomer;
import io.codelex.orders.api.IssueCorporateCard;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static io.codelex.orders.ValidationResult.VALID;

@Component
class CorporateCustomerService {

    private final CorporateCustomerRepository corporateCustomerRepository;
    private final DocumentValidationService documentValidationService;

    CorporateCustomerService(CorporateCustomerRepository corporateCustomerRepository, DocumentValidationService documentValidationService) {
        this.corporateCustomerRepository = corporateCustomerRepository;
        this.documentValidationService = documentValidationService;
    }

    void register(String id, AddCorporateCustomer addCorporateCustomer) {

        CorporateCustomerRecord corporateCustomerRecord = new CorporateCustomerRecord();
        corporateCustomerRecord.setId(id);
        corporateCustomerRecord.setIdCard(addCorporateCustomer.getIdCard());
        corporateCustomerRecord.setExtractFromRegister(addCorporateCustomer.getExtractFromRegister());
        corporateCustomerRecord.setPlaceOfRegistration(addCorporateCustomer.getPlaceOfRegistration());
        corporateCustomerRecord.setTrustworthiness("Not trustworthy");

        ValidationResult validateExtract = documentValidationService.validateExtractFromRegister(addCorporateCustomer.getExtractFromRegister());

        if (corporateCustomerRecord.getTrustworthiness().equals("Not trustworthy") && validateExtract == VALID) {
            corporateCustomerRepository.save(corporateCustomerRecord);
            System.out.println("Corporate client registered");
        } else if (corporateCustomerRecord.getTrustworthiness().equals("Trustworthy")) {
            corporateCustomerRepository.save(corporateCustomerRecord);
            System.out.println("Corporate client registered");
        } else {
            System.out.println("Document not valid");
        }
    }

    @Transactional
    public void issueCard(String id, IssueCorporateCard issueCorporateCard) {

        CorporateCustomerRecord corporateCustomerRecord = corporateCustomerRepository.getOne(id);

        ValidationResult validateId = documentValidationService.validateIdCard(issueCorporateCard.getIdCard());
        ValidationResult validateExtract = documentValidationService.validateExtractFromRegister(issueCorporateCard.getExtractFromRegister());

        if (corporateCustomerRecord.getTrustworthiness().equals("Not trustworthy") && validateId == VALID && validateExtract == VALID) {
            corporateCustomerRecord.setCardIssued(LocalDate.now());
            System.out.println("Corporate customer card issued");
        } else if(corporateCustomerRecord.getTrustworthiness().equals("Trustworthy")){
            corporateCustomerRecord.setCardIssued(LocalDate.now());
            System.out.println("Corporate customer card issued");
        } else {
            System.out.println("Documents not valid");
        }
    }

    List<CorporateCustomer> inquire(InquireCorporateCustomer inquireCorporateCustomer) {

        ValidationResult validateExtract = documentValidationService.validateExtractFromRegister(inquireCorporateCustomer.getExtractFromRegister());
        ValidationResult validatePlace = documentValidationService.validatePlaceOfRegistration(inquireCorporateCustomer.getPlaceOfRegistration());

        if (validateExtract == VALID && validatePlace == VALID) {
            System.out.println("Information on corporate customer delivered");
            return corporateCustomerRepository.findAll()
                    .stream()
                    .map(this::customer)
                    .collect(Collectors.toList());
        } else {
            System.out.println("Documents not valid");
        }
        return null;
    }
    
    private CorporateCustomer customer(CorporateCustomerRecord corporateCustomerRecord) {
        return new CorporateCustomer(
                corporateCustomerRecord.getId(),
                corporateCustomerRecord.getIdCard(),
                corporateCustomerRecord.getExtractFromRegister(),
                corporateCustomerRecord.getPlaceOfRegistration(),
                corporateCustomerRecord.getTrustworthiness(),
                corporateCustomerRecord.getCardIssued());
    }
}
