package io.codelex.orders.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class InquireCorporateCustomer {
    
    @NotEmpty
    private String extractFromRegister;
    
    @NotEmpty 
    private String placeOfRegistration;

    @JsonCreator
    public InquireCorporateCustomer(@JsonProperty("extractFromRegister") String extractFromRegister, 
                                    @JsonProperty("placeOfRegistration") String placeOfRegistration) {
        this.extractFromRegister = extractFromRegister;
        this.placeOfRegistration = placeOfRegistration;
    }

    public String getExtractFromRegister() {
        return extractFromRegister;
    }

    public String getPlaceOfRegistration() {
        return placeOfRegistration;
    }
}
