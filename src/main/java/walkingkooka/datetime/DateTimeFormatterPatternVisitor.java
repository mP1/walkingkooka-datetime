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

import walkingkooka.visit.Visiting;
import walkingkooka.visit.Visitor;

import java.util.function.BiConsumer;
import java.util.function.IntConsumer;

/**
 * A {@link Visitor} for {@link java.time.format.DateTimeFormatter patterns}.
 */
public abstract class DateTimeFormatterPatternVisitor extends PatternVisitor {

    final static char ERA = 'G';
    final static char YEAR = 'u';
    final static char YEAR_OF_ERA = 'y';
    final static char DAY_OF_YEAR = 'D';
    final static char MONTH_OF_YEAR = 'M';
    final static char STANDALONE_MONTH_OF_YEAR = 'L';
    final static char DAY_OF_MONTH = 'd';
    final static char MODIFIED_JULIAN_DAY = 'g';

    final static char QUARTER_OF_YEAR = 'Q';
    final static char STANDALONE_QUARTER_OF_YEAR = 'q';
    final static char WEEK_BASED_YEAR = 'Y';
    final static char WEEK_OF_WEEK_BASED_YEAR = 'w';
    final static char WEEK_OF_MONTH = 'W';
    final static char DAY_OF_WEEK = 'E';
    final static char LOCALIZED_DAY_OF_WEEK = 'e';
    final static char STANDALONE_LOCALIZED_DAY_OF_WEEK = 'c';
    final static char WEEK_OF_MONTH_F = 'F';

    final static char AMPM_OF_DAY = 'a';
    final static char CLOCK_HOUR_OF_AMPM12 = 'h';
    final static char HOUR_OF_AMPM11 = 'K';
    final static char CLOCK_HOUR_OF_AMPM24 = 'k';

    final static char HOUR_OF_DAY = 'H';
    final static char MINUTE_OF_HOUR = 'm';
    final static char SECOND_OF_MINUTE = 's';
    final static char FRACTION_OF_SECOND = 'S';
    final static char MILLI_OF_DAY = 'A';
    final static char NANO_OF_DAY = 'N';
    final static char NANO_OF_SECOND = 'n';

    final static char TIMEZONE_ID = 'V';
    final static char GENERIC_TIMEZONE_NAME = 'v';
    final static char TIMEZONE_NAME = 'z';
    final static char LOCALIZED_ZONE_OFFSET = 'O';
    final static char ZONE_OFFSET_BIGX = 'X';
    final static char ZONE_OFFSET_SMALLX = 'x';
    final static char ZONE_OFFSET_Z = 'Z';

    final static char PAD = 'p';

    final static char OPTIONAL_START = '[';
    final static char OPTIONAL_END = ']';
    final static char RESERVED_HASH = '#';
    final static char RESERVED_BRACE_OPEN = '{';
    final static char RESERVED_BRACE_CLOSE = '}';

    protected DateTimeFormatterPatternVisitor() {
        super();
    }

    /**
     * <pre>
     * G       era                         text              AD; Anno Domini; A
     * </pre>
     */
    protected void visitEra(final int width,
                            final DateTimeFormatterPatternComponentKind kind) {
    }

    /**
     * <pre>
     * u       year                        year              2004; 04
     * </pre>
     */
    protected void visitYear(final int width) {
    }

    /**
     * <pre>
     * y       year-of-era                 year              2004; 04
     * </pre>
     */
    protected void visitYearOfEra(final int width) {
    }

    /**
     * <pre>
     * D       day-of-year                 number            189
     * </pre>
     */
    protected void visitDayOfYear(final int width) {
    }

    /**
     * <pre>
     * M/L     month-of-year               number/text       7; 07; Jul; July; J
     * </pre>
     */
    protected void visitMonthOfYear(final int width,
                                    final DateTimeFormatterPatternComponentKind kind) {
    }

    protected void visitStandaloneMonthOfYear(final int width,
                                              final DateTimeFormatterPatternComponentKind kind) {
    }

    /**
     * <pre>
     * d       day-of-month                number            10
     * </pre>
     */
    protected void visitDayOfMonth(final int width) {
    }

    /**
     * <pre>
     * g       modified-julian-day         number            2451334
     * </pre>
     */
    protected void visitModifiedJulianDay(final int width) {
    }

    /**
     * <pre>
     * Q/q     quarter-of-year             number/text       3; 03; Q3; 3rd quarter
     * </pre>
     */
    protected void visitQuarterOfYear(final int width,
                                      final DateTimeFormatterPatternComponentKind kind) {
    }

    protected void visitStandaloneQuarterOfYear(final int width,
                                                final DateTimeFormatterPatternComponentKind kind) {
    }

    /**
     * <pre>
     * Y       week-based-year             year              1996; 96
     * </pre>
     */
    protected void visitWeekBasedYear(final int width) {
    }

    /**
     * <pre>
     * w       week-of-week-based-year     number            27
     * </pre>
     */
    protected void visitWeekOfWeekBasedYear(final int width) {
    }

    /**
     * <pre>
     * W       week-of-month               number            4
     * </pre>
     */
    protected void visitWeekOfMonthW(final int width) {
    }

    /**
     * <pre>
     * E       day-of-week                 text              Tue; Tuesday; T
     * </pre>
     */
    protected void visitDayOfWeek(final int width,
                                  final DateTimeFormatterPatternComponentKind kind) {
    }

    /**
     * <pre>
     * e/c     localized day-of-week       number/text       2; 02; Tue; Tuesday; T
     * </pre>
     */
    protected void visitLocalizedDayOfWeek(final int width,
                                           final DateTimeFormatterPatternComponentKind kind) {
    }

    /**
     * <pre>
     * e/c     localized day-of-week       number/text       2; 02; Tue; Tuesday; T
     * </pre>
     */
    final void traverseStandaloneLocalizedDayOfWeek(final int width,
                                                    final DateTimeFormatterPatternComponentKind kind) {
        // DateTimeFormatter.of("cc") fails.
        switch (width) {
            case 1:
            case 3:
            case 4:
            case 5:
                this.visitStandaloneLocalizedDayOfWeek(width, kind);
                break;
            default:
                this.visitIllegal(DateTimeFormatterPatternVisitor.STANDALONE_LOCALIZED_DAY_OF_WEEK, width);
                break;
        }
    }

    protected void visitStandaloneLocalizedDayOfWeek(final int width,
                                                     final DateTimeFormatterPatternComponentKind kind) {
    }

    /**
     * <pre>
     * F       week-of-month               number            3
     * </pre>
     */
    protected void visitWeekOfMonthF(final int width) {
    }

    /**
     * <pre>
     * a       am-pm-of-day                text              PM        3
     * </pre>
     */
    protected void visitAmpmOfDay(final int width,
                                  final DateTimeFormatterPatternComponentKind kind) {
    }

    /**
     * <pre>
     * h       clock-hour-of-am-pm (1-12)  number            12
     * </pre>
     */
    protected void visitClockHourOfAmpm12(final int width) {
    }

    /**
     * <pre>
     * K       hour-of-am-pm (0-11)        number            0
     * </pre>
     */
    protected void visitHourOfAmpm11(final int width) {
    }

    /**
     * <pre>
     * k       clock-hour-of-am-pm (1-24)  number            0
     * </pre>
     */
    protected void visitClockHourOfAmpm24(final int width) {
    }

    /**
     * <pre>
     * H       hour-of-day (0-23)          number            0
     * </pre>
     */
    protected void visitHourOfDay23(final int width) {
    }

    /**
     * <pre>
     * m       minute-of-hour              number            30
     * </pre>
     */
    protected void visitMinuteOfHour(final int width) {
    }

    /**
     * <pre>
     * s       second-of-minute            number            55
     * </pre>
     */
    protected void visitSecondOfMinute(final int width) {
    }

    /**
     * <pre>
     * S       fraction-of-second          fraction          978
     * </pre>
     */
    protected void visitFractionOfSecond(final int width) {
    }

    /**
     * <pre>
     * A       milli-of-day                number            1234
     * </pre>
     */
    protected void visitMilliOfDay(final int width) {
    }

    /**
     * <pre>
     * n       nano-of-second              number            987654321
     * </pre>
     */
    protected void visitNanoOfSecond(final int width) {
    }

    /**
     * <pre>
     * N       nano-of-day                 number            1234000000
     * </pre>
     */
    protected void visitNanoOfDay(final int width) {
    }

    /**
     * <pre>
     * V       time-zone ID                zone-id           America/Los_Angeles; Z; -08:30
     * </pre>
     * <pre>
     * ZoneId: This outputs the time-zone ID, such as 'Europe/Paris'. If the count of letters is two, then the time-zone ID is output. Any other count of letters throws IllegalArgumentException.x`x``
     * </pre>
     */
    @SuppressWarnings("SwitchStatementWithTooFewBranches") final void traverseTimezoneId(final int width) {
        switch (width) {
            case 2:
                this.visitTimeZoneId(width);
                break;
            default:
                this.visitIllegal(DateTimeFormatterPatternVisitor.TIMEZONE_ID, width);
        }
    }

    protected void visitTimeZoneId(final int width) {
    }

    /**
     * <pre>
     * v       generic time-zone name      zone-name         Pacific Time; PT
     * </pre>
     */
    final void traverseGenericTimeZoneName(final int width,
                                           final DateTimeFormatterPatternComponentKind kind) {
        switch (width) {
            case 1:
            case 4:
                this.visitGenericTimeZoneName(width, kind);
                break;
            default:
                this.visitIllegal(DateTimeFormatterPatternVisitor.GENERIC_TIMEZONE_NAME, width);
        }
    }

    protected void visitGenericTimeZoneName(final int width,
                                            final DateTimeFormatterPatternComponentKind kind) {
    }

    /**
     * <pre>
     * z       time-zone name              zone-name         Pacific Standard Time; PST
     * </pre>
     */
    protected void visitTimeZoneName(final int width,
                                     final DateTimeFormatterPatternComponentKind kind) {
    }

    /**
     * <pre>
     * O       localized zone-offset       offset-O          GMT+8; GMT+08:00; UTC-08:00;
     * </pre>
     * <pre>
     * Offset O: This formats the localized offset based on the number of pattern letters.
     * One letter outputs the short form of the localized offset, which is localized offset text, such as 'GMT',
     * with hour without leading zero, optional 2-digit minute and second if non-zero, and colon, for example 'GMT+8'.
     * Four letters outputs the full form, which is localized offset text, such as 'GMT, with 2-digit hour and minute field,
     * optional second field if non-zero, and colon, for example 'GMT+08:00'. Any other count of letters throws IllegalArgumentException.
     * </pre>
     */
    final void traverseLocalizedZoneOffset(final int width,
                                           final DateTimeFormatterPatternComponentKind kind) {
        switch (width) {
            case 1:
            case 4:
                this.visitLocalizedZoneOffset(width, kind);
                break;
            default:
                this.visitIllegal(DateTimeFormatterPatternVisitor.LOCALIZED_ZONE_OFFSET, width);
        }
    }

    protected void visitLocalizedZoneOffset(final int width,
                                            final DateTimeFormatterPatternComponentKind kind) {
    }

    /**
     * <pre>
     * X       zone-offset 'Z' for zero    offset-X          Z; -08; -0830; -08:30; -083015; -08:30:15;
     * </pre>
     */
    protected void visitZoneOffsetBigX(final int width) {
    }

    /**
     * <pre>
     * x       zone-offset                 offset-x          +0000; -08; -0830; -08:30; -083015; -08:30:15;
     * </pre>
     */
    protected void visitZoneOffsetSmallX(final int width) {
    }

    /**
     * <pre>
     * Z       zone-offset                 offset-Z          +0000; -0800; -08:00;
     * </pre>
     */
    protected void visitZoneOffsetZ(final int width) {
    }

    /**
     * <pre>
     * p       pad next                    pad modifier      1
     * </pre>
     */
    protected void visitPad(final int width) {
    }

    /**
     * <pre>
     * [       optional section start
     * </pre>
     */
    protected void visitOptionalStart(final int width) {
    }

    /**
     * <pre>
     * ]       optional section end
     * </pre>
     */
    protected void visitOptionalEnd(final int width) {
    }

    // helpers..........................................................................................................

    final int traverse(final String pattern,
                       final int position,
                       final int max,
                       final IntConsumer dispatcher) {
        return this.traverseRepeating(pattern,
                position,
                max,
                dispatcher);
    }

    @Override //
    final int traverseChar(final char c,
                           final String pattern,
                           final int position) {
        return DateTimeFormatterPatternComponent.ofCharacter(c)
                .traverse(pattern,
                        position,
                        this);
    }

    final int traverseNumber(final String pattern,
                             final int position,
                             final int max,
                             final IntConsumer dispatcher) {
        return this.traverseRepeating(pattern,
                position,
                max,
                dispatcher);
    }

    final int traverseNumberOrText(final String pattern,
                                   final int position,
                                   final int max,
                                   final BiConsumer<Integer, DateTimeFormatterPatternComponentKind> dispatcher) {
        return this.traverseRepeating(pattern,
                position,
                max,
                DateTimeFormatterPatternComponentKindFactory.NUMBER_OR_TEXT,
                dispatcher);
    }

    final int traverseText(final String pattern,
                           final int position,
                           final int max,
                           final BiConsumer<Integer, DateTimeFormatterPatternComponentKind> dispatcher) {
        return this.traverseRepeating(pattern,
                position,
                max,
                DateTimeFormatterPatternComponentKindFactory.TEXT,
                dispatcher);
    }

    /**
     * Finds the repeating character, then calls the visitor method with a width parameter.
     */
    private int traverseRepeating(final String pattern,
                                  final int position,
                                  final int max,
                                  final IntConsumer dispatcher) {
        final String text = this.repeatingTextRun(position, pattern);
        final int width = text.length();

        if (Visiting.CONTINUE == this.startVisitComponent(position, text)) {
            if (width <= max) { // inclusive
                dispatcher.accept(width);
            } else {
                this.visitIllegal(text);
            }
        }
        this.endVisitComponent(position, text);
        return position + width;
    }

    /**
     * Finds the repeating character, then calls the visitor method with a width and kind parameter.
     */
    private int traverseRepeating(final String pattern,
                                  final int position,
                                  final int max,
                                  final DateTimeFormatterPatternComponentKindFactory kindFactory,
                                  final BiConsumer<Integer, DateTimeFormatterPatternComponentKind> dispatcher) {
        final String text = this.repeatingTextRun(position, pattern);
        final int width = text.length();

        if (Visiting.CONTINUE == this.startVisitComponent(position, text)) {
            if (width <= max) {
                dispatcher.accept(width, kindFactory.kind(width));
            } else {
                this.visitIllegal(text);
            }
        }
        this.endVisitComponent(position, text);
        return position + width;
    }
}
