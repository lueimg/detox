package com.wix.invoke.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.lang3.reflect.MethodUtils;

/**
 * Created by rotemm on 20/10/2016.
 */
public class ClassTarget extends Target {


    @JsonCreator
    public ClassTarget(@JsonProperty("value") Object value) {
        super(value);
    }

    @Override
    public Object execute(Invocation invocation) throws Exception {
        return MethodUtils.invokeStaticMethod(Class.forName(getValue().toString()), invocation.getMethod(), invocation.getArgs());
    }
}
