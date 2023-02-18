package se616;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringExampleTest {


    static StringExample se;

    @BeforeAll
    public static void setupReference(){
        se = new StringExample();
    }
    @Test
    public void testMatchName_withMatchingName() {
        // Test matching name
        assertTrue(se.matchName("somename"));
    }

    // Will test 20 times with random names
    @RepeatedTest(value= 20 ,name= "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Test multiple iteration inputs")
    public void testMatchName_withNonMatchingName() {
        //Using faker library to create random fake names
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        // Test non-matching name
        assertFalse(se.matchName(firstName));
    }

    @Test
    public void testMatchName_withNullName() {

        // Test null name
        assertFalse(se.matchName(null));
    }

    @Test
    public void testMatchName_withEmptyName() {
        // Test empty name
        assertFalse(se.matchName(""));
    }

    @Test
    public void testMatchName_withWhitespaceName() {
        // Test whitespace name
        assertFalse(se.matchName("   "));
    }

    @Test
    public void testMatchName_withMixedCaseName() {
        // Test mixed case name
        assertTrue(se.matchName("sOmEnAmE"));
    }






}

