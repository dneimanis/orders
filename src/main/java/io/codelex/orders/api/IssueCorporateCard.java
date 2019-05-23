package io.codelex.orders.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class IssueCorporateCard {

    @NotEmpty
    private String idCard;
    
    @NotEmpty
    private String extractFromRegister;

    @JsonCreator
    public IssueCorporateCard(@JsonProperty("idCard") String idCard,
                              @JsonProperty("extractFromRegister") String extractFromRegister) {
        this.idCard = idCard;
        this.extractFromRegister = extractFromRegister;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getExtractFromRegister() {
        return extractFromRegister;
    }
}
