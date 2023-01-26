package test;

import com.google.gwt.junit.client.GWTTestCase;

import java.time.LocalDateTime;
import java.util.Locale;
import walkingkooka.datetime.DateTimeContexts;
import walkingkooka.collect.list.Lists;

public class TestGwtTest extends GWTTestCase {

    @Override
    public String getModuleName() {
        return "test.Test";
    }

    public void testAssertEquals() {
        assertEquals(
                1,
                1
        );
    }

    public void testDateContextMonthNames() {
        assertEquals(
                Lists.of(
                        "January",
                        "February",
                        "March",
                        "April",
                        "May",
                        "June",
                        "July",
                        "August",
                        "September",
                        "October",
                        "November",
                        "December"
                ),
                DateTimeContexts.locale(
                        Locale.getDefault(),
                        2000,
                        1950,
                        () -> LocalDateTime.now()
                ).monthNames()
        );
    }
}
