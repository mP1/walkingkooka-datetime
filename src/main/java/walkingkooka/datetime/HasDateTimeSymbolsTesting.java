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

import walkingkooka.util.HasLocaleTesting;

import java.text.DateFormatSymbols;
import java.util.Optional;

public interface HasDateTimeSymbolsTesting extends HasLocaleTesting {

    DateTimeSymbols DATE_TIME_SYMBOLS = DateTimeSymbols.fromDateFormatSymbols(
        new DateFormatSymbols(LOCALE)
    );

    Optional<DateTimeSymbols> OPTIONAL_DATE_TIME_SYMBOLS = Optional.of(DATE_TIME_SYMBOLS);

    default void dateTimeSymbolsAndCheck(final HasDateTimeSymbols has,
                                         final DateTimeSymbols expected) {
        this.checkEquals(
            expected,
            has.dateTimeSymbols(),
            has::toString
        );
    }
}
