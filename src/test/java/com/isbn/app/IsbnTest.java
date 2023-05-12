package com.isbn.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsbnTest {

    @Test
    public void testInvalidIsbn10() {
        assertEquals("Invalid", ISBN.isbn13("0140449119"));
        assertEquals("Invalid", ISBN.isbn13("1843198761"));
        assertEquals("Invalid", ISBN.isbn13("0440180297"));
        assertEquals("Invalid", ISBN.isbn13("abc123def4"));
    }

    @Test
    public void testInvalidIsbn13() {
        assertEquals("Invalid", ISBN.isbn13("9780140449113"));
        assertEquals("Invalid", ISBN.isbn13("9781843198768"));
        assertEquals("Invalid", ISBN.isbn13("9780440180297"));
        assertEquals("Invalid", ISBN.isbn13("abc123def4567"));
        assertEquals("Invalid", ISBN.isbn13("9783876155237"));
        assertEquals("Invalid", ISBN.isbn13("031606652X"));
        assertEquals("Invalid", ISBN.isbn13("0345453747"));
    }

    @Test
    public void testInvalidIsbnStringWithIncorrectInput() {
        assertEquals("Invalid", ISBN.isbn13("978014"));
        assertEquals("Invalid", ISBN.isbn13("978184319876"));
        assertEquals("Invalid", ISBN.isbn13("9780440180297678"));
        assertEquals("Invalid", ISBN.isbn13("abc123def"));
    }

    @Test
    public void testValidISBN13() {
        assertEquals("Valid", ISBN.isbn13("9780140449112"));
        assertEquals("Valid", ISBN.isbn13("9780545010221"));
        assertEquals("Valid", ISBN.isbn13("9780440180296"));
        assertEquals("Valid", ISBN.isbn13("9780316066525"));
        assertEquals("Valid", ISBN.isbn13("9783866155237"));
        assertEquals("Valid", ISBN.isbn13("9780345453747"));
    }
    
    @Test
    public void testISBN10ToISBN13Conversion() {
        assertEquals("9780140449112", ISBN.isbn13("0140449116"));
        assertEquals("9780545010221", ISBN.isbn13("0545010225"));
        assertEquals("9780440180296", ISBN.isbn13("0440180295"));
        assertEquals("9781234567897", ISBN.isbn13("123456789X"));
        assertEquals("9780316066525", ISBN.isbn13("0316066524"));
        assertEquals("9783866155237", ISBN.isbn13("3866155239"));
        assertEquals("9788174504944", ISBN.isbn13("817450494X"));
    }

}

