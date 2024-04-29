package br.com.starwars.api.utils;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@UtilityClass
public class StringUtils {

    public String extractValueFromURL(String url) {
        String regex = ".*/([^/]*)/$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }
}
