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

/**
 * An enum exists for each unique {@link java.text.SimpleDateFormat} component pattern/letter
 */
enum SimpleDateFormatPatternComponent {

    ERA {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitEra);
        }
    },
    YEAR {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitYear);
        }
    },
    WEEK_YEAR {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitWeekYear);
        }
    },
    MONTH_IN_YEAR_CONTEXT_SENSITIVE {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverseNumberOrText(pattern,
                    position,
                    visitor::visitMonthInYearContextSensitive);
        }
    },

    MONTH_IN_YEAR_STANDALONE_FORM {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverseNumberOrText(pattern,
                    position,
                    visitor::visitMonthInYearStandaloneForm);
        }
    },

    WEEK_IN_YEAR {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitWeekInYear);
        }
    },

    WEEK_IN_MONTH {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitWeekInMonth);
        }
    },

    DAY_IN_YEAR {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitDayInYear);
        }
    },

    DAY_IN_MONTH {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitDayInMonth);
        }
    },

    DAY_OF_WEEK_IN_MONTH {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitDayOfWeekInMonth);
        }
    },

    DAY_NAME_IN_WEEK {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitDayNameInWeek);
        }
    },

    DAY_NUMBER_OF_WEEK {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitDayNumberOfWeek);
        }
    },

    AMPM {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitAmPmMarker);
        }
    },

    HOUR_IN_DAY_23 {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitHourInDay23);
        }
    },

    HOUR_IN_DAY_24 {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitHourInDay24);
        }
    },

    HOUR_IN_AMPM_11 {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitHourInAmPm11);
        }
    },

    HOUR_IN_AMPM_12 {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitHourInAmPm12);
        }
    },

    MINUTE_OF_HOUR {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverseNumber(pattern,
                    position,
                    visitor::visitMinuteInHour);
        }
    },
    SECOND_OF_MINUTE {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverseNumber(pattern,
                    position,
                    visitor::visitSecondInMinute);
        }
    },
    MILLISECOND {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverseNumber(pattern,
                    position,
                    visitor::visitMillisecond);
        }
    },
    GENERAL_TIMEZONE {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitGeneralTimezone);
        }
    },
    RFC822_TIMEZONE {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::visitRfc822Timezone);
        }
    },
    ISO8601_TIMEZONE {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverse(pattern,
                    position,
                    visitor::traverseIso8601Timezone);
        }
    },
    ESCAPE {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverseEscaped(pattern, position);
        }
    },
    ILLEGAL {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverseIllegal(pattern, position);
        }
    },
    LITERAL {
        @Override
        int traverse(final String pattern,
                     final int position,
                     final SimpleDateFormatPatternVisitor visitor) {
            return visitor.traverseLiteral(pattern, position);
        }
    };

    abstract int traverse(final String pattern,
                          final int position,
                          final SimpleDateFormatPatternVisitor visitor);

    // factory..........................................................................................................

    /**
     * Returns the {@link SimpleDateFormatPatternComponent} for the given character.
     */
    static SimpleDateFormatPatternComponent ofCharacter(final char c) {
        SimpleDateFormatPatternComponent component;

        switch (c) {
            case SimpleDateFormatPatternVisitor.ERA:
                component = ERA;
                break;
            case SimpleDateFormatPatternVisitor.YEAR:
                component = YEAR;
                break;
            case SimpleDateFormatPatternVisitor.WEEK_YEAR:
                component = WEEK_YEAR;
                break;
            case SimpleDateFormatPatternVisitor.MONTH_IN_YEAR_CONTEXT_SENSITIVE:
                component = MONTH_IN_YEAR_CONTEXT_SENSITIVE;
                break;
            case SimpleDateFormatPatternVisitor.MONTH_IN_YEAR_STANDALONE_FORM:
                component = MONTH_IN_YEAR_STANDALONE_FORM;
                break;
            case SimpleDateFormatPatternVisitor.WEEK_IN_YEAR:
                component = WEEK_IN_YEAR;
                break;
            case SimpleDateFormatPatternVisitor.WEEK_IN_MONTH:
                component = WEEK_IN_MONTH;
                break;
            case SimpleDateFormatPatternVisitor.DAY_IN_YEAR:
                component = DAY_IN_YEAR;
                break;
            case SimpleDateFormatPatternVisitor.DAY_IN_MONTH:
                component = DAY_IN_MONTH;
                break;
            case SimpleDateFormatPatternVisitor.DAY_OF_WEEK_IN_MONTH:
                component = DAY_OF_WEEK_IN_MONTH;
                break;
            case SimpleDateFormatPatternVisitor.DAY_NAME_IN_WEEK:
                component = DAY_NAME_IN_WEEK;
                break;
            case SimpleDateFormatPatternVisitor.DAY_NUMBER_OF_WEEK:
                component = DAY_NUMBER_OF_WEEK;
                break;
            case SimpleDateFormatPatternVisitor.AMPM:
                component = AMPM;
                break;
            case SimpleDateFormatPatternVisitor.HOUR_IN_DAY_23:
                component = HOUR_IN_DAY_23;
                break;
            case SimpleDateFormatPatternVisitor.HOUR_IN_DAY_24:
                component = HOUR_IN_DAY_24;
                break;
            case SimpleDateFormatPatternVisitor.HOUR_IN_AMPM_11:
                component = HOUR_IN_AMPM_11;
                break;
            case SimpleDateFormatPatternVisitor.HOUR_IN_AMPM_12:
                component = HOUR_IN_AMPM_12;
                break;
            case SimpleDateFormatPatternVisitor.MINUTE_OF_HOUR:
                component = MINUTE_OF_HOUR;
                break;
            case SimpleDateFormatPatternVisitor.SECOND_OF_MINUTE:
                component = SECOND_OF_MINUTE;
                break;
            case SimpleDateFormatPatternVisitor.MILLISECOND:
                component = MILLISECOND;
                break;
            case SimpleDateFormatPatternVisitor.GENERAL_TIMEZONE:
                component = GENERAL_TIMEZONE;
                break;
            case SimpleDateFormatPatternVisitor.RFC822_TIMEZONE:
                component = RFC822_TIMEZONE;
                break;
            case SimpleDateFormatPatternVisitor.ISO8601_TIMEZONE:
                component = ISO8601_TIMEZONE;
                break;
            case SimpleDateFormatPatternVisitor.ESCAPE:
                component = ESCAPE;
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'I':
            case 'J':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'V':
            case 'b':
            case 'c':
            case 'e':
            case 'f':
            case 'g':
            case 'i':
            case 'j':
            case 'l':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 't':
            case 'v':
            case 'x':
                component = ILLEGAL;
                break;
            default:
                component = LITERAL;
                break;
        }

        return component;
    }
}
