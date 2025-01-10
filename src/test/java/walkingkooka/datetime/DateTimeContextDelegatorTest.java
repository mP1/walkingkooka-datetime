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

import walkingkooka.datetime.DateTimeContextDelegatorTest.TestDateTimeContextDelegator;

import java.time.LocalDateTime;
import java.util.Locale;

public final class DateTimeContextDelegatorTest implements DateTimeContextTesting2<TestDateTimeContextDelegator> {

    @Override
    public void testTypeNaming() {
        throw new UnsupportedOperationException();
    }

    @Override
    public TestDateTimeContextDelegator createContext() {
        return new TestDateTimeContextDelegator();
    }

    // class............................................................................................................

    @Override
    public Class<TestDateTimeContextDelegator> type() {
        return TestDateTimeContextDelegator.class;
    }

    static class TestDateTimeContextDelegator implements DateTimeContextDelegator {

        @Override
        public DateTimeContext dateTimeContext() {
            return DateTimeContexts.locale(
                    Locale.forLanguageTag("EN-AU"),
                    1950, // defaultYear
                    50, // twoDigitYear
                    LocalDateTime::now
            );
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }
}
