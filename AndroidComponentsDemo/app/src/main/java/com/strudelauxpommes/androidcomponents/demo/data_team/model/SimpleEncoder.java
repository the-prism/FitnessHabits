package com.strudelauxpommes.androidcomponents.demo.data_team.model;


public class SimpleEncoder<Type extends SerializableToString> extends StringEncoder<Type> {

    @Override
    public String encodeToString(Type object) {
        return object.encodeToString();
    }

    public Type decodeFromString(String string) {
        return null;
    }


}

