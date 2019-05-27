package io.codelex.orders;

import io.codelex.orders.api.AddPrivateCustomer;
import io.codelex.orders.api.InquirePrivateCustomer;
import io.codelex.orders.api.IssuePrivateCard;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static io.codelex.orders.ValidationResult.VALID;

@Component
class PrivateCustomerService {

    private final PrivateCustomerRepository privateCustomerRepository;
    private final DocumentValidationService documentValidationService;

    PrivateCustomerService(PrivateCustomerRepository privateCustomerRepository, DocumentValidationService documentValidationService) {
        this.privateCustomerRepository = privateCustomerRepository;
        this.documentValidationService = documentValidationService;
    }

    void register(String id, AddPrivateCustomer addPrivateCustomer) {

        PrivateCustomerRecord privateCustomerRecord = new PrivateCustomerRecord();
        privateCustomerRecord.setId(id);
        privateCustomerRecord.setIdCard(addPrivateCustomer.getIdCard());
        privateCustomerRecord.setPlaceOfRegistration(addPrivateCustomer.getPlaceOfRegistration());
        privateCustomerRecord.setTrustworthiness("Not trustworthy");

        ValidationResult validateIdCard = documentValidationService.validateIdCard(addPrivateCustomer.getIdCard());
        ValidationResult validatePlace = documentValidationService.validatePlaceOfRegistration(addPrivateCustomer.getPlaceOfRegistration());

        if (privateCustomerRecord.getTrustworthiness().equals("Not trustworthy") && validateIdCard == VALID && validatePlace == VALID) {
            privateCustomerRepository.save(privateCustomerRecord);
            System.out.println("Private registered");
        } else if (privateCustomerRecord.getTrustworthiness().equals("Trustworthy")) {
            privateCustomerRepository.save(privateCustomerRecord);
            System.out.println("Private client registered");
        } else {
            System.out.println("Documents not valid");
        }
    }

    @Transactional
    void issueCard(String id, IssuePrivateCard issuePrivateCard) {
        
        PrivateCustomerRecord privateCustomerRecord = privateCustomerRepository.getOne(id);

        ValidationResult validateId = documentValidationService.validateIdCard(issuePrivateCard.getIdCard());

        if (privateCustomerRecord.getTrustworthiness().equals("Not trustworthy") && validateId == VALID) {
            privateCustomerRecord.setCardIssued(LocalDate.now());
            System.out.println("Private customer card issued");
        } else if(privateCustomerRecord.getTrustworthiness().equals("Trustworthy")){
            privateCustomerRecord.setCardIssued(LocalDate.now());
            System.out.println("Private customer card issued");
        } else {
            System.out.println("Document not valid");
        }
    }

    List<PrivateCustomer> inquire(InquirePrivateCustomer inquirePrivateCustomer) {
        
        ValidationResult validateId = documentValidationService.validateIdCard(inquirePrivateCustomer.getIdCard());
        ValidationResult validatePlace = documentValidationService.validatePlaceOfRegistration(inquirePrivateCustomer.getPlaceOfRegistration());

        if (validateId == VALID && validatePlace == VALID) {
            System.out.println("Information on private customer delivered");
            return privateCustomerRepository.findAll()
                    .stream()
                    .map(this::customer)
                    .collect(Collectors.toList());
        } else {
            System.out.println("Documents not valid");
        }
        return null;
    }

    private PrivateCustomer customer(PrivateCustomerRecord privateCustomerRecord) {
        return new PrivateCustomer(
                privateCustomerRecord.getId(),
                privateCustomerRecord.getIdCard(),
                privateCustomerRecord.getPlaceOfRegistration(),
                privateCustomerRecord.getTrustworthiness(),
                privateCustomerRecord.getCardIssued());
    }
}
