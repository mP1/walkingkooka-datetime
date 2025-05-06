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

import walkingkooka.ToStringBuilder;
import walkingkooka.collect.list.Lists;

import java.util.List;
import java.util.Objects;

/**
 * Holds the Locale related data for dates and times.
 */
public final class DateTimeSymbols {

    public static DateTimeSymbols with(final List<String> ampms,
                                       final List<String> monthNames,
                                       final List<String> monthNameAbbreviations,
                                       final List<String> weekDayNames,
                                       final List<String> weekDayNameAbbreviations) {
        return new DateTimeSymbols(
                Lists.immutable(Objects.requireNonNull(ampms, "ampms")),
                Lists.immutable(Objects.requireNonNull(monthNames, "monthNames")),
                Lists.immutable(Objects.requireNonNull(monthNameAbbreviations, "monthNameAbbreviations")),
                Lists.immutable(Objects.requireNonNull(weekDayNames, "weekDayNames")),
                Lists.immutable(Objects.requireNonNull(weekDayNameAbbreviations, "weekDayNameAbbreviations"))
        );
    }

    private DateTimeSymbols(final List<String> ampms,
                            final List<String> monthNames,
                            final List<String> monthNameAbbreviations,
                            final List<String> weekDayNames,
                            final List<String> weekDayNameAbbreviations) {
        this.ampms = ampms;

        this.monthNames = monthNames;
        this.monthNameAbbreviations = monthNameAbbreviations;

        this.weekDayNames = weekDayNames;
        this.weekDayNameAbbreviations = weekDayNameAbbreviations;
    }

    public List<String> ampms() {
        return this.ampms;
    }

    public DateTimeSymbols setAmpms(final List<String> ampms) {
        final List<String> copy = Lists.immutable(ampms);
        return this.ampms.equals(copy) ?
                this :
                new DateTimeSymbols(
                        ampms,
                        this.monthNames,
                        this.monthNameAbbreviations,
                        this.weekDayNames,
                        this.weekDayNameAbbreviations
                );
    }

    private final List<String> ampms;

    public List<String> monthNames() {
        return this.monthNames;
    }

    public DateTimeSymbols setMonthNames(final List<String> monthNames) {
        final List<String> copy = Lists.immutable(monthNames);
        return this.monthNames.equals(copy) ?
                this :
                new DateTimeSymbols(
                        this.ampms,
                        copy,
                        this.monthNameAbbreviations,
                        this.weekDayNames,
                        this.weekDayNameAbbreviations
                );
    }

    private final List<String> monthNames;

    public List<String> monthNameAbbreviations() {
        return this.monthNameAbbreviations;
    }

    public DateTimeSymbols setMonthNameAbbreviations(final List<String> monthNameAbbreviations) {
        final List<String> copy = Lists.immutable(monthNameAbbreviations);
        return this.monthNameAbbreviations.equals(copy) ?
                this :
                new DateTimeSymbols(
                        this.ampms,
                        this.monthNames,
                        copy,
                        this.weekDayNames,
                        this.weekDayNameAbbreviations
                );
    }

    private final List<String> monthNameAbbreviations;

    public List<String> weekDayNames() {
        return this.weekDayNames;
    }

    public DateTimeSymbols setWeekDayNames(final List<String> weekDayNames) {
        final List<String> copy = Lists.immutable(weekDayNames);
        return this.weekDayNames.equals(copy) ?
                this :
                new DateTimeSymbols(
                        this.ampms,
                        this.monthNames,
                        this.monthNameAbbreviations,
                        copy,
                        this.weekDayNameAbbreviations
                );
    }

    private final List<String> weekDayNames;

    public List<String> weekDayNameAbbreviations() {
        return this.weekDayNameAbbreviations;
    }

    public DateTimeSymbols setWeekDayNameAbbreviations(final List<String> weekDayNameAbbreviations) {
        final List<String> copy = Lists.immutable(weekDayNameAbbreviations);
        return this.weekDayNameAbbreviations.equals(copy) ?
                this :
                new DateTimeSymbols(
                        this.ampms,
                        this.monthNames,
                        this.monthNameAbbreviations,
                        this.weekDayNames,
                        copy
                );
    }

    private final List<String> weekDayNameAbbreviations;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(
                this.ampms,
                this.monthNames,
                this.monthNameAbbreviations,
                this.weekDayNames,
                this.weekDayNameAbbreviations
        );
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof DateTimeSymbols && this.equals0((DateTimeSymbols) other);
    }

    private boolean equals0(final DateTimeSymbols other) {
        return this.ampms.equals(other.ampms) &&
                this.monthNames.equals(other.monthNames) &&
                this.monthNameAbbreviations.equals(other.monthNameAbbreviations) &&
                this.weekDayNames.equals(other.weekDayNames) &&
                this.weekDayNameAbbreviations.equals(other.weekDayNameAbbreviations);
    }

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .label("ampms").value(this.ampms)
                .label("monthNames").value(this.monthNames)
                .label("monthNameAbbreviations").value(this.monthNameAbbreviations)
                .label("weekDayNames").value(this.weekDayNames)
                .label("weekDayNameAbbreviations").value(this.weekDayNameAbbreviations)
                .build();
    }
}
