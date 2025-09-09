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
 * An immutable list of {@link LocalDate}.
 */
public final class DateList extends AbstractList<LocalDate>
    implements ImmutableListDefaults<DateList, LocalDate> {

    /**
     * An empty {@link DateList}.
     */
    public final static DateList EMPTY = new DateList(
        Lists.empty()
    );

    /**
     * Factory that creates a {@link DateList} from the list of {@link LocalDate dates}.
     */
    public static DateList with(final List<LocalDate> dates) {
        Objects.requireNonNull(dates, "dates");

        DateList DateList;

        if (dates instanceof DateList) {
            DateList = (DateList) dates;
        } else {
            final List<LocalDate> copy = Lists.array();
            for (final LocalDate name : dates) {
                copy.add(
                    Objects.requireNonNull(name, "includes null " + LocalDate.class.getSimpleName())
                );
            }

            switch (dates.size()) {
                case 0:
                    DateList = EMPTY;
                    break;
                default:
                    DateList = new DateList(copy);
                    break;
            }
        }

        return DateList;
    }

    private DateList(final List<LocalDate> dates) {
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
    public void elementCheck(final LocalDate dates) {
        Objects.requireNonNull(dates, "dates");
    }

    @Override
    public DateList setElements(final List<LocalDate> dates) {
        final DateList copy = with(dates);
        return this.equals(copy) ?
            this :
            copy;
    }
}
