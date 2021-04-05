[![Build Status](https://github.com/mP1/walkingkooka-datetime/actions/workflows/build.yaml/badge.svg)](https://github.com/mP1/walkingkooka-datetime/actions/workflows/build.yaml/badge.svg)
[![Coverage Status](https://coveralls.io/repos/github/mP1/walkingkooka-datetime/badge.svg?branch=master)](https://coveralls.io/github/mP1/walkingkooka-datetime?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/mP1/walkingkooka-datetime.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/walkingkooka-datetime/context:java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/mP1/walkingkooka-datetime.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/walkingkooka-datetime/alerts/)
[![J2CL compatible](https://img.shields.io/badge/J2CL-compatible-brightgreen.svg)](https://github.com/mP1/j2cl-central)



A collection of mostly Contexts with a datetime focus and a few other utilities which can be useful, when working with
date, times, formatters and parsers within `java.time` and support packages.



# `DateTimeFormatterPatternVisitor`

One feature missing from `DateTimeFormatter` is a visitor that can provide each of the components in the pattern.

- Understands components with a pattern, including those that are length aware with length selecting different options.
- The sequence run for all components is passed as a parameter.
- visit methods are named with their pretty form.
- `visitLiteral` Aggregates any sequence of literals with support for escaping.
- `visitIllegal` Attempts to identify illegal sequences that are compatible with those identify by `DateTimeFormatter#parse`.



# `SimpleDateFormatPatternVisitor`

Supports visiting the individual components, identifying sequences and providing some hints to the matching visitor method.
This can be useful when attempting to translate a `SimpleDateFormat` pattern to another pattern. 




