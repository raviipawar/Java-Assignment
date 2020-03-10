package com.assignment.controller;

import com.assignment.domain.DateClass;
import com.assignment.domain.LocalDates;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.google.gson.Gson;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableWebMvc
public class DateControllerUnitTest {

    private MockMvc mockMvc;
    @Autowired(required = true)
    private WebApplicationContext wac;

    private DateClass dateClass =new DateClass().toBuilder().index(2).daysWeek("sunday").urlProperty(false).date(new Date()).build();
    private LocalDates localDates = new LocalDates().toBuilder().date(new String[]{"2020-10-03"}).build();
    private String objectJson =new Gson().toJson(localDates);

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void weekday() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/uploadDates").contentType(MediaType.APPLICATION_JSON).content(objectJson);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }
    @Test
    public void weekDaysFromCurrentDay() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/all");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}
