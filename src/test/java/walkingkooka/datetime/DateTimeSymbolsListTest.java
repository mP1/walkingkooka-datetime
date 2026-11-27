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
import walkingkooka.collect.list.CsvStringList;
import walkingkooka.collect.list.HasCsvStringListTesting;
import walkingkooka.collect.list.HasTsvStringListTesting;
import walkingkooka.collect.list.ImmutableListTesting;
import walkingkooka.collect.list.Lists;
import walkingkooka.collect.list.TsvStringList;
import walkingkooka.text.HasMultiLineTextTesting;

import java.text.DateFormatSymbols;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class DateTimeSymbolsListTest implements ImmutableListTesting<DateTimeSymbolsList, DateTimeSymbols>,
    HasDateTimeSymbolsTesting,
    HasCsvStringListTesting,
    HasTsvStringListTesting,
    HasMultiLineTextTesting {

    // fromCsvStringList................................................................................................

    @Test
    public void testFromCsvStringListWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTimeSymbolsList.fromCsvStringList(null)
        );
    }

    @Test
    public void testFromCsvStringListWithEmpty() {
        this.fromCsvStringListAndCheck(
            CsvStringList.EMPTY,
            DateTimeSymbolsList.EMPTY
        );
    }

    @Test
    public void testFromCsvStringListWithNotEmpty() {
        final DateTimeSymbolsList list = DateTimeSymbolsList.EMPTY.concat(DATE_TIME_SYMBOLS)
            .concat(DIFFERENT_DATE_TIME_SYMBOLS);

        this.fromCsvStringListAndCheck(
            list.csvStringList(),
            list
        );
    }

    @Test
    public void testFromCsvStringListWithIncludesNull() {
        final DateTimeSymbolsList list = DateTimeSymbolsList.EMPTY.concat(DATE_TIME_SYMBOLS)
            .concat(null)
            .concat(DIFFERENT_DATE_TIME_SYMBOLS);

        this.fromCsvStringListAndCheck(
            list.csvStringList(),
            list
        );
    }

    private void fromCsvStringListAndCheck(final CsvStringList csvStringList,
                                           final DateTimeSymbolsList expected) {
        this.checkEquals(
            expected,
            DateTimeSymbolsList.fromCsvStringList(csvStringList)
        );
    }

    // fromTsvStringList................................................................................................

    @Test
    public void testFromTsvStringListWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTimeSymbolsList.fromTsvStringList(null)
        );
    }

    @Test
    public void testFromTsvStringListWithEmpty() {
        this.fromTsvStringListAndCheck(
            TsvStringList.EMPTY,
            DateTimeSymbolsList.EMPTY
        );
    }

    @Test
    public void testFromTsvStringListWithNotEmpty() {
        final DateTimeSymbolsList list = DateTimeSymbolsList.EMPTY.concat(DATE_TIME_SYMBOLS)
            .concat(DIFFERENT_DATE_TIME_SYMBOLS);

        this.fromTsvStringListAndCheck(
            list.tsvStringList(),
            list
        );
    }

    private void fromTsvStringListAndCheck(final TsvStringList tsvStringList,
                                           final DateTimeSymbolsList expected) {
        this.checkEquals(
            expected,
            DateTimeSymbolsList.fromTsvStringList(tsvStringList)
        );
    }

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


    @Test
    public void testSetElementsIncludesNull() {
        final List<DateTimeSymbols> list = Lists.of(
            DATE_TIME_SYMBOLS,
            null,
            DIFFERENT_DATE_TIME_SYMBOLS
        );

        this.setElementsAndCheck(
            DateTimeSymbolsList.EMPTY.concat(DATE_TIME_SYMBOLS),
            list,
            new DateTimeSymbolsList(list)
        );
    }

    // subList..........................................................................................................

    private final static DateTimeSymbols DATE_TIME_SYMBOLS1 = DATE_TIME_SYMBOLS;
    private final static DateTimeSymbols DATE_TIME_SYMBOLS2 = DIFFERENT_DATE_TIME_SYMBOLS;
    private final static DateTimeSymbols DATE_TIME_SYMBOLS3 = DateTimeSymbols.fromDateFormatSymbols(
        new DateFormatSymbols(
            Locale.forLanguageTag("en-CA")
        )
    );
    private final static DateTimeSymbols DATE_TIME_SYMBOLS4 = DateTimeSymbols.fromDateFormatSymbols(
        new DateFormatSymbols(
            Locale.forLanguageTag("en-UK")
        )
    );
    private final static DateTimeSymbols DATE_TIME_SYMBOLS5 = DateTimeSymbols.fromDateFormatSymbols(
        new DateFormatSymbols(
            Locale.forLanguageTag("en-US")
        )
    );

    private final static List<DateTimeSymbols> ELEMENTS = Lists.of(
        DATE_TIME_SYMBOLS1,
        DATE_TIME_SYMBOLS2,
        DATE_TIME_SYMBOLS3,
        DATE_TIME_SYMBOLS4,
        DATE_TIME_SYMBOLS5
    );

    @Test
    public void testSubList() {
        this.subListAndCheck(
            new DateTimeSymbolsList(ELEMENTS),
            0,
            2,
            new DateTimeSymbolsList(
                Lists.of(
                    DATE_TIME_SYMBOLS1,
                    DATE_TIME_SYMBOLS2
                )
            )
        );
    }

    @Test
    public void testSubList2() {
        this.subListAndCheck(
            new DateTimeSymbolsList(ELEMENTS),
            2,
            4,
            new DateTimeSymbolsList(
                Lists.of(
                    DATE_TIME_SYMBOLS3,
                    DATE_TIME_SYMBOLS4
                )
            )
        );
    }

    @Test
    public void testSubListSubList() {
        this.subListAndCheck(
            new DateTimeSymbolsList(ELEMENTS)
                .subList(
                    1,
                    4
                ), // 2, 3, 4
            1,
            3,
            new DateTimeSymbolsList(
                Lists.of(
                    DATE_TIME_SYMBOLS3,
                    DATE_TIME_SYMBOLS4
                )
            )
        );
    }

    @Override
    public DateTimeSymbolsList createList() {
        return DateTimeSymbolsList.EMPTY;
    }

    // CsvStringList....................................................................................................

    @Test
    public void testCsvStringListWithEmpty() {
        this.csvStringListAndCheck(
            DateTimeSymbolsList.EMPTY,
            ""
        );
    }

    @Test
    public void testCsvStringListWithNotEmpty() {
        this.csvStringListAndCheck(
            DateTimeSymbolsList.EMPTY.concat(DATE_TIME_SYMBOLS)
                .concat(DIFFERENT_DATE_TIME_SYMBOLS),
            "\"\"\"am,pm\"\",\"\"January,February,March,April,May,June,July,August,September,October,November,December\"\",\"\"Jan.,Feb.,Mar.,Apr.,May,Jun.,Jul.,Aug.,Sep.,Oct.,Nov.,Dec.\"\",\"\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\"\",\"\"Sun.,Mon.,Tue.,Wed.,Thu.,Fri.,Sat.\"\"\"\n" +
                "\"\"\"AM,PM\"\",\"\"January,February,March,April,May,June,July,August,September,October,November,December\"\",\"\"Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec\"\",\"\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\"\",\"\"Sun,Mon,Tue,Wed,Thu,Fri,Sat\"\"\"\n"
        );
    }

    @Test
    public void testCsvStringListWithNotEmptyIncludesNull() {
        this.csvStringListAndCheck(
            DateTimeSymbolsList.EMPTY.concat(DATE_TIME_SYMBOLS)
                .concat(null)
                .concat(DIFFERENT_DATE_TIME_SYMBOLS),
            "\"\"\"am,pm\"\",\"\"January,February,March,April,May,June,July,August,September,October,November,December\"\",\"\"Jan.,Feb.,Mar.,Apr.,May,Jun.,Jul.,Aug.,Sep.,Oct.,Nov.,Dec.\"\",\"\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\"\",\"\"Sun.,Mon.,Tue.,Wed.,Thu.,Fri.,Sat.\"\"\"\n" +
                "\n" +
                "\"\"\"AM,PM\"\",\"\"January,February,March,April,May,June,July,August,September,October,November,December\"\",\"\"Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec\"\",\"\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\"\",\"\"Sun,Mon,Tue,Wed,Thu,Fri,Sat\"\"\"\n"
        );
    }

    @Test
    public void testCsvStringListAndMultiLineText() {
        this.multiLineTextAndCheck(
            DateTimeSymbolsList.EMPTY.concat(DATE_TIME_SYMBOLS)
                .concat(DIFFERENT_DATE_TIME_SYMBOLS),
            TEXT_CONTEXT,
            "\"am,pm\",\"January,February,March,April,May,June,July,August,September,October,November,December\",\"Jan.,Feb.,Mar.,Apr.,May,Jun.,Jul.,Aug.,Sep.,Oct.,Nov.,Dec.\",\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\",\"Sun.,Mon.,Tue.,Wed.,Thu.,Fri.,Sat.\"\n" +
                "\"AM,PM\",\"January,February,March,April,May,June,July,August,September,October,November,December\",\"Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec\",\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\",\"Sun,Mon,Tue,Wed,Thu,Fri,Sat\""
        );
    }

    // TsvStringList....................................................................................................

    @Test
    public void testTsvStringListWithEmpty() {
        this.tsvStringListAndCheck(
            DateTimeSymbolsList.EMPTY,
            ""
        );
    }

    @Test
    public void testTsvStringListWithNotEmpty() {
        this.tsvStringListAndCheck(
            DateTimeSymbolsList.EMPTY.concat(DATE_TIME_SYMBOLS)
                .concat(DIFFERENT_DATE_TIME_SYMBOLS),
            "\"\"\"am\tpm\"\"\t\"\"January\tFebruary\tMarch\tApril\tMay\tJune\tJuly\tAugust\tSeptember\tOctober\tNovember\tDecember\"\"\t\"\"Jan.\tFeb.\tMar.\tApr.\tMay\tJun.\tJul.\tAug.\tSep.\tOct.\tNov.\tDec.\"\"\t\"\"Sunday\tMonday\tTuesday\tWednesday\tThursday\tFriday\tSaturday\"\"\t\"\"Sun.\tMon.\tTue.\tWed.\tThu.\tFri.\tSat.\"\"\"\n" +
                "\"\"\"AM\tPM\"\"\t\"\"January\tFebruary\tMarch\tApril\tMay\tJune\tJuly\tAugust\tSeptember\tOctober\tNovember\tDecember\"\"\t\"\"Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec\"\"\t\"\"Sunday\tMonday\tTuesday\tWednesday\tThursday\tFriday\tSaturday\"\"\t\"\"Sun\tMon\tTue\tWed\tThu\tFri\tSat\"\"\"\n"
        );
    }

    @Test
    public void testTsvStringListAndMultiLineText() {
        this.multiLineTextAndCheck(
            DateTimeSymbolsList.EMPTY.concat(DATE_TIME_SYMBOLS)
                .concat(DIFFERENT_DATE_TIME_SYMBOLS),
            TEXT_CONTEXT,
            "\"am,pm\",\"January,February,March,April,May,June,July,August,September,October,November,December\",\"Jan.,Feb.,Mar.,Apr.,May,Jun.,Jul.,Aug.,Sep.,Oct.,Nov.,Dec.\",\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\",\"Sun.,Mon.,Tue.,Wed.,Thu.,Fri.,Sat.\"\n" +
                "\"AM,PM\",\"January,February,March,April,May,June,July,August,September,October,November,December\",\"Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec\",\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\",\"Sun,Mon,Tue,Wed,Thu,Fri,Sat\""
        );
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
