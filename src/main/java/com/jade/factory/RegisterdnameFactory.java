package com.jade.factory;

import com.jade.domain.Registerdname;

public class RegisterdnameFactory {
    public static Registerdname getRegisterdname(String rfirstName, String rlastName){
        return new Registerdname.Builder().rfirstName(rfirstName).rlastName(rlastName).build();
    }
}
