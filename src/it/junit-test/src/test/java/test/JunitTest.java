/*
 * Copyright © 2020 Miroslav Pokorny
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
 */
package test;


import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Assert;
import org.junit.Test;
import walkingkooka.datetime.DateTime;
import walkingkooka.datetime.DateTimeContexts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@J2clTestInput(JunitTest.class)
public class JunitTest {

    @Test
    public void testDateTimeContextLocale() {
        Assert.assertNotNull(
                DateTimeContexts.locale(
                        Locale.forLanguageTag("EN-AU"),
                        1902,
                        50,
                        LocalDateTime::now
                )
        );
    }

    @Test
    public void testDateTimeLocalDateToDate() {
        Assert.assertEquals(
                new Date(
                        Date.UTC(2000 - 1900, Calendar.DECEMBER, 31, 0, 0, 0)
                ),
                DateTime.localDateToDate(
                        LocalDate.of(2000, 12, 31)
                )
        );
    }
}
