package io.github.bijeshos.badger.common;

import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {
    public static List<String> splitLineToList(String inputLine) {
        List<String> lineItems = new ArrayList<>();
        lineItems.addAll(Splitter.on("|")
                                 .splitToList(inputLine));
        return lineItems;
    }

    public static String[] splitLineToArray(String inputLine) {
        List<String> lineItems = new ArrayList<>();
        lineItems.addAll(Splitter.on("|")
                                 .splitToList(inputLine));
        return lineItems.stream()
                        .toArray(String[]::new);
    }
}
