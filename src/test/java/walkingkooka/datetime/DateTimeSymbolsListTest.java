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
import walkingkooka.collect.list.HasCsvStringListTesting;
import walkingkooka.collect.list.HasTsvStringListTesting;
import walkingkooka.collect.list.ImmutableListTesting;
import walkingkooka.collect.list.Lists;

public final class DateTimeSymbolsListTest implements ImmutableListTesting<DateTimeSymbolsList, DateTimeSymbols>,
    HasDateTimeSymbolsTesting,
    HasCsvStringListTesting,
    HasTsvStringListTesting {

    // setElements......................................................................................................

    @Test
    public void testSetElementsWithDifferent() {
        this.setElementsAndCheck(
            new DateTimeSymbolsList(
                Lists.of(DATE_TIME_SYMBOLS)
            ),
            Lists.of(DIFFERENT_DATE_TIME_SYMBOLS),
            new DateTimeSymbolsList(
                Lists.of(DIFFERENT_DATE_TIME_SYMBOLS)
            )
        );
    }

    @Test
    public void testSetElementsWithDifferentEmpty() {
        this.setElementsAndCheck(
            new DateTimeSymbolsList(
                Lists.of(DATE_TIME_SYMBOLS)
            ),
            Lists.empty(),
            DateTimeSymbolsList.EMPTY
        );
    }

    @Override
    public DateTimeSymbolsList createList() {
        return DateTimeSymbolsList.EMPTY;
    }

    // class............................................................................................................

    @Override
    public Class<DateTimeSymbolsList> type() {
        return DateTimeSymbolsList.class;
    }
}
