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

import walkingkooka.collect.list.ImmutableListDefaults;
import walkingkooka.collect.list.Lists;

import java.time.LocalDate;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * An immutable list of {@link LocalDate}, which allows null elements.
 */
public final class LocalDateList extends AbstractList<LocalDate>
    implements ImmutableListDefaults<LocalDateList, LocalDate> {

    /**
     * An empty {@link LocalDateList}.
     */
    public final static LocalDateList EMPTY = new LocalDateList(
        Lists.empty()
    );

    /**
     * Factory that creates a {@link LocalDateList} from the list of {@link LocalDate dates}.
     */
    public static LocalDateList with(final List<LocalDate> dates) {
        Objects.requireNonNull(dates, "dates");

        LocalDateList list;

        if (dates instanceof LocalDateList) {
            list = (LocalDateList) dates;
        } else {
            final List<LocalDate> copy = Lists.array();
            copy.addAll(dates);

            switch (dates.size()) {
                case 0:
                    list = EMPTY;
                    break;
                default:
                    list = new LocalDateList(copy);
                    break;
            }
        }

        return list;
    }

    private LocalDateList(final List<LocalDate> dates) {
        this.dates = dates;
    }

    @Override
    public LocalDate get(int index) {
        return this.dates.get(index);
    }

    @Override
    public int size() {
        return this.dates.size();
    }

    private final List<LocalDate> dates;

    @Override
    public void elementCheck(final LocalDate date) {
        // allow null
    }

    @Override
    public LocalDateList setElements(final List<LocalDate> dates) {
        final LocalDateList copy = with(dates);
        return this.equals(copy) ?
            this :
            copy;
    }
}
