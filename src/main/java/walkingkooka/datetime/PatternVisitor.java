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

import walkingkooka.text.CharSequences;
import walkingkooka.visit.Visiting;
import walkingkooka.visit.Visitor;

import java.util.Objects;

/**
 * A {@link Visitor} with common methods shared by {@link DateTimeFormatterPatternVisitor} and {@link SimpleDateFormatPatternVisitor}.
 */
abstract class PatternVisitor extends Visitor<String> {

    protected PatternVisitor() {
        super();
    }

    /**
     * Called before each component visit method and contains the text and position for the first character.
     */
    protected Visiting startVisitComponent(final int position,
                                           final String text) {
        return Visiting.CONTINUE;
    }

    protected void endVisitComponent(final int position,
                                     final String text) {
    }

    // visitIllegal.....................................................................................................

    /**
     * Eventually calls {@link #visitIllegal(String)}
     */
    final int traverseIllegal(final String pattern,
                              final int position) {
        final String text = this.repeatingTextRun(position, pattern);
        if (Visiting.CONTINUE == this.startVisitComponent(position, text)) {
            this.visitIllegal(text);
        }
        this.endVisitComponent(position, text);
        return position + text.length();
    }

    final void visitIllegal(final char c,
                            final int width) {
        this.visitIllegal(CharSequences.repeating(c, width).toString());
    }

    /**
     * Called with any illegal component.
     */
    protected void visitIllegal(final String component) {
    }

    // visitLiteral.....................................................................................................

    final static char ESCAPE = '\'';

    /**
     * <pre>
     * '       escape for text             delimiter
     * ''      single quote                literal
     * </pre>
     */
    final int traverseEscaped(final String pattern,
                              final int position) {
        final int length = pattern.length();

        int end = position + 1;
        boolean escape = false;

        while (end < length) {
            final char c = pattern.charAt(end);
            end++;

            if (escape) {
                escape = false;
                continue;
            }
            if ('\\' == c) {
                escape = true;
                continue;
            }
            if (DateTimeFormatterPatternVisitor.ESCAPE == c) {
                break;
            }
        }

        final String escaped = pattern.substring(position, end);
        if (Visiting.CONTINUE == this.startVisitComponent(position, escaped)) {
            this.visitLiteral(escaped.length() == 2 ?
                ESCAPE_STRING :
                CharSequences.unescape(pattern.substring(position + 1, end - 1)).toString()
            );
        }
        this.endVisitComponent(position, escaped);
        return end;
    }

    private final static String ESCAPE_STRING = "" + ESCAPE;

    /**
     * Eventually calls {@link #visitIllegal(String)}
     */
    final int traverseLiteral(final String pattern,
                              final int position) {
        final String text = this.repeatingTextRun(position, pattern);
        if (Visiting.CONTINUE == this.startVisitComponent(position, text)) {
            this.visitLiteral(text);
        }
        this.endVisitComponent(position, text);
        return position + text.length();
    }

    protected void visitLiteral(final String text) {
    }

    // helper...........................................................................................................

    final String repeatingTextRun(final int position,
                                  final String pattern) {
        final int length = pattern.length();
        final char c = pattern.charAt(position);

        int end = position + 1;
        while (end < length) {
            if (c != pattern.charAt(end)) {
                break;
            }
            end++;
        }
        return pattern.substring(position, end);
    }

    // Visitor..........................................................................................................

    /**
     * Accepts a pattern and calls visit methods for each of its components.
     */
    @Override
    public void accept(final String pattern) {
        Objects.requireNonNull(pattern, "pattern");

        int i = 0;
        final int patternLength = pattern.length();

        while (i < patternLength) {
            i = this.traverseChar(pattern.charAt(i),
                pattern,
                i);
        }
    }

    abstract int traverseChar(final char c,
                              final String pattern,
                              final int position);
}
