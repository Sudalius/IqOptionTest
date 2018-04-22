package com.sudyarov.util;


import com.codeborne.selenide.Selenide;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Options {

    public static void generateWebDriver(String url) {
        Selenide.open(url);
    }

    public static Properties loadProperties() throws IOException {
        Properties props = new Properties();
        URL url = ClassLoader.getSystemResource("data.properties");
        props.load(url.openStream());

        return props;
    }

}
