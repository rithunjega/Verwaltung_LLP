package test;

import logic.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    Parser parser;

    @Test
    void testParser() {
        String needToSplit;
        needToSplit = "1,2,2";
        assertEquals("5", parser.parse(needToSplit));
    }

}