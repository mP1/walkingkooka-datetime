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

import walkingkooka.Context;
import walkingkooka.locale.HasLocale;

import java.util.List;

/**
 * Context for working with years.
 */
public interface YearContext extends Context {

    /**
     * Provides the default year useful for parsing operations where the year is missing.
     */
    int defaultYear();

    /**
     * Returns a two digit value, values under should be 2000 years, while those under should be 1900s.
     */
    int twoDigitYear();

    /**
     * Accepts a two digit year, and using {@link #twoDigitYear()} returns a four digit yar.
     */
    default int twoToFourDigitYear(final int year) {
        if(year < 0 || year >= 100) {
            throw new IllegalArgumentException("Invalid two digit year " + year + " expected between 0 and 100");
        }
        return year +
                (year < this.twoDigitYear() ?
                        2000 :
                        1900);
    }
}
