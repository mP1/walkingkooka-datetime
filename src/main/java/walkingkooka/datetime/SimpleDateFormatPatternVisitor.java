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

import java.util.function.BiConsumer;
import java.util.function.IntConsumer;

/**
 * A visitor that includes methods each called in sequence to parse a {@link java.text.SimpleDateFormat} pattern.
 */
public abstract class SimpleDateFormatPatternVisitor extends PatternVisitor {

    final static char ERA = 'G';

    final static char YEAR = 'y';
    final static char WEEK_YEAR = 'Y';

    final static char MONTH_IN_YEAR_CONTEXT_SENSITIVE = 'M';
    final static char MONTH_IN_YEAR_STANDALONE_FORM = 'L';

    final static char WEEK_IN_YEAR = 'w';
    final static char WEEK_IN_MONTH = 'W';

    final static char DAY_IN_YEAR = 'D';
    final static char DAY_IN_MONTH = 'd';
    final static char DAY_OF_WEEK_IN_MONTH = 'F';
    final static char DAY_NAME_IN_WEEK = 'E';
    final static char DAY_NUMBER_OF_WEEK = 'u';

    final static char AMPM = 'a';

    final static char HOUR_IN_DAY_23 = 'H';
    final static char HOUR_IN_DAY_24 = 'k';
    final static char HOUR_IN_AMPM_11 = 'K';
    final static char HOUR_IN_AMPM_12 = 'h';

    final static char MINUTE_OF_HOUR = 'm';
    final static char SECOND_OF_MINUTE = 's';
    final static char MILLISECOND = 'S';

    final static char GENERAL_TIMEZONE = 'z';
    final static char RFC822_TIMEZONE = 'Z';
    final static char ISO8601_TIMEZONE = 'X';

    protected SimpleDateFormatPatternVisitor() {
        super();
    }

    /**
     * <pre>
     * G	Era designator	Text	AD
     * </pre>
     */
    protected void visitEra(final int width) {
    }

    /**
     * <pre>
     * y	Year	Year	1996; 96
     * </pre>
     */
    protected void visitYear(final int width) {
    }

    /**
     * <pre>
     * Y	Week year	Year	2009; 09
     * </pre>
     */
    protected void visitWeekYear(final int width) {
    }

    /**
     * <pre>
     * M	Month in year (context sensitive)	Month	July; Jul; 07
     * </pre>
     */
    protected void visitMonthInYearContextSensitive(final int width,
                                                    final SimpleDateFormatPatternComponentKind kind) {
    }

    /**
     * <pre>
     * L	Month in year (standalone form)	Month	July; Jul; 07
     * </pre>
     */
    protected void visitMonthInYearStandaloneForm(final int width,
                                                  final SimpleDateFormatPatternComponentKind kind) {
    }

    /**
     * <pre>
     * w	Week in year	Number	27
     * </pre>
     */
    protected void visitWeekInYear(final int width) {
    }

    /**
     * <pre>
     * W	Week in month	Number	2
     * </pre>
     */
    protected void visitWeekInMonth(final int width) {
    }

    /**
     * <pre>
     * D	Day in year	Number	189
     * </pre>
     */
    protected void visitDayInYear(final int width) {
    }

    /**
     * <pre>
     * d	Day in month	Number	10
     * </pre>
     */
    protected void visitDayInMonth(final int width) {
    }

    /**
     * <pre>
     * F	Day of week in month	Number	2
     * </pre>
     */
    protected void visitDayOfWeekInMonth(final int width) {
    }

    /**
     * <pre>
     * E	Day name in week	Text	Tuesday; Tue
     * </pre>
     */
    protected void visitDayNameInWeek(final int width) {
    }

    /**
     * <pre>
     * u	Day number of week (1 = Monday, ..., 7 = Sunday)	Number	1
     * </pre>
     */
    protected void visitDayNumberOfWeek(final int width) {
    }

    /**
     * <pre>
     * a	Am/pm marker	Text	PM
     * </pre>
     */
    protected void visitAmPmMarker(final int width) {
    }

    /**
     * <pre>
     * H	Hour in day (0-23)	Number	0
     * </pre>
     */
    protected void visitHourInDay23(final int width) {
    }

    /**
     * <pre>
     * k	Hour in day (1-24)	Number	24
     * </pre>
     */
    protected void visitHourInDay24(final int width) {
    }

    /**
     * <pre>
     * K	Hour in am/pm (0-11)	Number	0
     * </pre>
     */
    protected void visitHourInAmPm11(final int width) {
    }

    /**
     * <pre>
     * h	Hour in am/pm (1-12)	Number	12
     * </pre>
     */
    protected void visitHourInAmPm12(final int width) {
    }

    /**
     * <pre>
     * m	Minute in hour	Number	30
     * </pre>
     */
    protected void visitMinuteInHour(final int width) {
    }

    /**
     * <pre>
     * s	Second in minute	Number	55
     * </pre>
     */
    protected void visitSecondInMinute(final int width) {
    }

    /**
     * <pre>
     * S	Millisecond	Number	978
     * </pre>
     */
    protected void visitMillisecond(final int width) {
    }

    /**
     * <pre>
     * z	Time zone	General time zone	Pacific Standard Time; PST; GMT-08:00
     * </pre>
     */
    protected void visitGeneralTimezone(final int width) {
    }

    /**
     * <pre>
     * Z	Time zone	RFC 822 time zone	-0800
     * </pre>
     */
    protected void visitRfc822Timezone(final int width) {
    }

    final void traverseIso8601Timezone(final int width) {
        switch (width) {
            case 1:
            case 2:
            case 3:
                this.visitIso8601Timezone(width);
                break;
            default:
                this.visitIllegal(ISO8601_TIMEZONE, width);
                break;
        }
    }

    /**
     * <pre>
     * X	Time zone	ISO 8601 time zone	-08; -0800; -08:00
     * </pre>
     */
    protected void visitIso8601Timezone(final int width) {
    }

    // helpers..........................................................................................................

    @Override //
    final int traverseChar(final char c,
                           final String pattern,
                           final int position) {
        return SimpleDateFormatPatternComponent.ofCharacter(c)
                .traverse(pattern,
                        position,
                        this);
    }

    final int traverse(final String pattern,
                       final int position,
                       final IntConsumer dispatcher) {
        return this.traverseRepeating(pattern,
                position,
                dispatcher);
    }

    final int traverseNumber(final String pattern,
                             final int position,
                             final IntConsumer dispatcher) {
        return this.traverseRepeating(pattern,
                position,
                dispatcher);
    }

    /**
     * Finds the repeating character, then calls the visitor method with a width parameter.
     */
    private int traverseRepeating(final String pattern,
                                  final int position,
                                  final IntConsumer dispatcher) {
        final String text = this.repeatingTextRun(position, pattern);
        final int width = text.length();

        if (Visiting.CONTINUE == this.startVisitComponent(position, text)) {
            dispatcher.accept(width);
        }
        this.endVisitComponent(position, text);
        return position + width;
    }

    final int traverseNumberOrText(final String pattern,
                                   final int position,
                                   final BiConsumer<Integer, SimpleDateFormatPatternComponentKind> dispatcher) {
        final String text = this.repeatingTextRun(position, pattern);
        final int width = text.length();

        if (Visiting.CONTINUE == this.startVisitComponent(position, text)) {
            final SimpleDateFormatPatternComponentKind kind;

            switch (width) {
                case 1:
                case 2:
                    kind = SimpleDateFormatPatternComponentKind.NUMBER;
                    break;
                case 3:
                    kind = SimpleDateFormatPatternComponentKind.SHORT_TEXT;
                    break;
                default:
                    kind = SimpleDateFormatPatternComponentKind.FULL_TEXT;
                    break;
            }

            dispatcher.accept(width, kind);
        }
        this.endVisitComponent(position, text);
        return position + width;
    }
}
