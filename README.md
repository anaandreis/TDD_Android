# ANDROID TEST STUDY

## THEORY

### Types of Android Tests

Unit Tests

1.Build for testing single classes and functionalities. 
(Example: testing a sum function and checking if it handles different numbers well)


2.Integration Tests

Checking if two components interact correctly. (Example: Fragment and Viewmodel)
Attention: if the components necessary for the test require Android Resources and Components only, it 
is a integrated test and needs to be run on the emulator.


3.Ui Tests
Check if the components of your app work well together and if the UI looks the way it should



### How to write good tests?

Test Drive Development(TDD)

Development style that values testing
The main principle of TDD is that you write the test case before de implementation of the function(for unit
tests)
Steps of TDD:
1. Write the function signature
2. Write test cases for that function
3. Write the function logic

It is better to have only one assertion per test case, because we want to know immediately the cause of the failed test,
and to have a big test case would mean that you would need to analyse the test case.
So if the test is linked to the function signature, you immediately know where the problem is.


### What makes a good test?
1. Scope: how much of our code is covered by our test case
2. Speed: how fast does it run. It also makes the development faster and more efficient
3. Fidelity: how similar the test case is to the real world scenario

Avoid flaky tests(sometimes succeds and sometimes fails) 
NEVER make one test outcome dependent on the outcome of another test

### How many cases should you write?
Equivalent classes are useful to determine the amount of tests a function should have.
For example, you have a registration form. To be able to register, all the inputs are necessary, so
all the inputs on the form would make one equivalent class. Another eq

uivalent classwould be enter only the 
password without the username, and another one would be to register a name that already exists.


## ON ANDROID STUDIO

dependencies:

    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    testImplementation "com.google.truth:truth:1.0.1" // easier to read assertions
    androidTestImplementation "com.google.truth:truth:1.0.1"

### What is the difference between testimplementation and androidTestImplementation? 
They reference the different source sets in the java root folder.
The integrated tests belong in the androidTest directory.
All the others that don't rely on the emulator and android components com in the Test directory.

### 1. First Case: User Input

You create the function to validate the registration Input inside a object and already antecipate 
the test cases.
Select that object and Generate the Test.
Once generated, a test class is created in the selected directory of Tests.
Inside that class, you can write the test functions that will check the function with the @Test
annotation.

Assertion function (assertThat()): you can pull it from the junit library and from the google truth library that we added.

### 2. Second Case: Using Android components such as context and AndroidTest folder
(Android Components Branch)

You can use both singleton objects or classes to craft your test, but the problem with the class is that it needs to be instatiated and needs a context.
When instantiating, be careful not to link all the tests to the same instatiation, because that would mean that they are not independent anymore and produces
flaky tests.
Although we could declare a lateinit var and instantiate inside each class, that would be a lot of boiler plate code so JUnit has a solution: fun setup(), that 
defines the logic of execution before the test cases.
You instantiate the class in the set up function and annotate it with @Before. 

@Before
fun setup() {
	resourceComparer = ResourceComparer()	
}

There is also an @After annotation, used normally to destroy objects created before or closing the database or dealing with viewModel
  
Using the braces do not work in this case like the naming convention for functions in the Test directory. But it is important to describe the goal of the 
function in a clear way. Example: stringResourceSameAsGivenString_returnsTrue()
Needs emulator to run the test.
