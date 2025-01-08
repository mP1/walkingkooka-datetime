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

import walkingkooka.InvalidCharacterException;
import walkingkooka.visit.Visiting;

/**
 * Accepts a {@link java.text.SimpleDateFormat} pattern returning the pattern without any timezone placeholders in the format pattern.
 */
final class DateTimeSimpleDateFormatPatternWithoutTimeZoneSimpleDateFormatPatternVisitor extends SimpleDateFormatPatternVisitor {

    static String removeTimeZonePatternComponents(final String pattern) {
        final DateTimeSimpleDateFormatPatternWithoutTimeZoneSimpleDateFormatPatternVisitor visitor = new DateTimeSimpleDateFormatPatternWithoutTimeZoneSimpleDateFormatPatternVisitor(pattern);
        visitor.accept(pattern);
        return visitor.filteredPattern.toString();
    }

    DateTimeSimpleDateFormatPatternWithoutTimeZoneSimpleDateFormatPatternVisitor(final String pattern) {
        super();
        this.pattern = pattern;
    }

    @Override
    protected Visiting startVisitComponent(final int position,
                                           final String text) {
        this.keep = true;
        this.position = position;
        return Visiting.CONTINUE;
    }

    @Override
    protected void endVisitComponent(final int position,
                                     final String text) {
        if (this.keep) {
            this.filteredPattern.append(text);
        }
    }

    /**
     * Aggregates the pattern components.
     */
    private final StringBuilder filteredPattern = new StringBuilder();

    @Override
    protected void visitGeneralTimezone(final int width) {
        this.keep = false;
    }

    @Override
    protected void visitRfc822Timezone(final int width) {
        this.keep = false;
    }

    @Override
    protected void visitIso8601Timezone(final int width) {
        this.keep = false;
    }

    /**
     * Non timezone visit methods will set this flag to true which means will result in the pattern component being recorded.
     */
    private boolean keep;

    @Override
    protected void visitIllegal(final String component) {
        throw new InvalidCharacterException(this.pattern, this.position);
    }

    private final String pattern;

    /**
     * Used to track the current position of the component being visited, useful for building a {@link InvalidCharacterException}.
     */
    private int position;

    @Override
    public String toString() {
        return this.filteredPattern.toString();
    }
}
