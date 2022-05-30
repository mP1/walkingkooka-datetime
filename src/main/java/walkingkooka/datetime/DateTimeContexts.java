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

import walkingkooka.reflect.PublicStaticHelper;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.function.Supplier;

/**
 * A collection of factory methods to create {@link DateTimeContext}.
 */
public final class DateTimeContexts implements PublicStaticHelper {

    /**
     * {@see LocaleDateTimeContext}
     */
    public static DateTimeContext locale(final Locale locale,
                                         final int defaultYear,
                                         final int twoDigitYear,
                                         final Supplier<LocalDateTime> now) {
        return LocaleDateTimeContext.with(
                locale,
                defaultYear,
                twoDigitYear,
                now
        );
    }

    /**
     * {@see FakeDateTimeContext}
     */
    public static DateTimeContext fake() {
        return new FakeDateTimeContext();
    }

    /**
     * Stop creation.
     */
    private DateTimeContexts() {
        throw new UnsupportedOperationException();
    }
}
