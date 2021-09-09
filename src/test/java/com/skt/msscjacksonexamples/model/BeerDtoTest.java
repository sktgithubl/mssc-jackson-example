package com.skt.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2021-09-09T02:52:22+0530\",\"lastUpdatedDate\":\"2021-09-09T02:52:22.9313825+05:30\",\"myLocalDate\":\"20210909\",\"beerId\":\"fdc0518e-c79b-4691-8e2a-a75905b535b6\"}";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}