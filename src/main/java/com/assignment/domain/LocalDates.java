package com.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

/**
 * <h1>LocalDates</h1>
 * <p>
 * This is the LocalDates class, it consist of all related fields getters,setters,builder and constructor
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
public class LocalDates {
    private String[] date;
}
