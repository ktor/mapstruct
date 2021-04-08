/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.injectionstrategy.osgi_ds._default;

import static java.lang.System.lineSeparator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.ap.test.injectionstrategy.shared.CustomerDto;
import org.mapstruct.ap.test.injectionstrategy.shared.CustomerEntity;
import org.mapstruct.ap.test.injectionstrategy.shared.Gender;
import org.mapstruct.ap.test.injectionstrategy.shared.GenderDto;
import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.runner.AnnotationProcessorTestRunner;
import org.mapstruct.ap.testutil.runner.GeneratedSource;


/**
 * Test field injection for component model osgi-ds.
 *
 */
@WithClasses({
    CustomerDto.class,
    CustomerEntity.class,
    Gender.class,
    GenderDto.class,
    CustomerOsgiDsDefaultMapper.class,
    GenderOsgiDsDefaultMapper.class
})
@IssueKey("2400")
@RunWith(AnnotationProcessorTestRunner.class)
public class OsgiDsDefaultMapperTest {

    @Rule
    public final GeneratedSource generatedSource = new GeneratedSource();

    @Test
    public void shouldHaveBeenDeclaredAsAComponent() {
        generatedSource.forMapper( CustomerOsgiDsDefaultMapper.class )
                .content()
                .contains( "@Component" + lineSeparator() + "public class CustomerOsgiDsDefaultMapperImpl" );
    }

    @Test
    public void shouldHaveFieldInjection() {
        generatedSource.forMapper( CustomerOsgiDsDefaultMapper.class )
            .content()
            .contains( "@Reference" + lineSeparator() + "    private GenderOsgiDsDefaultMapper" )
            .doesNotContain( "public CustomerOsgiDsDefaultMapperImpl(" );
    }
}
