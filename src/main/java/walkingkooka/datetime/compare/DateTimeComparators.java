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

import walkingkooka.reflect.PublicStaticHelper;

import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.Comparator;

final public class DateTimeComparators implements PublicStaticHelper {

    public static Comparator<Temporal> dayOfMonth() {
        return DAY_OF_MONTH;
    }

    private final static Comparator<Temporal> DAY_OF_MONTH = TemporalFieldComparator.with(ChronoField.DAY_OF_MONTH);

    public static Comparator<Temporal> dayOfWeek() {
        return DAY_OF_WEEK;
    }

    private final static Comparator<Temporal> DAY_OF_WEEK = TemporalFieldComparator.with(ChronoField.DAY_OF_WEEK);

    
    public static Comparator<Temporal> hourOfAmPm() {
        return HOUR_OF_AMPM;
    }

    private final static Comparator<Temporal> HOUR_OF_AMPM = TemporalFieldComparator.with(ChronoField.HOUR_OF_AMPM);

    public static Comparator<Temporal> hourOfDay() {
        return HOUR_OF_DAY;
    }

    private final static Comparator<Temporal> HOUR_OF_DAY = TemporalFieldComparator.with(ChronoField.HOUR_OF_DAY);

    public static Comparator<Temporal> minuteOfHour() {
        return MINUTE_OF_HOUR;
    }

    private final static Comparator<Temporal> MINUTE_OF_HOUR = TemporalFieldComparator.with(ChronoField.MINUTE_OF_HOUR);

    public static Comparator<Temporal> monthOfYear() {
        return MONTH_OF_YEAR;
    }

    private final static Comparator<Temporal> MONTH_OF_YEAR = TemporalFieldComparator.with(ChronoField.MONTH_OF_YEAR);

    public static Comparator<Temporal> nanoOfSecond() {
        return NANO_OF_SECOND;
    }

    private final static Comparator<Temporal> NANO_OF_SECOND = TemporalFieldComparator.with(ChronoField.NANO_OF_SECOND);
    
    public static Comparator<Temporal> secondOfMinute() {
        return SECOND_OF_MINUTE;
    }

    private final static Comparator<Temporal> SECOND_OF_MINUTE = TemporalFieldComparator.with(ChronoField.SECOND_OF_MINUTE);

    /**
     * {@see TemporalFieldComparator}
     */
    public static Comparator<Temporal> temporalField(final TemporalField field) {
        return TemporalFieldComparator.with(field);
    }
    
    public static Comparator<Temporal> year() {
        return YEAR;
    }
    
    private final static Comparator<Temporal> YEAR = TemporalFieldComparator.with(ChronoField.YEAR);

    /**
     * Stop creation
     */
    private DateTimeComparators() {
        throw new UnsupportedOperationException();
    }
}
