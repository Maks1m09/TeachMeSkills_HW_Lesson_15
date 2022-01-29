package com.teachmeskills.homework_15;

import java.util.List;

public class Document {
    private List<String> numberOfDocument;
    private String numberTel;
    private String email;

    public Document() {
    }

    public List<String> getNumberOfDocument() {
        return numberOfDocument;
    }

    public void setNumberOfDocument(List<String> numberOfDocument) {
        this.numberOfDocument = numberOfDocument;
    }

    public String getNumberTel() {
        return numberTel;
    }

    public void setNumberTel(String numberTel) {
        this.numberTel = numberTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Document{" +
                "numberOfDocument=" + numberOfDocument +
                ", numberTel='" + numberTel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
