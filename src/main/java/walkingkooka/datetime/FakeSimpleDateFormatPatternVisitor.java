package walkingkooka.datetime;

public abstract class FakeSimpleDateFormatPatternVisitor extends SimpleDateFormatPatternVisitor {

    protected FakeSimpleDateFormatPatternVisitor() {
        super();
    }

    @Override
    protected void visitEra(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitYear(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitWeekYear(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitMonthInYearContextSensitive(final int width,
                                                    final SimpleDateFormatPatternComponentKind kind) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitMonthInYearStandaloneForm(final int width,
                                                  final SimpleDateFormatPatternComponentKind kind) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitWeekInYear(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitWeekInMonth(final int width) {
        super.visitWeekInMonth(width);
    }

    @Override
    protected void visitDayInYear(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitDayInMonth(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitDayOfWeekInMonth(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitDayNameInWeek(final int width,
                                      final SimpleDateFormatPatternComponentKind kind) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitDayNumberOfWeek(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitAmPmMarker(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitHourInDay23(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitHourInDay24(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitHourInAmPm11(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitHourInAmPm12(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitMinuteInHour(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitSecondInMinute(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitMillisecond(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitGeneralTimezone(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitRfc822Timezone(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitIso8601Timezone(final int width) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitIllegal(final String component) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void visitLiteral(final String text) {
        throw new UnsupportedOperationException();
    }
}
