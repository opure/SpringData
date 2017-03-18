package com.oneler.domain.Converter;

import com.oneler.domain.enums.Gender;

import javax.persistence.AttributeConverter;

/**
 * Created by opure on 2017/3/17.
 */
public class GenderConverter implements AttributeConverter<Gender,Character> {
    @Override
    public Character convertToDatabaseColumn(Gender attribute) {
        if ( attribute == null ) {
            return null;
        }

        return attribute.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Character dbData) {
        if ( dbData == null ) {
            return null;
        }

        return Gender.fromCode( dbData );
    }
}
