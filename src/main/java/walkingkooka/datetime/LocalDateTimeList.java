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

import java.time.LocalDateTime;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * An immutable list of {@link LocalDateTime}, which allow null elements
 */
public final class LocalDateTimeList extends AbstractList<LocalDateTime>
    implements ImmutableListDefaults<LocalDateTimeList, LocalDateTime> {

    /**
     * An empty {@link LocalDateTimeList}.
     */
    public final static LocalDateTimeList EMPTY = new LocalDateTimeList(
        Lists.empty()
    );

    /**
     * Factory that creates a {@link LocalDateTimeList} from the list of {@link LocalDateTime dateTimes}.
     */
    public static LocalDateTimeList with(final List<LocalDateTime> dateTimes) {
        Objects.requireNonNull(dateTimes, "dateTimes");

        LocalDateTimeList dateTimeList;

        if (dateTimes instanceof LocalDateTimeList) {
            dateTimeList = (LocalDateTimeList) dateTimes;
        } else {
            final List<LocalDateTime> copy = Lists.array();
            copy.addAll(dateTimes);

            switch (dateTimes.size()) {
                case 0:
                    dateTimeList = EMPTY;
                    break;
                default:
                    dateTimeList = new LocalDateTimeList(copy);
                    break;
            }
        }

        return dateTimeList;
    }

    private LocalDateTimeList(final List<LocalDateTime> dateTimes) {
        this.dateTimes = dateTimes;
    }

    @Override
    public LocalDateTime get(int index) {
        return this.dateTimes.get(index);
    }

    @Override
    public int size() {
        return this.dateTimes.size();
    }

    private final List<LocalDateTime> dateTimes;

    @Override
    public void elementCheck(final LocalDateTime dateTime) {
        // allow nulls
    }

    @Override
    public LocalDateTimeList setElements(final List<LocalDateTime> dateTimes) {
        final LocalDateTimeList copy = with(dateTimes);
        return this.equals(copy) ?
            this :
            copy;
    }
}
