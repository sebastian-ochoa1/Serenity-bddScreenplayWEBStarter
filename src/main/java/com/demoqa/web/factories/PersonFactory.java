package com.demoqa.web.factories;


import com.demoqa.web.models.PersonModel;
import lombok.SneakyThrows;
import org.openqa.selenium.NotFoundException;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class PersonFactory {
    private static final String PERSON_PATH = "json/person.json";

    private PersonFactory() {
    }

    public static PersonModel with(String code) {
        return getData().stream()
                .filter(user -> user.getCode()
                        .equals(code))
                .findFirst()
                .orElseThrow(() ->
                        new NotFoundException(String.format("Data with code %s not found", code)));
    }

    public static List<PersonModel> getData() {
        return Arrays.asList(from(getDataFile()).getObject("persons", PersonModel[].class));
    }

    @SneakyThrows
    private static URL getDataFile() {
        String path = PERSON_PATH;
        URL filePath = PersonFactory.class.getClassLoader().getResource(path);
        if (filePath == null) {
            throw new FileNotFoundException("File not found for person: " + path);
        }
        return filePath;
    }
}
