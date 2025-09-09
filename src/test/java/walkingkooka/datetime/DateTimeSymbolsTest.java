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
import walkingkooka.collect.list.Lists;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.test.ParseStringTesting;
import walkingkooka.text.CharSequences;
import walkingkooka.text.HasTextTesting;
import walkingkooka.text.printer.TreePrintableTesting;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class DateTimeSymbolsTest implements HashCodeEqualsDefinedTesting2<DateTimeSymbols>,
    HasTextTesting,
    ParseStringTesting<DateTimeSymbols>,
    ToStringTesting<DateTimeSymbols>,
    TreePrintableTesting,
    ClassTesting<DateTimeSymbols> {

    // constants........................................................................................................

    @Test
    public void testAMPM_COUNT_MIN() {
        this.checkEquals(
            DateTimeSymbols.AMPM_COUNT_MIN,
            Arrays.stream(Locale.getAvailableLocales())
                .mapToInt((Locale l) -> countNonEmpty(new DateFormatSymbols(l).getAmPmStrings()))
                .min()
                .orElse(0)
        );
    }

    @Test
    public void testAMPM_COUNT_MAX() {
        this.checkEquals(
            DateTimeSymbols.AMPM_COUNT_MIN,
            Arrays.stream(Locale.getAvailableLocales())
                .mapToInt((Locale l) -> countNonEmpty(new DateFormatSymbols(l).getAmPmStrings()))
                .max()
                .orElse(0)
        );
    }

    @Test
    public void testMONTH_COUNT_MIN() {
        this.checkEquals(
            DateTimeSymbols.MONTH_COUNT_MIN,
            Arrays.stream(Locale.getAvailableLocales())
                .mapToInt((Locale l) -> countNonEmpty(new DateFormatSymbols(l).getMonths()))
                .min()
                .orElse(0)
        );
    }

    @Test
    public void testMONTH_COUNT_MAX() {
        this.checkEquals(
            DateTimeSymbols.MONTH_COUNT_MIN,
            Arrays.stream(Locale.getAvailableLocales())
                .mapToInt((Locale l) -> countNonEmpty(new DateFormatSymbols(l).getMonths()))
                .max()
                .orElse(0)
        );
    }

    @Test
    public void testWEEK_DAY_COUNT_MIN() {
        this.checkEquals(
            DateTimeSymbols.WEEK_DAY_COUNT_MIN,
            Arrays.stream(Locale.getAvailableLocales())
                .mapToInt((Locale l) -> countNonEmpty(new DateFormatSymbols(l).getWeekdays()))
                .min()
                .orElse(0)
        );
    }

    @Test
    public void testWEEK_DAY_COUNT_MAX() {
        this.checkEquals(
            DateTimeSymbols.WEEK_DAY_COUNT_MIN,
            Arrays.stream(Locale.getAvailableLocales())
                .mapToInt((Locale l) -> countNonEmpty(new DateFormatSymbols(l).getWeekdays()))
                .max()
                .orElse(0)
        );
    }

    private static int countNonEmpty(final String[] names) {
        return (int) Arrays.stream(names)
            .filter(n -> false == CharSequences.isNullOrEmpty(n))
            .count();
    }

    // with.............................................................................................................

    private final static List<String> AM_PMS = Lists.of("am", "pm");
    private final static List<String> MONTH_NAMES = Lists.of("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    private final static List<String> MONTH_NAME_ABBREVIATIONS = Lists.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
    private final static List<String> WEEKDAY_NAMES = Lists.of("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
    private final static List<String> WEEKDAY_NAME_ABBREVIATIONS = Lists.of("Sun", "Mon", "Tu", "Wed", "Thu", "Fri", "Sat");

    @Test
    public void testWithNullAmpmsFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTimeSymbols.with(
                null,
                MONTH_NAMES,
                MONTH_NAME_ABBREVIATIONS,
                WEEKDAY_NAMES,
                WEEKDAY_NAME_ABBREVIATIONS
            )
        );
    }

    @Test
    public void testWithNullMonthNamesFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTimeSymbols.with(
                AM_PMS,
                null,
                MONTH_NAME_ABBREVIATIONS,
                WEEKDAY_NAMES,
                WEEKDAY_NAME_ABBREVIATIONS
            )
        );
    }

    @Test
    public void testWithNullMonthNameAbbreviationsFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTimeSymbols.with(
                AM_PMS,
                MONTH_NAMES,
                null,
                WEEKDAY_NAMES,
                WEEKDAY_NAME_ABBREVIATIONS
            )
        );
    }

    @Test
    public void testWithNullWeekdayNamesFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTimeSymbols.with(
                AM_PMS,
                MONTH_NAMES,
                MONTH_NAME_ABBREVIATIONS,
                null,
                WEEKDAY_NAME_ABBREVIATIONS
            )
        );
    }

    @Test
    public void testWithNullWeekdayNameAbbreviationsFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTimeSymbols.with(
                AM_PMS,
                MONTH_NAMES,
                MONTH_NAME_ABBREVIATIONS,
                WEEKDAY_NAMES,
                null
            )
        );
    }

    // ampms............................................................................................................

    @Test
    public void testSetAmpmsWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> this.createObject().setAmpms(null)
        );
    }

    @Test
    public void testSetAmpmsWithSame() {
        final DateTimeSymbols symbols = this.createObject();

        assertSame(
            symbols,
            symbols.setAmpms(AM_PMS)
        );
    }

    @Test
    public void testSetAmpmsWithDifferent() {
        final DateTimeSymbols symbols = this.createObject();

        final List<String> differentAmpms = toUpperCase(AM_PMS);
        final DateTimeSymbols different = symbols.setAmpms(differentAmpms);

        assertNotSame(
            symbols,
            different
        );

        this.ampmsAndCheck(
            different,
            differentAmpms
        );
        this.monthNamesAndCheck(different);
        this.monthNameAbbreviationsAndCheck(different);
        this.weekDayNamesAndCheck(different);
        this.weekDayNameAbbreviationsAndCheck(different);
    }

    private void ampmsAndCheck(final DateTimeSymbols symbols) {
        this.ampmsAndCheck(
            symbols,
            AM_PMS
        );
    }

    private void ampmsAndCheck(final DateTimeSymbols symbols,
                               final List<String> ampms) {
        this.checkEquals(
            ampms,
            symbols.ampms(),
            "ampms"
        );
    }

    // monthNames.......................................................................................................

    @Test
    public void testSetMonthNamesWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> this.createObject().setMonthNames(null)
        );
    }

    @Test
    public void testSetMonthNamesWithSame() {
        final DateTimeSymbols symbols = this.createObject();

        assertSame(
            symbols,
            symbols.setMonthNames(MONTH_NAMES)
        );
    }

    @Test
    public void testSetMonthNamesWithDifferent() {
        final DateTimeSymbols symbols = this.createObject();

        final List<String> differentMonthNames = toUpperCase(MONTH_NAMES);
        final DateTimeSymbols different = symbols.setMonthNames(differentMonthNames);

        assertNotSame(
            symbols,
            different
        );

        this.ampmsAndCheck(different);
        this.monthNamesAndCheck(
            different,
            differentMonthNames
        );
        this.monthNameAbbreviationsAndCheck(different);
        this.weekDayNamesAndCheck(different);
        this.weekDayNameAbbreviationsAndCheck(different);
    }

    private void monthNamesAndCheck(final DateTimeSymbols symbols) {
        this.monthNamesAndCheck(
            symbols,
            MONTH_NAMES
        );
    }

    private void monthNamesAndCheck(final DateTimeSymbols symbols,
                                    final List<String> monthNames) {
        this.checkEquals(
            monthNames,
            symbols.monthNames(),
            "monthNames"
        );
    }

    // monthNames.......................................................................................................

    @Test
    public void testSetMonthNameAbbreviationsWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> this.createObject().setMonthNameAbbreviations(null)
        );
    }

    @Test
    public void testSetMonthNameAbbreviationsWithSame() {
        final DateTimeSymbols symbols = this.createObject();

        assertSame(
            symbols,
            symbols.setMonthNameAbbreviations(MONTH_NAME_ABBREVIATIONS)
        );
    }

    @Test
    public void testSetMonthNameAbbreviationsWithDifferent() {
        final DateTimeSymbols symbols = this.createObject();

        final List<String> differentMonthNameAbbreviations = toUpperCase(MONTH_NAME_ABBREVIATIONS);
        final DateTimeSymbols different = symbols.setMonthNameAbbreviations(differentMonthNameAbbreviations);

        assertNotSame(
            symbols,
            different
        );

        this.ampmsAndCheck(different);
        this.monthNamesAndCheck(different);
        this.monthNameAbbreviationsAndCheck(
            different,
            differentMonthNameAbbreviations
        );
        this.weekDayNamesAndCheck(different);
        this.weekDayNameAbbreviationsAndCheck(different);
    }

    private void monthNameAbbreviationsAndCheck(final DateTimeSymbols symbols) {
        this.monthNameAbbreviationsAndCheck(
            symbols,
            MONTH_NAME_ABBREVIATIONS
        );
    }

    private void monthNameAbbreviationsAndCheck(final DateTimeSymbols symbols,
                                                final List<String> monthNames) {
        this.checkEquals(
            monthNames,
            symbols.monthNameAbbreviations(),
            "monthNameAbbreviations"
        );
    }

    // weekDayNames.....................................................................................................

    @Test
    public void testSetWeekDayNamesWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> this.createObject().setWeekDayNames(null)
        );
    }

    @Test
    public void testSetWeekDayNamesWithSame() {
        final DateTimeSymbols symbols = this.createObject();

        assertSame(
            symbols,
            symbols.setWeekDayNames(WEEKDAY_NAMES)
        );
    }

    @Test
    public void testSetWeekDayNamesWithDifferent() {
        final DateTimeSymbols symbols = this.createObject();

        final List<String> differentWeekDayNames = toUpperCase(WEEKDAY_NAMES);
        final DateTimeSymbols different = symbols.setWeekDayNames(differentWeekDayNames);

        assertNotSame(
            symbols,
            different
        );

        this.ampmsAndCheck(different);
        this.monthNamesAndCheck(different);
        this.monthNameAbbreviationsAndCheck(different);
        this.weekDayNamesAndCheck(
            different,
            differentWeekDayNames
        );
        this.weekDayNameAbbreviationsAndCheck(different);
    }

    private void weekDayNamesAndCheck(final DateTimeSymbols symbols) {
        this.weekDayNamesAndCheck(
            symbols,
            WEEKDAY_NAMES
        );
    }

    private void weekDayNamesAndCheck(final DateTimeSymbols symbols,
                                      final List<String> weekDayNames) {
        this.checkEquals(
            weekDayNames,
            symbols.weekDayNames(),
            "weekDayNames"
        );
    }

    // weekDayNameAbbreviations.........................................................................................

    @Test
    public void testSetWeekDayNameAbbreviationsWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> this.createObject().setWeekDayNameAbbreviations(null)
        );
    }

    @Test
    public void testSetWeekDayNameAbbreviationsWithSame() {
        final DateTimeSymbols symbols = this.createObject();

        assertSame(
            symbols,
            symbols.setWeekDayNameAbbreviations(WEEKDAY_NAME_ABBREVIATIONS)
        );
    }

    @Test
    public void testSetWeekDayNameAbbreviationsWithDifferent() {
        final DateTimeSymbols symbols = this.createObject();

        final List<String> differentWeekDayNameAbbreviations = toUpperCase(WEEKDAY_NAME_ABBREVIATIONS);
        final DateTimeSymbols different = symbols.setWeekDayNameAbbreviations(differentWeekDayNameAbbreviations);

        assertNotSame(
            symbols,
            different
        );

        this.ampmsAndCheck(different);
        this.monthNamesAndCheck(different);
        this.monthNameAbbreviationsAndCheck(different);
        this.weekDayNamesAndCheck(different);
        this.weekDayNameAbbreviationsAndCheck(
            different,
            differentWeekDayNameAbbreviations
        );
    }

    private void weekDayNameAbbreviationsAndCheck(final DateTimeSymbols symbols) {
        this.weekDayNameAbbreviationsAndCheck(
            symbols,
            WEEKDAY_NAME_ABBREVIATIONS
        );
    }

    private void weekDayNameAbbreviationsAndCheck(final DateTimeSymbols symbols,
                                                  final List<String> weekDayNames) {
        this.checkEquals(
            weekDayNames,
            symbols.weekDayNameAbbreviations(),
            "weekDayNameAbbreviations"
        );
    }

    // fromDateFormatSymbols............................................................................................

    @Test
    public void testFromDateFormatSymbolsWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateTimeSymbols.fromDateFormatSymbols(null)
        );
    }

    @Test
    public void testFromDateFormatSymbols() {
        final DateTimeSymbols symbols = DateTimeSymbols.fromDateFormatSymbols(
            new DateFormatSymbols(Locale.forLanguageTag("EN-AU"))
        );

        this.ampmsAndCheck(
            symbols,
            AM_PMS
        );
        this.monthNamesAndCheck(
            symbols,
            MONTH_NAMES
        );
        this.monthNameAbbreviationsAndCheck(
            symbols,
            Lists.of("Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec.")
        );
        this.weekDayNamesAndCheck(
            symbols,
            WEEKDAY_NAMES
        );
        this.weekDayNameAbbreviationsAndCheck(
            symbols,
            Lists.of("Sun.", "Mon.", "Tue.", "Wed.", "Thu.", "Fri.", "Sat.")
        );
    }

    // text..............................................................................................................

    @Test
    public void testText() {
        this.textAndCheck(
            this.createObject(),
            "\"am,pm\",\"January,February,March,April,May,June,July,August,September,October,November,December\",\"Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec\",\"Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday\",\"Sun,Mon,Tu,Wed,Thu,Fri,Sat\""
        );
    }

    // parse............................................................................................................

    @Test
    public void testParse() {
        final DateTimeSymbols symbols = this.createObject();

        this.parseStringAndCheck(
            symbols.text(),
            symbols
        );
    }

    @Override
    public DateTimeSymbols parseString(final String text) {
        return DateTimeSymbols.parse(text);
    }

    @Override
    public Class<? extends RuntimeException> parseStringFailedExpected(final Class<? extends RuntimeException> expected) {
        return expected;
    }

    @Override
    public RuntimeException parseStringFailedExpected(final RuntimeException expected) {
        return expected;
    }

    // TreePrintable....................................................................................................

    @Test
    public void testTreePrintable() {
        this.treePrintAndCheck(
            this.createObject(),
            "DateTimeSymbols\n" +
                "  ampms\n" +
                "    am\n" +
                "    pm\n" +
                "  monthNames\n" +
                "    January\n" +
                "    February\n" +
                "    March\n" +
                "    April\n" +
                "    May\n" +
                "    June\n" +
                "    July\n" +
                "    August\n" +
                "    September\n" +
                "    October\n" +
                "    November\n" +
                "    December\n" +
                "  monthNameAbbreviations\n" +
                "    Jan\n" +
                "    Feb\n" +
                "    Mar\n" +
                "    Apr\n" +
                "    May\n" +
                "    Jun\n" +
                "    Jul\n" +
                "    Aug\n" +
                "    Sep\n" +
                "    Oct\n" +
                "    Nov\n" +
                "    Dec\n" +
                "  weekDayNames\n" +
                "    Sunday\n" +
                "    Monday\n" +
                "    Tuesday\n" +
                "    Wednesday\n" +
                "    Thursday\n" +
                "    Friday\n" +
                "    Saturday\n" +
                "  weekDayNameAbbreviations\n" +
                "    Sun\n" +
                "    Mon\n" +
                "    Tu\n" +
                "    Wed\n" +
                "    Thu\n" +
                "    Fri\n" +
                "    Sat\n"
        );
    }

    // hashCode/equals..................................................................................................

    @Test
    public void testEqualsDifferentAmpm() {
        this.checkNotEquals(
            DateTimeSymbols.with(
                toUpperCase(AM_PMS),
                MONTH_NAMES,
                MONTH_NAME_ABBREVIATIONS,
                WEEKDAY_NAMES,
                WEEKDAY_NAME_ABBREVIATIONS
            )
        );
    }

    @Test
    public void testEqualsDifferentMonthNames() {
        this.checkNotEquals(
            DateTimeSymbols.with(
                AM_PMS,
                toUpperCase(MONTH_NAMES),
                MONTH_NAME_ABBREVIATIONS,
                WEEKDAY_NAMES,
                WEEKDAY_NAME_ABBREVIATIONS
            )
        );
    }

    @Test
    public void testEqualsDifferentMonthNamesAbbreviations() {
        this.checkNotEquals(
            DateTimeSymbols.with(
                AM_PMS,
                MONTH_NAMES,
                toUpperCase(MONTH_NAME_ABBREVIATIONS),
                WEEKDAY_NAMES,
                WEEKDAY_NAME_ABBREVIATIONS
            )
        );
    }

    @Test
    public void testEqualsDifferentWeekdayNames() {
        this.checkNotEquals(
            DateTimeSymbols.with(
                AM_PMS,
                MONTH_NAMES,
                MONTH_NAME_ABBREVIATIONS,
                toUpperCase(WEEKDAY_NAMES),
                WEEKDAY_NAME_ABBREVIATIONS
            )
        );
    }

    @Test
    public void testEqualsDifferentWeekDayNamesAbbreviations() {
        this.checkNotEquals(
            DateTimeSymbols.with(
                AM_PMS,
                MONTH_NAMES,
                MONTH_NAME_ABBREVIATIONS,
                WEEKDAY_NAMES,
                toUpperCase(WEEKDAY_NAME_ABBREVIATIONS)
            )
        );
    }

    private List<String> toUpperCase(final List<String> list) {
        return list.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }

    @Override
    public DateTimeSymbols createObject() {
        return DateTimeSymbols.with(
            AM_PMS,
            MONTH_NAMES,
            MONTH_NAME_ABBREVIATIONS,
            WEEKDAY_NAMES,
            WEEKDAY_NAME_ABBREVIATIONS
        );
    }

    // toString.........................................................................................................

    @Test
    public void testToString() {
        this.toStringAndCheck(
            this.createObject(),
            "ampms=\"am\", \"pm\" monthNames=\"January\", \"February\", \"March\", \"April\", \"May\", \"June\", \"July\", \"August\", \"September\", \"October\", \"November\", \"December\" monthNameAbbreviations=\"Jan\", \"Feb\", \"Mar\", \"Apr\", \"May\", \"Jun\", \"Jul\", \"Aug\", \"Sep\", \"Oct\", \"Nov\", \"Dec\" weekDayNames=\"Sunday\", \"Monday\", \"Tuesday\", \"Wednesday\", \"Thursday\", \"Friday\", \"Saturday\" weekDayNameAbbreviations=\"Sun\", \"Mon\", \"Tu\", \"Wed\", \"Thu\", \"Fri\", \"Sat\""
        );
    }

    // type.............................................................................................................

    @Override
    public Class<DateTimeSymbols> type() {
        return DateTimeSymbols.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
