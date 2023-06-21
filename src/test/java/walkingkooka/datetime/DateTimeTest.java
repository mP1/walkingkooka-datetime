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
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.reflect.PublicStaticHelperTesting;

import java.lang.reflect.Method;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class DateTimeTest implements PublicStaticHelperTesting<DateTime> {

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
                Date.UTC(2000- 1900, Calendar.DECEMBER, 31, 12, 58, 59)
                ),
                DateTime.localDateTimeToDate(
                        LocalDateTime.of(2000, 12, 31, 12, 58, 59)
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
