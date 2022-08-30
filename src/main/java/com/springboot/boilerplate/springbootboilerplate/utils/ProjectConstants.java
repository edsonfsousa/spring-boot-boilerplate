package com.springboot.boilerplate.springbootboilerplate.utils;

import java.util.Locale;

public class ProjectConstants {

    // FIXME : Customize project constants for your application.

    public static final String DEFAULT_ENCODING = "UTF-8";

    public static final String PROJECT_BASE_PACKAGE = "com.springboot.boilerplate.springbootboilerplate";

    public static final Locale BRAZIL_LOCALE = new Locale.Builder().setLanguage("pt-br").setRegion("BR").build();

    private ProjectConstants() {

        throw new UnsupportedOperationException();
    }

}
