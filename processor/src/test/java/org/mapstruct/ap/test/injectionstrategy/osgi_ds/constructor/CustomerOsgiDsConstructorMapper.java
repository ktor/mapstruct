/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.injectionstrategy.osgi_ds.constructor;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ap.test.injectionstrategy.shared.CustomerDto;
import org.mapstruct.ap.test.injectionstrategy.shared.CustomerEntity;

/**
 * @author Kevin Grüneberg
 */
@Mapper( componentModel = MappingConstants.ComponentModel.OSGI_DS,
    uses = GenderOsgiDsConstructorMapper.class,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR )
public interface CustomerOsgiDsConstructorMapper {

    @Mapping(target = "gender", source = "gender")
    CustomerDto asTarget(CustomerEntity customerEntity);
}
