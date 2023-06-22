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

import walkingkooka.reflect.PublicStaticHelper;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;

/**
 * A collection of utilities to convert new java.time classes to java.util.Date primarily so the value can be formatted
 * using a {@link java.text.DateFormat}.
 */
public final class DateTime implements PublicStaticHelper {

    /**
     * Returns a {@link Date} with an equivalent value as the given {@link LocalDate}.
     */
    public static Date localDateToDate(final LocalDate localDate) {
        Objects.requireNonNull(localDate, "localDate");

        return dateFromInstant(
                localDate.atStartOfDay()
                        .toInstant(ZoneOffset.UTC)
        );
    }

    /**
     * Returns a {@link Date} with an equivalent value as the given {@link LocalDateTime}.
     */
    public static Date localDateTimeToDate(final LocalDateTime localDateTime) {
        Objects.requireNonNull(localDateTime, "localDateTime");

        return dateFromInstant(
                localDateTime.toInstant(ZoneOffset.UTC)
        );
    }

    /**
     * Returns a {@link Date} with an equivalent value as the given {@link LocalTime}. Note the day/month/year will
     * be set to 1970/1/1.
     */
    public static Date localTimeToDate(final LocalTime localTime) {
        Objects.requireNonNull(localTime, "localTime");

        return dateFromInstant(
                localTime.atDate(LocalDate.EPOCH)
                        .toInstant(ZoneOffset.UTC)
        );
    }

    // Date.from(Instant) is not available in the GWT JRE.
    private static Date dateFromInstant(final Instant instant) {
        return new Date(
                instant.toEpochMilli()
        );
    }

    /**
     * Accept a {@link SimpleDateFormat#toPattern()} filtering any timezone components.
     */
    public static String simpleDateFormatPatternWithoutTimezone(final String pattern) {
        return DateTimeSimpleDateFormatPatternWithoutTimeZoneSimpleDateFormatPatternVisitor.removeTimeZonePatternComponents(pattern)
                .trim();
    }

    /**
     * Stop creation
     */
    private DateTime() {
        throw new UnsupportedOperationException();
    }
}
