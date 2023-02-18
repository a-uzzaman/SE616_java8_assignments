package se616;
//Name:- Ashif Uzzaman Email- au66159n@pace.edu

import org.junit.jupiter.api.*;

import java.util.Random;

public class MathExampleTest {

    static MathExamples me;

    @BeforeAll
    public static void setupReference(){
        me = new MathExamples();
    }
    //Creating static variables to be used throughout the class
    static int input1;
    static int input2;

    //Before each method to create random numbers before each test is run
    @BeforeEach
    public void createRandomValues(){
        //Create 2 variables that range from -1000 to 1000 for the inputs
        input1= -1000 + new Random().nextInt(2001);
        input2= -1000 + new Random().nextInt(2001);

        System.out.println("Two inputs created Input1 is "+input1+" Input2 is "+input2);
    }

    //After each method will execute after each test
    @AfterEach
    public void createBreakLine(){
        System.out.println("==========================================================");
    }

    //Test annotation is used to define methods that are tests
    //Display name annotation is used to show name for the test result
    @Test
    @DisplayName("Test defualt result is zero")
    public void testZeroResult(){
        //Calling on the component that needs to be tested and store the result in a variable
        int sum = me.findSum(0,0);
        //Using JUnit5 Assertions to assert result
        Assertions.assertEquals(0,sum);
        Assertions.assertNotEquals(100,sum,"The sum is giving unexpected values" );
        System.out.println("The test has passed. The output of the component is "+sum);

    }


    //Test annotation is used to define methods that are tests
    //Repeated Test will run the test multiple iteration
    //Display name annotation is used to show name for the test result
    @RepeatedTest(value= 200 ,name= "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Test multiple iteration inputs")
    public void testInputsVSOutputs(){
        //Calling on the component that needs to be tested and store the result in a variable
        int sum = me.findSum(input1,input2);
        //Assert returned value is positive or negative
        if((input1>0 && input2<0 && input1>(-input2))||(input1<0 && input2>0 && (-input1)<input2)||(input1>=0 && input2>=0)){
            Assertions.assertTrue(sum > 0,"Expected output not to be <0 but the sum is "+sum);
        } else{
            Assertions.assertFalse(sum > 0,"Expected output not to be >0 but the sum is "+sum);
        }

        //Assert correct return is made
        Assertions.assertEquals((input1+input2),sum,"Calculation does not match");

        System.out.println("The test has passed. The output of the component is "+sum);


    }


}
