package com.att.training.demo.mutations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Calculator
{
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    int add(int x, int y)
    {
        return x + y;
    }

    int abs(int value)
    {
        if (value < 0)
        {
            return -value;
        }
        return value;
    }

    int increment(int x)
    {
        return ++x;
    }

    int decrement(int x)
    {
        return --x;
    }

    int addAndSet(int x, int y, Service service)
    {
        int result = x + y;
        service.setResult(result);
        log.info("#addAndSet - got {}", result);
        return result;
    }
}

