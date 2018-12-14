package com.grailstdd

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CustomerSpec extends Specification implements DomainUnitTest<Customer> {

    void "Test that Customer has properties customerName and email"() {
        when: "A customer is created with the given customerName and email"
        String customerName = 'Test Customer'
        String email  = 'test@customer.com'
        Customer customer = new Customer(customerName:customerName, email:email)

        then: "customerName and email are set to the customer"
        customer.customerName == customerName
        customer.email == email
    }
}
