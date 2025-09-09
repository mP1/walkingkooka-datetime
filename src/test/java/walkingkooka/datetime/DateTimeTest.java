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
import walkingkooka.InvalidCharacterException;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.reflect.PublicStaticHelperTesting;
import walkingkooka.text.CharSequences;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class DateTimeTest implements PublicStaticHelperTesting<DateTime> {

    // DateToInstant....................................................................................................

    @Test
    public void testDateToInstantWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTime.dateToInstant(null)
        );
    }

    @Test
    public void testDateToInstant() {
        final Date date = new Date(
            Date.UTC(1900 - 1900, Calendar.JANUARY, 1, 0, 0, 0)
        );

        this.checkEquals(
            date.toInstant(),
            DateTime.dateToInstant(date)
        );
    }

    @Test
    public void testDateToInstant2() {
        final Date date = new Date(
            Date.UTC(1999 - 1900, Calendar.DECEMBER, 31, 0, 0, 0)
        );

        this.checkEquals(
            date.toInstant(),
            DateTime.dateToInstant(date)
        );
    }

    @Test
    public void testDateToInstantToDate() {
        final Date date = new Date(
            Date.UTC(1999 - 1900, Calendar.DECEMBER, 31, 0, 0, 0)
        );

        this.checkEquals(
            date,
            DateTime.instantToDate(
                DateTime.dateToInstant(date)
            )
        );
    }

    // DateToLocalDateTime..............................................................................................

    @Test
    public void testDateToDateTimeWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTime.dateToLocalDateTime(null)
        );
    }

    @Test
    public void testDateToLocalDateTime() {
        this.checkEquals(
            LocalDateTime.of(
                1900,
                1,
                1,
                0,
                0
            ),
            DateTime.dateToLocalDateTime(
                new Date(
                    Date.UTC(
                        1900 - 1900,
                        Calendar.JANUARY,
                        1,
                        0,
                        0,
                        0
                    )
                )
            )
        );
    }

    @Test
    public void testDateToLocalDateTime2() {
        this.checkEquals(
            LocalDateTime.of(
                1999,
                12,
                31,
                12,
                58,
                59
            ),
            DateTime.dateToLocalDateTime(
                new Date(
                    Date.UTC(
                        1999 - 1900,
                        Calendar.DECEMBER,
                        31,
                        12,
                        58,
                        59
                    )
                )
            )
        );
    }

    @Test
    public void testDateToLocalDateTime3() {
        this.checkEquals(
            LocalDateTime.of(
                2000,
                1,
                1,
                12,
                58,
                59
            ),
            DateTime.dateToLocalDateTime(
                new Date(
                    Date.UTC(
                        2000 - 1900,
                        Calendar.JANUARY,
                        1,
                        12,
                        58,
                        59
                    )
                )
            )
        );
    }

    @Test
    public void testDateToLocalDateTimeToDate() {
        final Date date = new Date(
            Date.UTC(
                1999 - 1900,
                Calendar.DECEMBER,
                31,
                12,
                58,
                0
            )
        );

        this.checkEquals(
            date,
            DateTime.localDateTimeToDate(
                DateTime.dateToLocalDateTime(date)
            )
        );
    }

    @Test
    public void testDateToLocalDateTimeToDate2() {
        final Date date = new Date(
            Date.UTC(
                2000 - 1900,
                Calendar.JANUARY,
                1,
                12,
                58,
                0
            )
        );

        this.checkEquals(
            date,
            DateTime.localDateTimeToDate(
                DateTime.dateToLocalDateTime(date)
            )
        );
    }

    // InstantToDate....................................................................................................

    @Test
    public void testInstantToDateWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTime.instantToDate(null)
        );
    }

    @Test
    public void testInstantToDate() {
        final Date date = new Date(
            Date.UTC(1900 - 1900, Calendar.JANUARY, 1, 0, 0, 0)
        );

        this.checkEquals(
            date,
            DateTime.instantToDate(
                date.toInstant()
            )
        );
    }

    // LocalDateTime....................................................................................................

    @Test
    public void testLocalDateToDateWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTime.localDateToDate(null)
        );
    }

    @Test
    public void testLocalDateToDate() {
        this.checkEquals(
            new Date(
                Date.UTC(2000 - 1900, Calendar.DECEMBER, 31, 0, 0, 0)
            ),
            DateTime.localDateToDate(
                LocalDate.of(2000, 12, 31)
            )
        );
    }

    @Test
    public void testLocalDateTimeToDateWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTime.localDateTimeToDate(null)
        );
    }

    @Test
    public void testLocalDateTimeToDate() {
        this.checkEquals(
            new Date(
                Date.UTC(2000 - 1900, Calendar.DECEMBER, 31, 12, 58, 59)
            ),
            DateTime.localDateTimeToDate(
                LocalDateTime.of(2000, 12, 31, 12, 58, 59)
            )
        );
    }

    @Test
    public void testLocalDateTimeToDateToLocalDateTime() {
        final LocalDateTime localDateTime = LocalDateTime.of(
            2023,
            8,
            29,
            1,
            2,
            59
        );

        this.checkEquals(
            localDateTime,
            DateTime.dateToLocalDateTime(
                DateTime.localDateTimeToDate(
                    localDateTime
                )
            )
        );
    }

    @Test
    public void testLocalTimeToDateWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTime.localTimeToDate(null)
        );
    }

    @Test
    public void testLocalTimeToDate() {
        this.checkEquals(
            new Date(
                Date.UTC(1970 - 1900, Calendar.JANUARY, 1, 12, 58, 59)
            ),
            DateTime.localTimeToDate(
                LocalTime.of(12, 58, 59)
            )
        );
    }

    // simpleDateFormatPatternWithoutTimezone...........................................................................

    @Test
    public void testSimpleDateFormatPatternWithoutTimezoneWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTime.simpleDateFormatPatternWithoutTimezone(null)
        );
    }

    @Test
    public void testSimpleDateFormatPatternWithoutTimezoneWithInvalidComponentFails() {
        final InvalidCharacterException thrown = assertThrows(
            InvalidCharacterException.class,
            () -> DateTime.simpleDateFormatPatternWithoutTimezone("AM")
        );

        this.checkEquals(
            "Invalid character 'A' at 0",
            thrown.getMessage()
        );
    }

    @Test
    public void testSimpleDateFormatPatternWithoutTimezoneWithInvalidComponentFails2() {
        final InvalidCharacterException thrown = assertThrows(
            InvalidCharacterException.class,
            () -> DateTime.simpleDateFormatPatternWithoutTimezone("dd/MM/yyyy AM")
        );

        this.checkEquals(
            "Invalid character 'A' at 11",
            thrown.getMessage()
        );
    }

    @Test
    public void testSimpleDateFormatPatternWithoutTimezoneWithoutTimeZone() {
        final String pattern = "dd/MM/yyyy hh:mm:ss.00";

        this.simpleDateFormatPatternWithoutTimezoneAndCheck(
            pattern,
            pattern
        );
    }

    @Test
    public void testSimpleDateFormatPatternWithoutTimezoneWithTimeZoneSmallZ() {
        final String pattern = "dd/MM/yyyy hh:mm:ss.00";

        this.simpleDateFormatPatternWithoutTimezoneAndCheck(
            pattern + " z",
            pattern
        );
    }

    @Test
    public void testSimpleDateFormatPatternWithoutTimezoneWithTimeZoneBigZ() {
        final String pattern = "dd/MM/yyyy hh:mm:ss.00";

        this.simpleDateFormatPatternWithoutTimezoneAndCheck(
            pattern + " Z",
            pattern
        );
    }

    @Test
    public void testSimpleDateFormatPatternWithoutTimezoneWithTimeZoneX() {
        final String pattern = "dd/MM/yyyy hh:mm:ss.00";

        this.simpleDateFormatPatternWithoutTimezoneAndCheck(
            pattern + " X",
            pattern
        );
    }

    private void simpleDateFormatPatternWithoutTimezoneAndCheck(final String pattern,
                                                                final String expected) {
        this.checkEquals(
            expected,
            DateTime.simpleDateFormatPatternWithoutTimezone(pattern),
            () -> "simpleDateFormatPatternWithoutTimezone " + CharSequences.quoteAndEscape(pattern)
        );
    }

    // PublicStaticHelperTesting........................................................................................

    @Override
    public boolean canHavePublicTypes(final Method method) {
        return false;
    }

    @Override
    public Class<DateTime> type() {
        return DateTime.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
