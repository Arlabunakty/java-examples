package ua.arlabunakty.examples.jackson.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.junit.jupiter.api.Test;
import ua.arlabunakty.examples.jackson.model.Person;

import java.util.Arrays;
import java.util.List;

public class CustomPersonCollectionToMapSerializerTest extends BaseTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void serialize() throws JsonProcessingException {
        Person batMan = new Person();
        batMan.setFirstName("Bruce");
        batMan.setLastName("Wayne");
        batMan.setSsn(1234567890L);

        Person batGirl = new Person();
        batGirl.setFirstName("Barbara");
        batGirl.setLastName("Gordon");
        batGirl.setSsn(1234567891L);

        PersonLookup personLookup = new PersonLookup(Arrays.asList(batMan, batGirl));

        String json = objectMapper.writeValueAsString(personLookup);


        assertEquals(aposToQuotes("{'personList':{'1234567890':'Bruce Wayne','1234567891':'Barbara Gordon'}}"), json);
    }

    public static class CustomPersonCollectionToMapSerializer extends StdCollectionToMapSerializer<Person> {

        @Override
        protected Object getMapValue(Person value) {
            return String.format("%s %s", value.getFirstName(), value.getLastName());
        }

        @Override
        protected String getMapKey(Person value) {
            return value.getSsn().toString();
        }
    }

    public class PersonLookup {

        @JsonSerialize(using = CustomPersonCollectionToMapSerializer.class)
        private final List<Person> personList;

        PersonLookup(List<Person> personList) {
            this.personList = personList;
        }
    }

}
