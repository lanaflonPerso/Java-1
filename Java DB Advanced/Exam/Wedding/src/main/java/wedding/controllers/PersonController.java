package wedding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import wedding.dtos.bindings.PeopleImportFromJsonDto;
import wedding.entities.Person;
import wedding.io.Writer;
import wedding.serializers.Serializer;
import wedding.services.PersonService;
import wedding.utilities.MessagesConstants;

@Controller
public class PersonController {
    private static final String PEOPLE_JSON_INPUT_PATH = "/json/input/people.json";
    private static final String SUCCESSFULLY_IMPORTED_PERSON = "Successfully imported %s";

    private final Serializer jsonSerializer;
    private final PersonService personService;
    private final Writer writer;

    @Autowired
    public PersonController(@Qualifier("json") Serializer jsonSerializer, PersonService personService, Writer writer) {
        this.jsonSerializer = jsonSerializer;
        this.personService = personService;
        this.writer = writer;
    }

    public void importPeopleFromJson() {
        PeopleImportFromJsonDto[] peopleImportFromJsonDtos = this.jsonSerializer.deserialize(PeopleImportFromJsonDto[].class, PEOPLE_JSON_INPUT_PATH);
        for (PeopleImportFromJsonDto peopleImportFromJsonDto : peopleImportFromJsonDtos) {
            Person person = this.personService.createOne(peopleImportFromJsonDto);
            if (person != null) {
                this.writer.println(SUCCESSFULLY_IMPORTED_PERSON, person.getFullName());
            } else {
                this.writer.println(MessagesConstants.INVALID_INPUT_DATA_MESSAGE);
            }
        }
    }
}
