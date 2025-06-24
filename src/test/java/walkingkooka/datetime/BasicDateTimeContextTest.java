/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.datetime;

import org.junit.jupiter.api.Test;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class BasicDateTimeContextTest implements DateTimeContextTesting2<BasicDateTimeContext> {

    private final static Locale LOCALE = Locale.ENGLISH;
    
    private final static DateTimeSymbols SYMBOLS = DateTimeSymbols.fromDateFormatSymbols(
            new DateFormatSymbols(LOCALE)
    );

    private final static int DEFAULT_YEAR = 1901;

    private final static HasNow NOW = () -> LocalDateTime.of(1999, 12, 31, 12, 58, 59);

    @Test
    public void testWithNullDateTimeSymbolsFails() {
        assertThrows(
                NullPointerException.class,
                () -> BasicDateTimeContext.with(
                        null,
                        LOCALE,
                        DEFAULT_YEAR,
                        50,
                        NOW
                )
        );
    }

    @Test
    public void testWithNullLocaleFails() {
        assertThrows(
                NullPointerException.class,
                () -> BasicDateTimeContext.with(
                        SYMBOLS,
                        null,
                        DEFAULT_YEAR,
                        50,
                        NOW
                )
        );
    }

    @Test
    public void testWithNullNegativeTwoDigitYearFails() {
        assertThrows(
                IllegalArgumentException.class,
                () -> BasicDateTimeContext.with(
                        SYMBOLS,
                        Locale.ENGLISH,
                        DEFAULT_YEAR,
                        -1,
                        NOW
                )
        );
    }

    @Test
    public void testWithNullInvalidTwoDigitYearFails2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> BasicDateTimeContext.with(
                        SYMBOLS,
                        Locale.ENGLISH,
                        DEFAULT_YEAR,
                        100,
                        NOW
                )
        );
    }

    @Test
    public void testWithNullNowSupplierFails() {
        assertThrows(
                NullPointerException.class,
                () -> BasicDateTimeContext.with(
                        SYMBOLS,
                        Locale.ENGLISH,
                        DEFAULT_YEAR,
                        50,
                        null
                )
        );
    }

    // ampm.............................................................................................................

    @Test
    public void testAmpmMidnight() {
        this.amPmAndCheck(0, "AM");
    }

    @Test
    public void testAmpm600() {
        this.amPmAndCheck(6, "AM");
    }

    @Test
    public void testAmpmNoon() {
        this.amPmAndCheck(12, "PM");
    }

    @Test
    public void testAmpm1800() {
        this.amPmAndCheck(18, "PM");
    }

    // defaultYear......................................................................................................

    @Test
    public void testDefaultYear() {
        this.defaultYearAndCheck(this.createContext(), DEFAULT_YEAR);
    }

    // locale...........................................................................................................

    @Test
    public void testLocale() {
        this.localeAndCheck(
                this.createContext(),
                LOCALE
        );
    }

    // monthName........................................................................................................

    @Test
    public void testMonthName0() {
        this.monthNameAndCheck(0, "January");
    }

    @Test
    public void testMonthName1() {
        this.monthNameAndCheck(1, "February");
    }

    @Test
    public void testMonthName11() {
        this.monthNameAndCheck(11, "December");
    }

    // monthNameAbbreviation............................................................................................

    @Test
    public void testMonthNameAbbreviation0() {
        this.monthNameAbbreviationAndCheck(0, "Jan");
    }

    @Test
    public void testMonthNameAbbreviation1() {
        this.monthNameAbbreviationAndCheck(1, "Feb");
    }

    @Test
    public void testMonthNameAbbreviation11() {
        this.monthNameAbbreviationAndCheck(11, "Dec");
    }

    // weekDayName......................................................................................................

    @Test
    public void testWeekDayName1() {
        this.weekDayNameAndCheck(0, "Sunday");
    }

    @Test
    public void testWeekDayName2() {
        this.weekDayNameAndCheck(1, "Monday");
    }

    @Test
    public void testWeekDayName6() {
        this.weekDayNameAndCheck(6, "Saturday");
    }

    // weekDayNameAbbreviation..........................................................................................

    @Test
    public void testWeekDayNameAbbreviation1() {
        this.weekDayNameAbbreviationAndCheck(0, "Sun");
    }

    @Test
    public void testWeekDayNameAbbreviation2() {
        this.weekDayNameAbbreviationAndCheck(1, "Mon");
    }

    @Test
    public void testWeekDayNameAbbreviation6() {
        this.weekDayNameAbbreviationAndCheck(6, "Sat");
    }

    @Override
    public BasicDateTimeContext createContext() {
        return BasicDateTimeContext.with(
                SYMBOLS,
                LOCALE,
                DEFAULT_YEAR,
                1,
                NOW
        );
    }

    // toString.........................................................................................................

    @Test
    public void testToString() {
        this.toStringAndCheck(
                this.createContext(),
                "symbols=ampms=\"AM\", \"PM\" monthNames=\"January\", \"February\", \"March\", \"April\", \"May\", \"June\", \"July\", \"August\", \"September\", \"October\", \"November\", \"December\" monthNameAbbreviations=\"Jan\", \"Feb\", \"Mar\", \"Apr\", \"May\", \"Jun\", \"Jul\", \"Aug\", \"Sep\", \"Oct\", \"Nov\", \"Dec\" weekDayNames=\"Sunday\", \"Monday\", \"Tuesday\", \"Wednesday\", \"Thursday\", \"Friday\", \"Saturday\" weekDayNameAbbreviations=\"Sun\", \"Mon\", \"Tue\", \"Wed\", \"Thu\", \"Fri\", \"Sat\" locale=\"en\" twoDigitYear=1"
        );
    }

    // class............................................................................................................

    @Override
    public Class<BasicDateTimeContext> type() {
        return BasicDateTimeContext.class;
    }
}
