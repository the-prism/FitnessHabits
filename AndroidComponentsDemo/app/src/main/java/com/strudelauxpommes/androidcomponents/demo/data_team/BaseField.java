package com.strudelauxpommes.androidcomponents.demo.data_team;



public abstract class BaseField<Type> {

    public abstract void setRecordValue(BaseRecord record, Type value);

    public abstract Type getRecordValue(BaseRecord record);

}
