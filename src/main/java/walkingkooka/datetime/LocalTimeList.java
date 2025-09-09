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

import java.time.LocalTime;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * An immutable list of {@link LocalTime}.
 */
public final class LocalTimeList extends AbstractList<LocalTime>
    implements ImmutableListDefaults<LocalTimeList, LocalTime> {

    /**
     * An empty {@link LocalTimeList}.
     */
    public final static LocalTimeList EMPTY = new LocalTimeList(
        Lists.empty()
    );

    /**
     * Factory that creates a {@link LocalTimeList} from the list of {@link LocalTime times}.
     */
    public static LocalTimeList with(final List<LocalTime> times) {
        Objects.requireNonNull(times, "times");

        LocalTimeList DateList;

        if (times instanceof LocalTimeList) {
            DateList = (LocalTimeList) times;
        } else {
            final List<LocalTime> copy = Lists.array();
            for (final LocalTime name : times) {
                copy.add(
                    Objects.requireNonNull(name, "includes null " + LocalTime.class.getSimpleName())
                );
            }

            switch (times.size()) {
                case 0:
                    DateList = EMPTY;
                    break;
                default:
                    DateList = new LocalTimeList(copy);
                    break;
            }
        }

        return DateList;
    }

    private LocalTimeList(final List<LocalTime> times) {
        this.times = times;
    }

    @Override
    public LocalTime get(int index) {
        return this.times.get(index);
    }

    @Override
    public int size() {
        return this.times.size();
    }

    private final List<LocalTime> times;

    @Override
    public void elementCheck(final LocalTime times) {
        Objects.requireNonNull(times, "times");
    }

    @Override
    public LocalTimeList setElements(final List<LocalTime> times) {
        final LocalTimeList copy = with(times);
        return this.equals(copy) ?
            this :
            copy;
    }
}
