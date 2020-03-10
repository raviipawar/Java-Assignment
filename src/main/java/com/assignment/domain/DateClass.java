package com.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <h1>DateClass</h1>
 * <p>
 * This is the DateClass class, it consist of all related fields getters,setters,builder and constructor
 * </p>
 *
 * @author Ravindra Pawar
 */
@SuperBuilder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class DateClass {
    private String daysWeek;
    private boolean urlProperty;
    private Date date;
    private int index;
}
