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

import walkingkooka.collect.list.CsvStringList;
import walkingkooka.collect.list.HasCsvStringList;
import walkingkooka.collect.list.HasTsvStringList;
import walkingkooka.collect.list.ImmutableListDefaults;
import walkingkooka.collect.list.Lists;
import walkingkooka.collect.list.StringLikeList;
import walkingkooka.collect.list.TsvStringList;
import walkingkooka.text.CharSequences;
import walkingkooka.text.HasMultiLineText;
import walkingkooka.text.MultiLineText;
import walkingkooka.text.TextContext;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A {@link List} that holds nullable {@link DateTimeSymbols symbols}.
 */
public final class DateTimeSymbolsList extends AbstractList<DateTimeSymbols>
    implements ImmutableListDefaults<DateTimeSymbolsList, DateTimeSymbols>,
    HasCsvStringList,
    HasTsvStringList,
    HasMultiLineText {

    public static DateTimeSymbolsList fromCsvStringList(final CsvStringList csvStringList) {
        Objects.requireNonNull(csvStringList, "csvStringList");

        return fromStringLikeList(
            csvStringList,
            (final String string) -> CharSequences.isNullOrEmpty(string) ?
                null :
                DateTimeSymbols.fromCsvStringList(
                    CsvStringList.parse(string)
                )
        );
    }

    public static DateTimeSymbolsList fromTsvStringList(final TsvStringList tsvStringList) {
        Objects.requireNonNull(tsvStringList, "tsvStringList");

        return fromStringLikeList(
            tsvStringList,
            (final String string) -> DateTimeSymbols.fromTsvStringList(
                TsvStringList.parse(string)
            )
        );
    }

    private static DateTimeSymbolsList fromStringLikeList(final StringLikeList stringLikeList,
                                                          final Function<String, DateTimeSymbols> parser) {
        return EMPTY.setElements(
            stringLikeList.stream()
                .map(
                    (final String string) -> CharSequences.isNullOrEmpty(string) ?
                    null :
                    parser.apply(string)
                ).collect(Collectors.toList())
        );
    }

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
    public DateTimeSymbolsList setElements(final Collection<DateTimeSymbols> elements) {
        return (DateTimeSymbolsList)
            this.setElementsMaybeCreate(
                elements,
                (Collection<DateTimeSymbols> collection) -> collection instanceof DateTimeSymbolsList,
                this::elementCheck,
                this::replaceDateTimeSymbols
            );
    }

    @Override
    public DateTimeSymbolsList subList(final int from,
                                       final int to) {
        return 0 == from && this.size() == to ?
            this :
            this.replaceDateTimeSymbols(
                this.list.subList(
                    from,
                    to
                )
            );
    }

    private DateTimeSymbolsList replaceDateTimeSymbols(final List<DateTimeSymbols> dateTimeSymbols) {
        return dateTimeSymbols.isEmpty() ?
            EMPTY :
            new DateTimeSymbolsList(dateTimeSymbols);
    }

    @Override
    public void elementCheck(final DateTimeSymbols dateTimeSymbols) {
        // null is allowed
    }

    private final List<DateTimeSymbols> list;

    // HasCsvStringList.................................................................................................

    @Override
    public CsvStringList csvStringList() {
        return CsvStringList.makeCsvStringList(
            this,
            (final DateTimeSymbols dateTimeSymbols) -> null != dateTimeSymbols ?
                dateTimeSymbols.csvStringList()
                    .text() :
                ""
        ).setAllLineBreaks();
    }

    // HasTsvStringList.................................................................................................

    @Override
    public TsvStringList tsvStringList() {
        return TsvStringList.makeTsvStringList(
            this,
            (final DateTimeSymbols dateTimeSymbols) -> null != dateTimeSymbols ?
                dateTimeSymbols.tsvStringList()
                    .text() :
                null
        ).setAllLineBreaks();
    }

    // HasMultiLineText.................................................................................................

    @Override
    public MultiLineText multiLineText(final TextContext context) {
        return MultiLineText.fromCollection(
            this,
            (final DateTimeSymbols dateTimeSymbols) -> null != dateTimeSymbols ?
                dateTimeSymbols.csvStringList()
                    .text() :
                "",
            context
        );
    }
}
