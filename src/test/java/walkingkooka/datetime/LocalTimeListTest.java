/*
 * Copyright 2025 Miroslav Pokorny (github.com/mP1)
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
import walkingkooka.collect.list.ImmutableListTesting;
import walkingkooka.collect.list.ListTesting2;
import walkingkooka.collect.list.Lists;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalTimeListTest implements ListTesting2<LocalTimeList, LocalTime>,
    ClassTesting<LocalTimeList>,
    ImmutableListTesting<LocalTimeList, LocalTime> {

    private final static LocalTime TIME1 = LocalTime.of(
        1,
        11,
        59
    );

    private final static LocalTime TIME2 = LocalTime.of(
        2,
        22,
        59
    );

    @Test
    public void testWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> LocalTimeList.with(null)
        );
    }

    @Test
    public void testWithDoesntDoubleWrap() {
        final LocalTimeList list = this.createList();
        assertSame(
            list,
            LocalTimeList.with(list)
        );
    }

    @Test
    public void testWithEmpty() {
        assertSame(
            LocalTimeList.EMPTY,
            LocalTimeList.with(
                Lists.empty()
            )
        );
    }

    // list.............................................................................................................

    @Test
    public void testGet() {
        this.getAndCheck(
            this.createList(),
            0, // index
            TIME1 // expected
        );
    }

    @Test
    public void testGet2() {
        this.getAndCheck(
            this.createList(),
            1, // index
            TIME2 // expected
        );
    }

    @Test
    public void testSetFails() {
        this.setFails(
            this.createList(),
            0, // index
            TIME1 // expected
        );
    }

    @Test
    public void testRemoveIndexFails() {
        final LocalTimeList list = this.createList();

        this.removeIndexFails(
            list,
            0
        );
    }

    @Test
    public void testRemoveElementFails() {
        final LocalTimeList list = this.createList();

        this.removeFails(
            list,
            list.get(0)
        );
    }

    @Test
    public void testReplaceWithNull() {
        final LocalTimeList numbers = this.createList();

        this.replaceAndCheck(
            numbers,
            1,
            null,
            LocalTimeList.with(
                Lists.of(
                    TIME1,
                    null
                )
            )
        );
    }

    @Override
    public LocalTimeList createList() {
        return LocalTimeList.with(
            Lists.of(
                TIME1,
                TIME2
            )
        );
    }

    // class............................................................................................................

    @Override
    public Class<LocalTimeList> type() {
        return LocalTimeList.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
