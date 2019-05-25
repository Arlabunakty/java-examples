package ua.arlabunakty.examples.jackson.serializer;

public abstract class BaseTest {

    protected String aposToQuotes(String json) {
        return json.replace("'", "\"");
    }

    protected void assertEquals(String expected, String actual) {
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
    }

}
