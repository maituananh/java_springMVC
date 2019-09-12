package com.teambuild.clothershop.model;

import javax.persistence.*;

@Entity(name = "verification")
public class Verification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVerificationCodes;
    private String codes;

    public int getIdVerificationCodes() {
        return idVerificationCodes;
    }

    public void setIdVerificationCodes(int idVerificationCodes) {
        this.idVerificationCodes = idVerificationCodes;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }
}
