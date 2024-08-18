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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

public interface DateTimeContextDelegator extends DateTimeContext {

    @Override
    default List<String> ampms() {
        return this.dateTimeContext().ampms();
    }

    @Override
    default String ampm(int hourOfDay) {
        return this.dateTimeContext().ampm(hourOfDay);
    }

    @Override
    default List<String> monthNames() {
        return this.dateTimeContext().monthNames();
    }

    @Override
    default String monthName(int month) {
        return this.dateTimeContext().monthName(month);
    }

    @Override
    default List<String> monthNameAbbreviations() {
        return this.dateTimeContext().monthNameAbbreviations();
    }

    @Override
    default String monthNameAbbreviation(int month) {
        return this.dateTimeContext().monthNameAbbreviation(month);
    }

    @Override
    default List<String> weekDayNames() {
        return this.dateTimeContext().weekDayNames();
    }

    @Override
    default String weekDayName(int day) {
        return this.dateTimeContext().weekDayName(day);
    }

    @Override
    default List<String> weekDayNameAbbreviations() {
        return this.dateTimeContext().weekDayNameAbbreviations();
    }

    @Override
    default String weekDayNameAbbreviation(int day) {
        return this.dateTimeContext().weekDayNameAbbreviation(day);
    }

    @Override
    default LocalDateTime now() {
        return this.dateTimeContext().now();
    }

    @Override
    default int defaultYear() {
        return this.dateTimeContext().defaultYear();
    }

    @Override
    default int twoDigitYear() {
        return this.dateTimeContext().twoDigitYear();
    }

    @Override
    default int twoToFourDigitYear(int year) {
        return this.dateTimeContext().twoToFourDigitYear(year);
    }

    @Override
    default Locale locale() {
        return this.dateTimeContext().locale();
    }

    DateTimeContext dateTimeContext();
}
