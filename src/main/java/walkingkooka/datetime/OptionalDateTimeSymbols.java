package walkingkooka.datetime;

import walkingkooka.Cast;
import walkingkooka.Value;

import java.util.Objects;
import java.util.Optional;

/**
 * A typed {@link Optional} necessary because generic types are lost in java.
 */
public final class OptionalDateTimeSymbols implements Value<Optional<DateTimeSymbols>> {

    public final static OptionalDateTimeSymbols EMPTY = new OptionalDateTimeSymbols(Optional.empty());

    public static OptionalDateTimeSymbols with(final Optional<DateTimeSymbols> value) {
        Objects.requireNonNull(value, "value");

        return value.isPresent() ?
            new OptionalDateTimeSymbols(value) :
            EMPTY;
    }

    private OptionalDateTimeSymbols(final Optional<DateTimeSymbols> value) {
        this.value = value;
    }

    // Value............................................................................................................

    @Override
    public Optional<DateTimeSymbols> value() {
        return this.value;
    }

    private final Optional<DateTimeSymbols> value;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return this == other ||
            other instanceof OptionalDateTimeSymbols &&
                this.equals0(Cast.to(other));
    }

    private boolean equals0(final OptionalDateTimeSymbols other) {
        return this.value.equals(other.value);
    }

    @Override
    public String toString() {
        return this.value.map(DateTimeSymbols::toString)
            .orElse("");
    }
}
