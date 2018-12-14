package com.grailstdd

class Customer {
    String customerName
    String email
    static constraints = {
        customerName matches: "^[a-zA-Z ]+\$"
    }
}
