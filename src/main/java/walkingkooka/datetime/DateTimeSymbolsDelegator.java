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

import java.util.List;

/**
 * Delegate methods for all {@link DateTimeSymbols} property getters.
 */
public interface DateTimeSymbolsDelegator extends DateTimeSymbolsLike {

    @Override
    default List<String> ampms() {
        return this.dateTimeSymbols()
                .ampms();
    }

    /**
     * Returns all the month names in long form.
     */
    @Override
    default List<String> monthNames() {
        return this.dateTimeSymbols()
                .monthNames();
    }

    /**
     * Returns all the month names in short form.
     */
    @Override
    default List<String> monthNameAbbreviations() {
        return this.dateTimeSymbols()
                .monthNameAbbreviations();
    }

    /**
     * Returns all the week day names in long form.
     */
    @Override
    default List<String> weekDayNames() {
        return this.dateTimeSymbols()
                .weekDayNames();
    }

    /**
     * Returns all the week day names in short form.
     */
    @Override
    default List<String> weekDayNameAbbreviations() {
        return this.dateTimeSymbols().weekDayNameAbbreviations();
    }

    DateTimeSymbols dateTimeSymbols();
}
