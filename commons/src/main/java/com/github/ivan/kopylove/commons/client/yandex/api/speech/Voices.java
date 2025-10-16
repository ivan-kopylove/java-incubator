package com.github.ivan.kopylove.commons.client.yandex.api.speech;

import java.util.HashMap;
import java.util.Map;

final class Voices
{

    private Voices() {}

    static Map<String, String> philip()
    {
        Map<String, String> body = new HashMap<>();
        body.put("lang", "ru-RU");
        body.put("voice", "filipp");
        return body;
    }

    static Map<String, String> alena()
    {
        Map<String, String> body = new HashMap<>();
        body.put("lang", "ru-RU");
        body.put("voice", "alena");
        return body;
    }

    static Map<String, String> madirus()
    {
        Map<String, String> body = new HashMap<>();
        body.put("lang", "ru-RU");
        body.put("voice", "madirus");
        return body;
    }

    static Map<String, String> zahar()
    {
        Map<String, String> body = new HashMap<>();
        body.put("lang", "ru-RU");
        body.put("voice", "zahar");
        return body;
    }

    static Map<String, String> omazh()
    {
        Map<String, String> body = new HashMap<>();
        body.put("lang", "ru-RU");
        body.put("voice", "omazh");
        return body;
    }

    static Map<String, String> jane()
    {
        Map<String, String> body = new HashMap<>();
        body.put("lang", "ru-RU");
        body.put("voice", "jane");
        return body;
    }

    static Map<String, String> ermil()
    {
        Map<String, String> body = new HashMap<>();
        body.put("lang", "ru-RU");
        body.put("voice", "ermil");
        return body;
    }

    static Map<String, String> john()
    {
        Map<String, String> body = new HashMap<>();
        body.put("lang", "en-US");
        body.put("voice", "john");
        return body;
    }
}

