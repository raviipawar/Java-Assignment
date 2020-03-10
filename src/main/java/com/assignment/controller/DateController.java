package com.assignment.controller;

import com.assignment.domain.DateClass;
import com.assignment.domain.LocalDates;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <h1>DateController</h1>
 * <p>
 * It is the Date class Controller, it contains method for get and post operation
 * </p>
 *
 * @author Ravindra Pawar
 */
@RestController
@RequestMapping
public class DateController {

    /**
     * <p>
     * This method is used to get an array of objects for seven days starting with the current day
     * </p>
     * <p>
     * return the dateClass
     */
    @GetMapping("/all")
    public ResponseEntity<List<DateClass>> weekDaysFromCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        String[] strDays = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday"};
        List<DateClass> dateClass = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            dateClass.add(new DateClass().toBuilder().daysWeek(strDays[(calendar.get(Calendar.DAY_OF_WEEK) + i) % 7]).date(new Date()).index(i).build());
        }
        return new ResponseEntity<>(dateClass, HttpStatus.OK);
    }


    /**
     * <p>
     * This method is used to create a datewise data from HTTP POST request with
     * a request body which will pass localDates
     * </p>
     *
     * @param localDates is the body that is sent in the post request
     * @return the dateClass
     */
    @PostMapping(value = "/uploadDates")
    public ResponseEntity<List<DateClass>> weekday(@RequestBody LocalDates localDates) {
        String[] strDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday"};
        List<DateClass> dateClass = new ArrayList<>();
        for (int i = 0; i < localDates.getDate().length; i++) {
            LocalDate today = LocalDate.parse(localDates.getDate()[i]);
            DayOfWeek dayOfWeek = DayOfWeek.from(today);
            dateClass.add(new DateClass().toBuilder().daysWeek(strDays[(dayOfWeek.getValue()) % 7]).date(new Date()).index(i).build());
        }
        return new ResponseEntity<>(dateClass,HttpStatus.OK);
    }
}
