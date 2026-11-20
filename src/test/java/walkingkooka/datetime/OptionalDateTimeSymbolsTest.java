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
import walkingkooka.reflect.PublicClassTesting;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class OptionalDateTimeSymbolsTest implements PublicClassTesting<OptionalDateTimeSymbols>,
    HasDateTimeSymbolsTesting,
    HashCodeEqualsDefinedTesting2<OptionalDateTimeSymbols>,
    HasOptionalDateTimeSymbolsTesting,
    ToStringTesting {

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
        final OptionalDateTimeSymbols optional = OptionalDateTimeSymbols.with(OPTIONAL_DATE_TIME_SYMBOLS);

        assertSame(
            OPTIONAL_DATE_TIME_SYMBOLS,
            optional.value()
        );
    }

    // HasDateTimeSymbols...............................................................................................

    @Test
    public void testDateTimeSymbolsWithEmpty() {
        this.dateTimeSymbolsAndCheck(
            OptionalDateTimeSymbols.EMPTY
        );
    }

    @Test
    public void testDateTimeSymbolsWithNotEmpty() {
        this.dateTimeSymbolsAndCheck(
            OptionalDateTimeSymbols.with(OPTIONAL_DATE_TIME_SYMBOLS),
            DATE_TIME_SYMBOLS
        );
    }

    // hashCode/equals..................................................................................................

    @Test
    public void testEqualsDifferent() {
        this.checkNotEquals(
            OptionalDateTimeSymbols.with(OPTIONAL_DIFFERENT_DATE_TIME_SYMBOLS)
        );
    }

    @Override
    public OptionalDateTimeSymbols createObject() {
        return OptionalDateTimeSymbols.with(OPTIONAL_DATE_TIME_SYMBOLS);
    }

    // toString.........................................................................................................

    @Test
    public void testToString() {
        this.toStringAndCheck(
            this.createObject(),
            DATE_TIME_SYMBOLS.toString()
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
}
