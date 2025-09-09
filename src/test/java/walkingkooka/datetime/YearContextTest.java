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
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class YearContextTest implements ClassTesting2<YearContext> {

    @Test
    public void testTwoToFourDigitYearNegativeYearFails() {
        assertThrows(IllegalArgumentException.class, () -> new TestYearContext().twoToFourDigitYear(-1));
    }

    @Test
    public void testTwoToFourDigitYearInvalidYearFails() {
        assertThrows(IllegalArgumentException.class, () -> new TestYearContext().twoToFourDigitYear(100));
    }

    @Test
    public void testTwoToFourDigitYearEqual() {
        this.twoToFourDigitYearAndCheck(20, 1920);
    }

    @Test
    public void testTwoToFourDigitYearLess() {
        this.twoToFourDigitYearAndCheck(19, 2019);
    }

    @Test
    public void testTwoToFourDigitYearLess2() {
        this.twoToFourDigitYearAndCheck(1, 2001);
    }

    @Test
    public void testTwoToFourDigitYearLess3() {
        this.twoToFourDigitYearAndCheck(0, 2000);
    }

    @Test
    public void testTwoToFourDigitYearGreater() {
        this.twoToFourDigitYearAndCheck(21, 1921);
    }

    @Test
    public void testTwoToFourDigitYearGreater2() {
        this.twoToFourDigitYearAndCheck(31, 1931);
    }

    @Test
    public void testTwoToFourDigitYearGreater3() {
        this.twoToFourDigitYearAndCheck(99, 1999);
    }

    private void twoToFourDigitYearAndCheck(final int two, final int four) {
        this.checkEquals(
            four,
            new TestYearContext().twoToFourDigitYear(two),
            () -> "twoToFourDigitYear " + two
        );
    }

    static class TestYearContext implements YearContext {

        @Override
        public int defaultYear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int twoDigitYear() {
            return 20;
        }
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<YearContext> type() {
        return YearContext.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
