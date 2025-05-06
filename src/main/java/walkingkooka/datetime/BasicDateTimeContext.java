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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * A {@link DateTimeContext} that uses the dependencies to source values.
 */
final class BasicDateTimeContext implements DateTimeContext {

    static BasicDateTimeContext with(final DateTimeSymbols symbols,
                                     final Locale locale,
                                     final int defaultYear,
                                     final int twoDigitYear,
                                     final HasNow now) {
        Objects.requireNonNull(symbols, "symbols");
        Objects.requireNonNull(locale, "locale");
        if (twoDigitYear < 0 || twoDigitYear > 99) {
            throw new IllegalArgumentException("Invalid two digit year " + twoDigitYear + " expected beteen 0 and 100");
        }
        Objects.requireNonNull(now, "now");

        return new BasicDateTimeContext(
                symbols,
                locale,
                defaultYear,
                twoDigitYear,
                now
        );
    }

    private BasicDateTimeContext(final DateTimeSymbols symbols,
                                 final Locale locale,
                                 final int defaultYear,
                                 final int twoDigitYear,
                                 final HasNow now) {
        super();

        this.symbols = symbols;
        this.locale = locale;

        this.defaultYear = defaultYear;
        this.twoDigitYear = twoDigitYear;
        this.now = now;
    }

    // DateTimeContext..................................................................................................

    @Override
    public List<String> ampms() {
        return this.symbols.ampms();
    }

    @Override
    public int defaultYear() {
        return this.defaultYear;
    }

    private final int defaultYear;

    @Override
    public Locale locale() {
        return this.locale;
    }

    private final Locale locale;

    @Override
    public List<String> monthNames() {
        return this.symbols.monthNames();
    }

    @Override
    public List<String> monthNameAbbreviations() {
        return this.symbols.monthNameAbbreviations();
    }

    @Override
    public LocalDateTime now() {
        return this.now.now();
    }

    private final HasNow now;

    @Override
    public int twoDigitYear() {
        return this.twoDigitYear;
    }

    private final int twoDigitYear;

    @Override
    public List<String> weekDayNames() {
        return this.symbols.weekDayNames();
    }

    @Override
    public List<String> weekDayNameAbbreviations() {
        return this.symbols.weekDayNameAbbreviations();
    }

    private final DateTimeSymbols symbols;

    // Object...........................................................................................................

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .label("symbols").value(this.symbols)
                .label("locale").value(this.locale.toLanguageTag())
                .label("twoDigitYear").value(this.twoDigitYear)
                .build();
    }
}
