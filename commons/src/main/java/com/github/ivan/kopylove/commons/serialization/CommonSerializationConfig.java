package com.github.ivan.kopylove.commons.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

final class CommonSerializationConfig
{

    private static final ObjectMapper COMMON_SERIALIZER = new ObjectMapper();

    private CommonSerializationConfig()
    {
    }

    static ObjectMapper getCommonSerializer()
    {
        return COMMON_SERIALIZER;
    }
}
