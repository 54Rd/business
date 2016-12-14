package org.business.Utils;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by wangz on 2016/12/8.
 */
public class StringUtils {

    public static boolean anyEmpty(String... args) {
        int length = args.length;
        return Arrays.asList(args).stream().filter(s -> !(null==s||s.isEmpty())).count()!=length;
    }
}
