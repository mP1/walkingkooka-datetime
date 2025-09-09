package test;

import com.google.gwt.junit.client.GWTTestCase;
import org.junit.Test;

import walkingkooka.collect.list.Lists;
import walkingkooka.datetime.DateTime;
import walkingkooka.datetime.DateTimeContexts;
import walkingkooka.datetime.DateTimeSymbols;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@walkingkooka.j2cl.locale.LocaleAware
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
        final Locale locale = Locale.getDefault();

        this.checkEquals(
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
            DateTimeContexts.basic(
                DateTimeSymbols.fromDateFormatSymbols(
                    new DateFormatSymbols(locale)
                ),
                locale,
                2000,
                50,
                () -> LocalDateTime.now()
            ).monthNames()
        );
    }

    @Test
    public void testDateTimeLocalDateToDate() {
        this.checkEquals(
            new Date(
                Date.UTC(
                    2000 - 1900,
                    Calendar.DECEMBER,
                    31,
                    0,
                    0,
                    0
                )
            ),
            DateTime.localDateToDate(
                LocalDate.of(2000, 12, 31)
            )
        );
    }

    public void checkEquals(final Object expected,
                            final Object actual) {
        assertEquals(
            expected,
            actual
        );
    }
}
