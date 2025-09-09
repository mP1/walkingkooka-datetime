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

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateListTest implements ListTesting2<DateList, LocalDate>,
    ClassTesting<DateList>,
    ImmutableListTesting<DateList, LocalDate> {

    private final static LocalDate DATE1 = LocalDate.of(
        1999,
        12,
        31
    );

    private final static LocalDate DATE2 = LocalDate.of(
        2000,
        2,
        1
    );

    @Test
    public void testWithNullFails() {
        assertThrows(
            NullPointerException.class,
            () -> DateList.with(null)
        );
    }

    @Test
    public void testWithDoesntDoubleWrap() {
        final DateList list = this.createList();
        assertSame(
            list,
            DateList.with(list)
        );
    }

    @Test
    public void testWithEmpty() {
        assertSame(
            DateList.EMPTY,
            DateList.with(
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
            DATE1 // expected
        );
    }

    @Test
    public void testGet2() {
        this.getAndCheck(
            this.createList(),
            1, // index
            DATE2 // expected
        );
    }

    @Test
    public void testSetFails() {
        this.setFails(
            this.createList(),
            0, // index
            DATE1 // expected
        );
    }

    @Test
    public void testRemoveIndexFails() {
        final DateList list = this.createList();

        this.removeIndexFails(
            list,
            0
        );
    }

    @Test
    public void testRemoveElementFails() {
        final DateList list = this.createList();

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
                        DATE1,
                        null
                    )
                )
        );
        this.checkEquals(
            "includes null LocalDate",
            thrown.getMessage()
        );
    }

    @Override
    public DateList createList() {
        return DateList.with(
            Lists.of(
                DATE1,
                DATE2
            )
        );
    }

    // class............................................................................................................

    @Override
    public Class<DateList> type() {
        return DateList.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
