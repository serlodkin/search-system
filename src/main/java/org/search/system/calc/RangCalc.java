package org.search.system.calc;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Daniil on 13.11.2016.
 */
public class RangCalc {
    public long calc(String keyword,String description){
        long count=StringUtils.countMatches(keyword,description);
        long words=description.split(" ").length;
        return (long) count/words;
    }
}
