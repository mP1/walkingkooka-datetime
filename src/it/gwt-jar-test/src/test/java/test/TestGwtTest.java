package test;

import com.google.gwt.junit.client.GWTTestCase;
import org.junit.Test;
import walkingkooka.collect.list.Lists;
import walkingkooka.datetime.DateTime;
import walkingkooka.datetime.DateTimeContexts;
import walkingkooka.j2cl.locale.LocaleAware;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@LocaleAware
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
                        50,
                        () -> LocalDateTime.now()
                ).monthNames()
        );
    }

    @Test
    public void testDateTimeLocalDateToDate() {
        assertEquals(
                new Date(
                        Date.UTC(2000 - 1900, Calendar.DECEMBER, 31, 0, 0, 0)
                ),
                DateTime.localDateToDate(
                        LocalDate.of(2000, 12, 31)
                )
        );
    }
}
