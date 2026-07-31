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
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

public final class HasLastModifiedTestingTest implements HasLastModifiedTesting,
    ClassTesting<HasLastModified> {

    @Test
    public void testLastModifiedAndCheck() {
        this.lastModifiedAndCheck(
            () -> OPTIONAL_LAST_MODIFIED,
            LAST_MODIFIED
        );
    }

    @Test
    public void testLastModifiedNotEqualDifferentLastModified() {
        this.checkNotEquals(
            LAST_MODIFIED,
            DIFFERENT_LAST_MODIFIED
        );
    }

    // class............................................................................................................

    @Override
    public Class<HasLastModified> type() {
        return HasLastModified.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }

    @Override
    public void testTestNaming() {
        throw new UnsupportedOperationException();
    }
}
