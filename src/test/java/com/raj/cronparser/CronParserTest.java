package com.raj.cronparser;

import com.raj.cronparser.models.CronResult;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CronParserTest {
    private CronParser parser;

    @Before
    public void setUp() {
        parser = new CronParser();
    }
    @Test
    public void testAllMinute(){
        int[] expected = IntStream.iterate(0, n -> n + 1).limit(60).toArray();

        assertThat(parser.parse("* * * * * ?").getMinute())
                .containsExactly(expected);

        assertThat(parser.parse("*/1 * * * * ?").getMinute())
                .containsExactly(expected);

//        assertThat(parser.parse("0 0/1 * * ?").getMinute())
//                .containsSequence(expected);
    }

    @Test
    public void testArbitraryMinute(){
        assertThat(parser.parse("*/15 * * * * ?").getMinute())
                .containsExactly(0, 15,30, 45);
        assertThat(parser.parse("0 * * * * ?").getMinute())
                .containsExactly(0);

    }

    @Test
    public void testAllHour(){
        int[] expected = IntStream.iterate(0, n -> n + 1).limit(24).toArray();
        assertThat(parser.parse("* * * * * ?").getHour())
                .containsExactly(expected);
        assertThat(parser.parse("* */1 * * * ?").getHour())
                .containsExactly(expected);
    }

    @Test
    public void parseSelectDaysOfMonth(){
        assertThat(parser.parse("* * 1 * * * ?").getDayOfMonth())
                .containsExactly(1);
        assertThat(parser.parse("* * 1,15 * * * ?").getDayOfMonth())
                .containsExactly(1,15);
    }

    @Test
    public void parseCommand(){
        assertThat(parser.parse("* * 1 * * ?").getCommand())
                .isEqualTo("?");
    }

}
