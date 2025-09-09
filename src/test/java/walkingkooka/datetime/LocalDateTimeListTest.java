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

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalDateTimeListTest implements ListTesting2<LocalDateTimeList, LocalDateTime>,
    ClassTesting<LocalDateTimeList>,
    ImmutableListTesting<LocalDateTimeList, LocalDateTime> {

    private final static LocalDateTime DATE_TIME1 = LocalDateTime.of(
        1999,
        12,
        31,
        12,
        58,
        59
    );

    private final static LocalDateTime DATE_TIME2 = LocalDateTime.of(
        2000,
        2,
        1,
        12,
        58,
        59
    );

    @Test
    public void testWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> LocalDateTimeList.with(null)
        );
    }

    @Test
    public void testWithDoesntDoubleWrap() {
        final LocalDateTimeList list = this.createList();
        assertSame(
            list,
            LocalDateTimeList.with(list)
        );
    }

    @Test
    public void testWithEmpty() {
        assertSame(
            LocalDateTimeList.EMPTY,
            LocalDateTimeList.with(
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
            DATE_TIME1 // expected
        );
    }

    @Test
    public void testGet2() {
        this.getAndCheck(
            this.createList(),
            1, // index
            DATE_TIME2 // expected
        );
    }

    @Test
    public void testSetFails() {
        this.setFails(
            this.createList(),
            0, // index
            DATE_TIME1 // expected
        );
    }

    @Test
    public void testRemoveIndexFails() {
        final LocalDateTimeList list = this.createList();

        this.removeIndexFails(
            list,
            0
        );
    }

    @Test
    public void testRemoveElementFails() {
        final LocalDateTimeList list = this.createList();

        this.removeFails(
            list,
            list.get(0)
        );
    }

    @Test
    public void testSetElementsIncludesNullFails() {
        final NullPointerException thrown = assertThrows(
            NullPointerException.class,
            () -> this.createList()
                .setElements(
                    Lists.of(
                        DATE_TIME1,
                        null
                    )
                )
        );
        this.checkEquals(
            "includes null LocalDateTime",
            thrown.getMessage()
        );
    }

    @Override
    public LocalDateTimeList createList() {
        return LocalDateTimeList.with(
            Lists.of(
                DATE_TIME1,
                DATE_TIME2
            )
        );
    }

    // class............................................................................................................

    @Override
    public Class<LocalDateTimeList> type() {
        return LocalDateTimeList.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
