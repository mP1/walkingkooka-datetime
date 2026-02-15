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
import walkingkooka.HashCodeEqualsDefinedTesting2;
import walkingkooka.ToStringTesting;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class OptionalDateTimeSymbolsTest implements ClassTesting<OptionalDateTimeSymbols>,
    HashCodeEqualsDefinedTesting2<OptionalDateTimeSymbols>,
    ToStringTesting<OptionalDateTimeSymbols> {

    private final static Optional<DateTimeSymbols> DATE_TIME_SYMBOLS = Optional.of(
        DateTimeSymbols.fromDateFormatSymbols(
            new DateFormatSymbols(Locale.forLanguageTag("en-AU"))
        )
    );

    // with.............................................................................................................

    @Test
    public void testWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> OptionalDateTimeSymbols.with(null)
        );
    }

    @Test
    public void testWithEmpty() {
        assertSame(
            OptionalDateTimeSymbols.EMPTY,
            OptionalDateTimeSymbols.with(
                Optional.empty()
            )
        );
    }

    @Test
    public void testWithNotEmpty() {
        final OptionalDateTimeSymbols optional = OptionalDateTimeSymbols.with(DATE_TIME_SYMBOLS);

        assertSame(
            DATE_TIME_SYMBOLS,
            optional.value()
        );
    }

    // hashCode/equals..................................................................................................

    @Test
    public void testEqualsDifferent() {
        this.checkNotEquals(
            OptionalDateTimeSymbols.with(
                Optional.of(
                    DateTimeSymbols.fromDateFormatSymbols(
                        new DateFormatSymbols(Locale.forLanguageTag("en-NZ"))
                    )
                )
            )
        );
    }

    @Override
    public OptionalDateTimeSymbols createObject() {
        return OptionalDateTimeSymbols.with(DATE_TIME_SYMBOLS);
    }

    // toString.........................................................................................................

    @Test
    public void testToString() {
        this.toStringAndCheck(
            this.createObject(),
            DATE_TIME_SYMBOLS.get()
                .toString()
        );
    }

    @Test
    public void testToStringWithEmpty() {
        this.toStringAndCheck(
            OptionalDateTimeSymbols.EMPTY,
            ""
        );
    }

    // class............................................................................................................

    @Override
    public Class<OptionalDateTimeSymbols> type() {
        return OptionalDateTimeSymbols.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
