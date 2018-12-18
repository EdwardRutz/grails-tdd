package com.grailstdd

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CustomerSpec extends Specification implements DomainUnitTest<Customer> {

    void "Customer has properties customerName and email"() {
        when: "A customer is created with the given customerName and email"
        String customerName = 'Test Customer'
        String email  = 'test@customer.com'
        Customer customer = new Customer(customerName:customerName, email:email)

        then: "customerName and email are set to the customer"
        customer.customerName == customerName
        customer.email == email
    }

    void "customerName should allow letters and spaces only"() {
        expect: "Customer instance is valid/invalid"
            new Customer(customerName:validCustomerName, email:"valid@mail.com").validate()
            !new Customer(customerName:invalidCustomerName, email:"valid@mail.com").validate()

        where: "Given valid/invalid customerNames"
            validCustomerName << ["customer", "  customer  ", "customer name"]
            invalidCustomerName << ["123customer456", "customer-test", "customer@email.com"]
    }

    void "The customerName should be unique"() {
        when: "The first customer is saved"
            String firstName = 'Unique Name'
            String firstEmail = 'test@customer.com'
            Customer firstCustomer = new Customer(customerName: firstName, email: firstEmail)
            firstCustomer.save(flush:true)

            String secondEmail = 'second@customer.com'
            Customer customerWithSameCustomerName =
                new Customer(customerName: firstName, email: secondEmail)

        then: "Another customer with the same customerName is invalid"
            Customer.count() == 1
            !customerWithSameCustomerName.validate()
    }

    void "Email should have proper format"() {
        expect: "Customer instance is valid/invalid"
        new Customer(customerName:"customer", email:validEmail).validate()
        !new Customer(customerName:"customer", email:invalidEmail).validate()

        where: "Given valid/invalid emails"
        validEmail << ["customer@email.com", "1234567890@example.com", "email@test.museum"]
        invalidEmail << ["plainaddress", "@example.com", "#@%^%x!.com"]
    }

}
