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

public class LocalDateListTest implements ListTesting2<LocalDateList, LocalDate>,
    ClassTesting<LocalDateList>,
    ImmutableListTesting<LocalDateList, LocalDate> {

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
        final LocalDateList list = this.createList();

        this.removeIndexFails(
            list,
            0
        );
    }

    @Test
    public void testRemoveElementFails() {
        final LocalDateList list = this.createList();

        this.removeFails(
            list,
            list.get(0)
        );
    }

    @Test
    public void testReplaceWithNull() {
        final LocalDateList numbers = this.createList();

        this.replaceAndCheck(
            numbers,
            1,
            null,
            new LocalDateList(
                Lists.of(
                    DATE1,
                    null
                )
            )
        );
    }

    // setElements......................................................................................................

    @Test
    public void testWithDoesntDoubleWrap() {
        final LocalDateList list = this.createList();
        assertSame(
            list,
            list.setElements(list)
        );
    }

    @Test
    public void testSetElementsWithEmpty() {
        assertSame(
            LocalDateList.EMPTY,
            new LocalDateList(
                Lists.of(
                    DATE1,
                    DATE2
                )
            ).setElements(Lists.empty())
        );
    }

    @Override
    public LocalDateList createList() {
        return new LocalDateList(
            Lists.of(
                DATE1,
                DATE2
            )
        );
    }

    // class............................................................................................................

    @Override
    public Class<LocalDateList> type() {
        return LocalDateList.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
