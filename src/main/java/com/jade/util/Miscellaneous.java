package com.jade.util;

import java.util.UUID;

public class Miscellaneous {
    public static String generateRandomId() {
        return UUID.randomUUID().toString();
    }
}
