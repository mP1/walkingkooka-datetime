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
import walkingkooka.text.HasMultiLineTextTesting;

public final class DateTimeSymbolsListTest implements ImmutableListTesting<DateTimeSymbolsList, DateTimeSymbols>,
    HasDateTimeSymbolsTesting,
    HasCsvStringListTesting,
    HasTsvStringListTesting,
    HasMultiLineTextTesting {

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

    // HasMultiLineText.................................................................................................

    @Test
    public void testMultiLineTextWithEmpty() {
        this.multiLineTextAndCheck(
            this.createList(),
            LINE_ENDING,
            ""
        );
    }

    @Test
    public void testMultiLineTextWithOne() {
        this.multiLineTextAndCheck(
            this.createList()
                .concat(DATE_TIME_SYMBOLS),
            LINE_ENDING,
            "\"am,pm\",\"January,February,March,April,May,June,July,August,September,October,November,December\",\"Jan.,Feb.,Mar.,Apr.,May,Jun.,Jul.,Aug.,Sep.,Oct.,Nov.,Dec.\",\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\",\"Sun.,Mon.,Tue.,Wed.,Thu.,Fri.,Sat.\""
        );
    }

    @Test
    public void testMultiLineText() {
        this.multiLineTextAndCheck(
            this.createList()
                .concat(DATE_TIME_SYMBOLS)
                .concat(DIFFERENT_DATE_TIME_SYMBOLS),
            LINE_ENDING,
            "\"am,pm\",\"January,February,March,April,May,June,July,August,September,October,November,December\",\"Jan.,Feb.,Mar.,Apr.,May,Jun.,Jul.,Aug.,Sep.,Oct.,Nov.,Dec.\",\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\",\"Sun.,Mon.,Tue.,Wed.,Thu.,Fri.,Sat.\"\n" +
                "\"AM,PM\",\"January,February,March,April,May,June,July,August,September,October,November,December\",\"Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec\",\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\",\"Sun,Mon,Tue,Wed,Thu,Fri,Sat\""
        );
    }

    @Test
    public void testMultiLineTextWithDifferentLineEnding() {
        this.multiLineTextAndCheck(
            this.createList()
                .concat(DATE_TIME_SYMBOLS)
                .concat(DIFFERENT_DATE_TIME_SYMBOLS),
            DIFFERENT_LINE_ENDING,
            "\"am,pm\",\"January,February,March,April,May,June,July,August,September,October,November,December\",\"Jan.,Feb.,Mar.,Apr.,May,Jun.,Jul.,Aug.,Sep.,Oct.,Nov.,Dec.\",\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\",\"Sun.,Mon.,Tue.,Wed.,Thu.,Fri.,Sat.\"\r\n" +
                "\"AM,PM\",\"January,February,March,April,May,June,July,August,September,October,November,December\",\"Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec\",\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\",\"Sun,Mon,Tue,Wed,Thu,Fri,Sat\""
        );
    }

    // class............................................................................................................

    @Override
    public Class<DateTimeSymbolsList> type() {
        return DateTimeSymbolsList.class;
    }
}
