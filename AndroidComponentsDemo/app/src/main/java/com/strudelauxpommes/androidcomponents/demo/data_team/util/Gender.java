package com.strudelauxpommes.androidcomponents.demo.data_team.util;

import com.strudelauxpommes.androidcomponents.demo.data_team.model.SerializableToString;

import java.io.Serializable;

/**
 * Created by André Lachance on 2017-11-24.
 */

public enum Gender implements SerializableToString {

    MALE(111), // TODO: spécifier les bonnes valeurs, pour que ça soit plus explicit
    FEMALE(222),
    OTHER(333);

    int value;

    Gender(int value) {
        this.value = value;
    }

    public static Gender decodeFromString(String string) {

        // TODO: trouver le moyen d'enlever cette horreur!!!!!!!!!!!!!!

        if(string.equals("111")) {
            return Gender.MALE;
        }

        if(string.equals("222")) {
            return Gender.FEMALE;
        }

        if(string.equals("333")) {
            return Gender.OTHER;
        }

        BaseModelObject.assertThat(false);

        return null;
    }

    public String encodeToString() {
        return "" + value;
    }

}


