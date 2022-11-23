package com.enigmacamp.yukngoding.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    void whenDateUtil_CalculatePeriod_Successfully(){
        LocalDate actualDate = DateUtil.periodCalculationWorkDay("2022-11-25",14);
        assertEquals("2022-12-14",actualDate.toString());
    }
}