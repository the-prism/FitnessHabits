package com.strudelauxpommes.androidcomponents.demo.data_team.model;


import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.converter.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.model.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.pref.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.repository.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;



public abstract class GeneralCategory extends BaseModelObject { // todo: rename for "topic"

    public abstract String name();

    public static GeneralCategory decodeFromString(String value) {

        if(value == "breuvage") {
            return new GeneralCategory.Breuvage();
        }

        if(value == "alcool") {
            return new GeneralCategory.Alcool();
        }

        assertThat(false);
        return null;
    }

    public String encodeToString() {
        return this.name();
    }






    public static class Alcool extends GeneralCategory {
        public String name() {
            return "alcool";
        }
    }


    public static class Breuvage extends GeneralCategory{

        public String name() {
            return "breuvage";
        }
    }

}
