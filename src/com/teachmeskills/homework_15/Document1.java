package com.teachmeskills.homework_15;

public class Document1 {
    private String numberOfDocument;
    private String numberTel;
    private String email;

    public Document1() {
    }


    public String getNumberOfDocument() {
        return numberOfDocument;
    }

    public void setNumberOfDocument(String numberOfDocument) {
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
        return "Document1{" +
                "numberOfDocument='" + numberOfDocument + '\'' +
                ", numberTel='" + numberTel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
