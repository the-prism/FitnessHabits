package com.strudelauxpommes.androidcomponents.demo.data_team.converter;

import android.arch.persistence.room.TypeConverter;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.converter.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.model.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.pref.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.record.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.repository.*;
import com.strudelauxpommes.androidcomponents.demo.data_team.util.*;



public class GeneralCategoryConverter {

    @TypeConverter
    public GeneralCategory decodeFromString(String value) {
        return GeneralCategory.decodeFromString(value);
    }

    @TypeConverter
    public String encodeToString(GeneralCategory value) {
        return value.encodeToString();
    }

}
