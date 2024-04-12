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

package walkingkooka.datetime.compare;

import org.junit.jupiter.api.Test;
import walkingkooka.compare.ComparatorTesting;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.reflect.PublicStaticHelperTesting;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.Comparator;

final public class DateTimeComparatorsTest implements PublicStaticHelperTesting<DateTimeComparators>,
        ComparatorTesting {

    // DateTimeComparators......................................................................................................

    @Test
    public void testCompareDayOfMonth() {
        this.compareAndCheckLess(
                DateTimeComparators.<Temporal>dayOfMonth(),
                LocalDate.of(2000, 12, 1),
                LocalDateTime.of(2000, 12, 12, 12, 58, 59)
        );
    }

    @Test
    public void testCompareDayOfMonth2() {
        final Comparator<Temporal> comparator = DateTimeComparators.dayOfMonth();

        this.compareAndCheckLess(
                comparator,
                LocalDate.of(2000, 12, 1),
                LocalDateTime.of(2000, 12, 12, 12, 58, 59)
        );
    }

    @Test
    public void testCompareHourOfAmpm() {
        this.compareAndCheckLess(
                DateTimeComparators.hourOfAmPm(),
                LocalTime.of(13, 59, 58),
                LocalDateTime.of(2000, 12, 12, 11, 58, 59)
        );
    }

    @Test
    public void testCompareHourOfDay() {
        this.compareAndCheckLess(
                DateTimeComparators.hourOfDay(),
                LocalTime.of(1, 59, 58),
                LocalDateTime.of(2000, 12, 12, 12, 58, 59)
        );
    }

    @Test
    public void testCompareMinuteOfHour() {
        this.compareAndCheckLess(
                DateTimeComparators.minuteOfHour(),
                LocalTime.of(12, 1, 58),
                LocalDateTime.of(2000, 12, 12, 12, 58, 59)
        );
    }

    @Test
    public void testCompareMonthOfYear() {
        this.compareAndCheckLess(
                DateTimeComparators.monthOfYear(),
                LocalDate.of(2000, 1, 31),
                LocalDateTime.of(2000, 12, 12, 12, 58, 59)
        );
    }

    @Test
    public void testCompareNanoOfSecond() {
        this.compareAndCheckLess(
                DateTimeComparators.nanoOfSecond(),
                LocalTime.of(12, 1, 1, 100),
                LocalDateTime.of(2000, 12, 22, 12, 58, 59, 200)
        );
    }

    @Test
    public void testCompareSecondOfMinute() {
        this.compareAndCheckLess(
                DateTimeComparators.secondOfMinute(),
                LocalTime.of(12, 58, 1),
                LocalDateTime.of(2000, 12, 12, 12, 58, 59)
        );
    }

    @Test
    public void testCompareYear() {
        this.compareAndCheckLess(
                DateTimeComparators.year(),
                LocalDate.of(1999, 1, 31),
                LocalDateTime.of(2000, 1, 31, 12, 58, 59)
        );
    }

    // PublicStaticHelperTesting........................................................................................

    @Override
    public Class<DateTimeComparators> type() {
        return DateTimeComparators.class;
    }

    @Override
    public boolean canHavePublicTypes(final Method method) {
        return false;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}

