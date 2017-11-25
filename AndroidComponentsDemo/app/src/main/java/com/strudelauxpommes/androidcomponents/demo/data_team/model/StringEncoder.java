package com.strudelauxpommes.androidcomponents.demo.data_team.model;


public abstract class StringEncoder<Type> {

    public abstract String encodeToString(Type object);
    public abstract Type decodeFromString(String string);

}
