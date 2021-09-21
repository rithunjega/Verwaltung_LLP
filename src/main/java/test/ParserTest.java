package test;

import application.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    Parser parser;

    @Test
    void testMultiply() {
        String needToSplit;
        needToSplit = "1,2,2";
        assertEquals("5", parser.parse(needToSplit));
    }

}