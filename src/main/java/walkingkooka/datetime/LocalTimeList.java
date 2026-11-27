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
import java.util.Collection;
import java.util.List;

/**
 * An immutable list of {@link LocalTime}, which allow nulls.
 */
public final class LocalTimeList extends AbstractList<LocalTime>
    implements ImmutableListDefaults<LocalTimeList, LocalTime> {

    /**
     * An empty {@link LocalTimeList}.
     */
    public final static LocalTimeList EMPTY = new LocalTimeList(
        Lists.empty()
    );

    // @VisibleForTesting
    LocalTimeList(final List<LocalTime> times) {
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
    public LocalTimeList setElements(final Collection<LocalTime> elements) {
        return (LocalTimeList)
            this.setElementsMaybeCreate(
                elements,
                (Collection<LocalTime> collection) -> collection instanceof LocalTimeList,
                this::elementCheck,
                this::replaceTimes
            );
    }

    @Override
    public void elementCheck(final LocalTime time) {
        // allow nulls
    }

    @Override
    public LocalTimeList subList(final int from,
                                 final int to) {
        return 0 == from && this.size() == to ?
            this :
            this.replaceTimes(
                this.times.subList(
                    from,
                    to
                )
            );
    }

    private LocalTimeList replaceTimes(final List<LocalTime> times) {
        return times.isEmpty() ?
            EMPTY :
            new LocalTimeList(times);
    }
}
