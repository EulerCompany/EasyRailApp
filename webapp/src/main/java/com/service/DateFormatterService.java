package com.service;

import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateFormatterService {

    public Date dateFromString(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
