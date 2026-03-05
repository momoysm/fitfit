package com.ecommerce.common.util;

import com.ecommerce.common.constant.DateTimeConstant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateTimeUtil {

    /**
     * 현재 LocalDateTime 반환
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * 현재 LocalDate 반환
     */
    public static LocalDate today() {
        return LocalDate.now();
    }

    /**
     * LocalDateTime -> String
     */
    public static String format(LocalDateTime dateTime) {
        return format(dateTime, DateTimeConstant.DATE_TIME_FORMAT);
    }

    /**
     * LocalDateTime -> String (패턴 지정)
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    /**
     * LocalDate -> String
     */
    public static String format(LocalDate date) {
        return format(date, DateTimeConstant.DATE_FORMAT);
    }

    /**
     * LocalDate -> String (패턴 지정)
     */
    public static String format(LocalDate date, String pattern) {
        if (date == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * String -> LocalDateTime
     */
    public static LocalDateTime parseDateTime(String dateTime) {
        return parseDateTime(dateTime, DateTimeConstant.DATE_TIME_FORMAT);
    }

    /**
     * String -> LocalDateTime (패턴 지정)
     */
    public static LocalDateTime parseDateTime(String dateTime, String pattern) {
        if (dateTime == null || dateTime.isBlank()) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTime, formatter);
    }

    /**
     * String -> LocalDate
     */
    public static LocalDate parseDate(String date) {
        return parseDate(date, DateTimeConstant.DATE_FORMAT);
    }

    /**
     * String -> LocalDate (패턴 지정)
     */
    public static LocalDate parseDate(String date, String pattern) {
        if (date == null || date.isBlank()) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, formatter);
    }

    /**
     * 날짜 시작 시간 (00:00:00)
     */
    public static LocalDateTime startOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    /**
     * 날짜 끝 시간 (23:59:59)
     */
    public static LocalDateTime endOfDay(LocalDate date) {
        return date.atTime(LocalTime.MAX);
    }

}
