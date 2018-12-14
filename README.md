# Using Grails and Test Drive Development
    
>A basic demo creating an app via TDD


## Dependencies

- Grails 3.3.8
- Testing with Spock

## Setup

- To test, in the grails console run `test-app`
- Test results report, `test-report`
- View test report, `open test-report`

## Notes

- Create an App, `grails create-app grails-tdd`
- Create a Class, `create-domain-class com.grailstdd.Customer`
- IntelliJ Grails Command Window, `Ctrl+Alt+G`
- Grails 3.3.x no longer uses @Test from the Grails Test Mixin Framework [See docs](https://docs.grails.org/latest/guide/testing.html) 
- For tests Grails uses traits processed in the test class at compile time.
- The `when:` block describes what is to happen
- The `then:` block describes the expected response to `when:`
    - Conditions in the `then:` define the expected state and are similar to JUnit assertions
    - Conditions are written as plain boolean expressions

## Sources

- [ideyatech: Starting Grails with Test-Driven Development](https://www.ideyatech.com/starting-grails-with-test-driven-development/)
- [Docs: Grails Testing Support](https://testing.grails.org/latest/guide/index.html)
- [Grails Docs](http://grails.github.io/grails-doc/3.0.x/guide/single.html)
- [Google: Spock Basics](https://code.google.com/archive/p/spock/wikis/SpockBasics.wiki)
- [Grails Docs: Validate Method](https://docs.grails.org/latest/ref/Domain%20Classes/validate.html)
- [Grails Docs: Validation](https://docs.grails.org/latest/guide/validation.html)


