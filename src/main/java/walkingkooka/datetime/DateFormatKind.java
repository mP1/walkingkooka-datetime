package walkingkooka.datetime;

import java.text.DateFormat;

/**
 * A type-safe enumeration of {@link DateFormat} int style values.
 */
public enum DateFormatKind {

    FULL(
        DateFormat.FULL
    ),

    LONG(
        DateFormat.LONG
    ),

    MEDIUM(
        DateFormat.MEDIUM
    ),

    SHORT(
        DateFormat.SHORT
    );

    DateFormatKind(final int dateFormatStyle) {
        this.dateFormatStyle = dateFormatStyle;
    }

    public int dateFormatStyle() {
        return this.dateFormatStyle;
    }

    private final int dateFormatStyle;
}
