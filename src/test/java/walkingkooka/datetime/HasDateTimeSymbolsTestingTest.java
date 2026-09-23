package walkingkooka.datetime;

import org.junit.jupiter.api.Test;
import walkingkooka.reflect.PublicClassTesting;

public final class HasDateTimeSymbolsTestingTest implements HasDateTimeSymbolsTesting,
    PublicClassTesting<HasDateTimeSymbolsTesting> {

    @Test
    public void testConstants() {
        this.checkNotEquals(
            HasDateTimeSymbolsTesting.DATE_TIME_SYMBOLS,
            HasDateTimeSymbolsTesting.DIFFERENT_DATE_TIME_SYMBOLS
        );
    }

    @Test
    public void testOptionalConstants() {
        this.checkNotEquals(
            HasDateTimeSymbolsTesting.OPTIONAL_DATE_TIME_SYMBOLS,
            HasDateTimeSymbolsTesting.OPTIONAL_DIFFERENT_DATE_TIME_SYMBOLS
        );
    }

    @Override
    public Class<HasDateTimeSymbolsTesting> type() {
        return HasDateTimeSymbolsTesting.class;
    }
}
