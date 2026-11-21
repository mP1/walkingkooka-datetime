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
import walkingkooka.text.HasMultiLineText;
import walkingkooka.text.LineEnding;
import walkingkooka.text.MultiLineText;
import walkingkooka.text.TextContext;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * A {@link List} that holds nullable {@link DateTimeSymbols symbols}.
 */
public final class DateTimeSymbolsList extends AbstractList<DateTimeSymbols>
    implements ImmutableListDefaults<DateTimeSymbolsList, DateTimeSymbols>,
    HasMultiLineText {

    public final static DateTimeSymbolsList EMPTY = new DateTimeSymbolsList(Lists.empty());

    // @VisibleForTesting
    DateTimeSymbolsList(final List<DateTimeSymbols> list) {
        super();
        this.list = list;
    }

    @Override
    public DateTimeSymbols get(final int index) {
        return this.list.get(index);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public DateTimeSymbolsList setElements(final Collection<DateTimeSymbols> collection) {
        DateTimeSymbolsList dateTimeSymbolsList;

        if (collection instanceof DateTimeSymbolsList) {
            dateTimeSymbolsList = (DateTimeSymbolsList) collection;
        } else {
            final List<DateTimeSymbols> copy = Lists.array();
            copy.addAll(collection);

            if (copy.equals(this)) {
                dateTimeSymbolsList = this;
            } else {
                dateTimeSymbolsList = copy.isEmpty() ?
                    EMPTY :
                    new DateTimeSymbolsList(copy);
            }
        }

        return dateTimeSymbolsList;
    }

    @Override
    public void elementCheck(final DateTimeSymbols dateTimeSymbols) {
        // null is allowed
    }

    private final List<DateTimeSymbols> list;

    // HasMultiLineText.................................................................................................

    @Override
    public MultiLineText multiLineText(final TextContext context) {
        Objects.requireNonNull(context, "context");

        final StringBuilder b = new StringBuilder();

        final LineEnding lineEnding = context.lineEnding();
        boolean separatorRequired = false;

        for(final DateTimeSymbols dateTimeSymbols : this.list) {
            if(separatorRequired) {
                b.append(lineEnding);
            }
            b.append(
                dateTimeSymbols.csvStringList()
                    .text()
            );

            separatorRequired = true;
        }

        return MultiLineText.EMPTY.setText(b.toString());
    }
}
