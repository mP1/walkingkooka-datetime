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
import walkingkooka.InvalidCharacterException;
import walkingkooka.collect.list.Lists;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.text.CharSequences;
import walkingkooka.visit.Visiting;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class SimpleDateFormatPatternVisitorTest extends SimpleDateFormatPatternVisitorTestCase<SimpleDateFormatPatternVisitor>
        implements SimpleDateFormatPatternVisitorTesting<SimpleDateFormatPatternVisitor> {

    // tests............................................................................................................

    @Test
    public void testEra() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitEra(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'G'
        );
    }

    @Test
    public void testYear() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitYear(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'y'
        );
    }

    @Test
    public void testWeekYear() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitWeekYear(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'Y'
        );
    }

    @Test
    public void testMonthInYearContextSensitive() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitMonthInYearContextSensitive(final int width,
                                                                               final SimpleDateFormatPatternComponentKind kind) {
                                   check(width);
                                   this.add(width, kind);
                               }
                           },
                'M'
        );
    }


    @Test
    public void testMonthInYearStandaloneForm() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitMonthInYearStandaloneForm(final int width,
                                                                             final SimpleDateFormatPatternComponentKind kind) {
                                   checkNumberOrText(width, kind);
                                   this.add(width, kind);
                               }
                           },
                'L'
        );
    }

    @Test
    public void testWeekInYear() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitWeekInYear(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'w'
        );
    }

    @Test
    public void testWeekInMonth() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitWeekInMonth(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'W'
        );
    }

    @Test
    public void testDayInYear() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitDayInYear(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'D'
        );
    }

    @Test
    public void testDayInMonth() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitDayInMonth(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'd'
        );
    }

    @Test
    public void testDayOfWeekInMonth() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitDayOfWeekInMonth(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'F'
        );
    }

    @Test
    public void testDayNameInWeek() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitDayNameInWeek(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'E'
        );
    }

    @Test
    public void testDayNumberOfWeek() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitDayNumberOfWeek(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'u'
        );
    }

    @Test
    public void testAmPmMarker() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitAmPmMarker(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'a'
        );
    }

    @Test
    public void testHourInDay23() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitHourInDay23(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'H'
        );
    }

    @Test
    public void testHourInDay24() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitHourInDay24(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'k'
        );
    }

    @Test
    public void testHourInAmPm11() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitHourInAmPm11(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'K'
        );
    }

    @Test
    public void testHourInAmPm12() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitHourInAmPm12(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'h'
        );
    }

    @Test
    public void testMinuteInHour() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitMinuteInHour(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'm'
        );
    }

    @Test
    public void testSecondInMinute() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitSecondInMinute(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                's'
        );
    }

    @Test
    public void testMillisecond() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitMillisecond(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'S'
        );
    }

    @Test
    public void testGeneralTimezone() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitGeneralTimezone(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'z'
        );
    }

    @Test
    public void testRfc822Timezone() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitRfc822Timezone(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'Z'
        );
    }

    @Test
    public void testIso8601Timezone() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {

                               @Override
                               protected void visitIso8601Timezone(final int width) {
                                   check(width);
                                   this.add(width);
                               }
                           },
                'X'
        );
    }

    @Test
    public void testSimpleDateFormatOfTwoLittleCFails() {
        assertThrows(IllegalArgumentException.class, () -> new SimpleDateFormat("cc"));
    }

    @Test
    public void testSimpleDateFormatOfPatternEscaped() {
        new SimpleDateFormat("'abc \t xyz'");
    }

    @Test
    public void testSimpleDateFormatOfPatternSingleQuoteSingleQuote() {
        new SimpleDateFormat("''");
    }

    @Test
    public void testLiteralSingleQuote() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitLiteral(final String text) {
                                   this.add(text);
                               }
                           },
                "''",
                "s0 '',',e0 ''"
        );
    }

    @Test
    public void testLiteral() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitLiteral(final String text) {
                                   this.add(text);
                               }
                           },
                "'hello'",
                "s0 'hello',hello,e0 'hello'"
        );
    }

    @Test
    public void testLiteralUnescaped() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitLiteral(final String text) {
                                   assertEquals("hello\t", text, "text");
                                   this.add(text);
                               }
                           },
                "'hello\\t'",
                "s0 'hello\\t',hello\t,e0 'hello\\t'"
        );
    }

    @Test
    public void testLiteralSlash() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                               @Override
                               protected void visitLiteral(final String text) {
                                   this.add(text);
                               }
                           },
                "/",
                "s0 /,/,e0 /"
        );
    }

    // symbols become literal...

    @Test
    public void testLettersNeverLiteral() {
        for (int i = 'A'; i <= 'Z'; i++) {
            this.visitAndNeverLiteralCheck((char) i);
        }

        for (int i = 'a'; i <= 'z'; i++) {
            this.visitAndNeverLiteralCheck((char) i);
        }
    }

    private void visitAndNeverLiteralCheck(final char c) {
        final String pattern = String.valueOf(c);
        boolean legal;
        try {
            new SimpleDateFormat(pattern);
            legal = true;
        } catch (final IllegalArgumentException cause) {
            legal = false;
        }

        if (legal) {
            new SimpleDateFormatPatternVisitor() {
                @Override
                protected void visitLiteral(final String component) {
                    throw new UnsupportedOperationException("visitLiteral " + CharSequences.quoteAndEscape(component));
                }
            }.accept(pattern);
        } else {
            visitIllegalAndCheck(pattern);
        }
    }

    @Test
    public void testNonLettersAreLiteral() {
        Loop:
//
        for (int i = 32; i < 127; i++) {
            final char c = (char) i;
            if (Character.isLetter(c)) {
                continue;
            }
            switch (c) {
                case '#':
                case '\'':
                case '[':
                case ']':
                case '{':
                case '}':
                    continue Loop;
            }
            final String pattern = String.valueOf(c);
            new SimpleDateFormat(pattern);
            this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {
                                   @Override
                                   protected void visitLiteral(final String unescapedText) {
                                       this.add(unescapedText);
                                   }
                               },
                    pattern,
                    "s0 " + c + "," + c + ",e0 " + c);
        }
    }

    // multiple components..............................................................................................

    @Test
    public void testDDDLLyyyy() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {

                               @Override
                               protected void visitDayInYear(final int width) {
                                   assertEquals(3, width);
                                   check(width);
                                   this.add(width);
                               }

                               @Override
                               protected void visitMonthInYearStandaloneForm(final int width,
                                                                             final SimpleDateFormatPatternComponentKind kind) {
                                   assertEquals(2, width);
                                   assertEquals(SimpleDateFormatPatternComponentKind.NUMBER, kind);

                                   check(width);
                                   this.add(width);
                               }

                               @Override
                               protected void visitYear(final int width) {
                                   assertEquals(4, width);

                                   check(width);
                                   this.add(width);
                               }
                           },
                "DDDLLyyyy",
                "s0 DDD,3,e0 DDD,s3 LL,2,e3 LL,s5 yyyy,4,e5 yyyy"
        );
    }

    @Test
    public void testLiteralDDDLLyyyy() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {

                               @Override
                               protected void visitLiteral(final String unescapedText) {
                                   this.add(unescapedText);
                               }

                               @Override
                               protected void visitDayInYear(final int width) {
                                   assertEquals(3, width);
                                   check(width);
                                   this.add(width);
                               }

                               @Override
                               protected void visitMonthInYearStandaloneForm(final int width,
                                                                             final SimpleDateFormatPatternComponentKind kind) {
                                   assertEquals(2, width);
                                   assertEquals(SimpleDateFormatPatternComponentKind.NUMBER, kind);

                                   check(width);
                                   this.add(width);
                               }

                               @Override
                               protected void visitYear(final int width) {
                                   assertEquals(4, width);

                                   check(width);
                                   this.add(width);
                               }
                           },
                "'hello' DDDLLyyyy",
                "s0 'hello',hello,e0 'hello',s7  , ,e7  ,s8 DDD,3,e8 DDD,s11 LL,2,e11 LL,s13 yyyy,4,e13 yyyy"
        );
    }

    @Test
    public void testLiteralDDDLLLiteralyyyy() {
        this.visitAndCheck(new TestSimpleDateFormatPatternVisitor() {

                               @Override
                               protected void visitLiteral(final String unescapedText) {
                                   this.add(unescapedText);
                               }

                               @Override
                               protected void visitDayInYear(final int width) {
                                   assertEquals(3, width);
                                   check(width);
                                   this.add(width);
                               }

                               @Override
                               protected void visitMonthInYearStandaloneForm(final int width,
                                                                             final SimpleDateFormatPatternComponentKind kind) {
                                   assertEquals(2, width);
                                   assertEquals(SimpleDateFormatPatternComponentKind.NUMBER, kind);

                                   check(width);
                                   this.add(width);
                               }

                               @Override
                               protected void visitYear(final int width) {
                                   assertEquals(4, width);

                                   check(width);
                                   this.add(width);
                               }
                           },
                "'hello' DDDLLyyyy",
                "s0 'hello',hello,e0 'hello',s7  , ,e7  ,s8 DDD,3,e8 DDD,s11 LL,2,e11 LL,s13 yyyy,4,e13 yyyy"
        );
    }

    // ignored..........................................................................................................

    @Override
    public void testIfClassIsFinalIfAllConstructorsArePrivate() {
    }

    @Override
    public void testAllConstructorsVisibility() {
    }

    // helper...........................................................................................................

    private void visitAndCheck(final TestSimpleDateFormatPatternVisitor visitor,
                               final char c) {
        for (int width = 1; width < 16; width++) {
            final String pattern = pattern(c, width);

            boolean legal;
            try {
                new SimpleDateFormat(pattern);
                legal = true;
            } catch (final IllegalArgumentException cause) {
                legal = false;
            }
            if (legal) {
                this.visitAndCheck(visitor,
                        pattern,
                        "s0 " + pattern + "," + width + ",e0 " + pattern);
            } else {
                this.visitIllegalAndCheck(pattern);
            }
        }
    }

    private String pattern(final char c,
                           final int width) {
        return CharSequences.repeating(c, width).toString();
    }

    private void visitAndCheck(final TestSimpleDateFormatPatternVisitor visitor,
                               final String pattern,
                               final String expected) {
        try {
            new SimpleDateFormat(pattern);
        } catch (final IllegalArgumentException cause) {
            throw new AssertionError("Pattern " + CharSequences.quoteAndEscape(pattern), cause);
        }
        visitor.acceptAndCheck(pattern, expected);

        new SimpleDateFormatPatternVisitor() {
        }.accept(pattern);
    }

    private void visitIllegalAndCheck(final String pattern) {
        assertThrows(IllegalArgumentException.class, () -> new SimpleDateFormat(pattern));
        new TestSimpleDateFormatPatternVisitor() {
            @Override
            protected void visitIllegal(final String p) {
                assertEquals(pattern, p, () -> "character, pattern: " + CharSequences.quoteAndEscape(pattern));

                this.add("illegal " + p);
            }
        }.acceptAndCheck(pattern, "s0 " + pattern + ",illegal " + pattern + ",e0 " + pattern);

        new SimpleDateFormatPatternVisitor() {
        }.accept(pattern);
    }

    private static void check(final int width) {
        assertNotEquals(0, width, "width");
    }

    private static void checkNumberOrText(final int width,
                                          final SimpleDateFormatPatternComponentKind kind) {
        check(width);
        assertNotEquals(null, kind, "kind");

        SimpleDateFormatPatternComponentKind expected;

        switch (width) {
            case 1:
            case 2:
                expected = SimpleDateFormatPatternComponentKind.NUMBER;
                break;
            case 3:
                expected = SimpleDateFormatPatternComponentKind.SHORT_TEXT;
                break;
            default:
                expected = SimpleDateFormatPatternComponentKind.FULL_TEXT;
                break;
        }
        assertEquals(expected, kind, "incorrect kind for " + width);
    }

    abstract static class TestSimpleDateFormatPatternVisitor extends FakeSimpleDateFormatPatternVisitor {

        void acceptAndCheck(final String pattern, final String expected) {
            this.visited.clear();
            this.accept(pattern);
            this.checkVisited(pattern, expected);
        }

        @Override
        protected final Visiting startVisitComponent(final int position, final String text) {
            this.position = position;
            this.text = text;

            this.add("s" + position + " " + text);

            return Visiting.CONTINUE;
        }

        @Override
        protected final void endVisitComponent(final int position, final String text) {
            assertEquals(this.position, position, "position doesnt match startVisitComponent parameter");
            assertEquals(this.text, text, "text doesnt match startVisitComponent parameter");

            this.position = -1;
            this.text = null;

            this.add("e" + position + " " + text);
        }

        @Override
        protected void visitIllegal(final String component) {
            throw new InvalidCharacterException(component, this.position);
        }

        final void add(final int width) {
            this.add(String.valueOf(width));
        }

        final void add(final int width,
                       final SimpleDateFormatPatternComponentKind kind) {
            this.add(width);
        }

        final void add(final String visit) {
            assertNotEquals("", visit);
            this.visited.add(visit);
        }

        private final List<String> visited = Lists.array();
        private int position;
        private String text;

        final void checkVisited(final String pattern,
                                final String expected) {
            assertEquals(expected,
                    String.join(",", this.visited),
                    () -> "Pattern " + CharSequences.quoteAndEscape(pattern));
        }
    }

    // skipped..........................................................................................................

    @Override
    public void testCheckToStringOverridden() {
    }

    // SimpleDateFormatPatternVisitorTesting...........................................................................

    @Override
    public SimpleDateFormatPatternVisitor createVisitor() {
        return new SimpleDateFormatPatternVisitor() {
        };
    }

    @Override
    public Class<SimpleDateFormatPatternVisitor> type() {
        return SimpleDateFormatPatternVisitor.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
