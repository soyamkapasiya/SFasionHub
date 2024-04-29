package com.kapasiya.SFasionHub.datatransferobject;

public class PurchaseDTO {
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String zipCode;
    private String phone;
    private String accountEmail;
    private String formEmail;
    private String additional;
    private String time;
    private String date;
    private double amount;
    private String productId;


    public PurchaseDTO(String firstName, String lastName, String address1, String address2, String zipCode, String phone, String formEmail, String accountEmail, String additional, String time, String date, double amount, String productId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
        this.phone = phone;
        this.formEmail = formEmail;
        this.accountEmail = accountEmail;
        this.additional = additional;
        this.time = time;
        this.date = date;
        this.amount = amount;
        this.productId = productId;
    }

    public PurchaseDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getFormEmail() {
        return formEmail;
    }

    public void setFormEmail(String formEmail) {
        this.formEmail = formEmail;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}