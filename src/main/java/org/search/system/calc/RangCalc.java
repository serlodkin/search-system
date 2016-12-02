package org.search.system.calc;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Daniil on 13.11.2016.
 */
public class RangCalc {
    /**
     * Calculates rang of page with this description,if user request is keyword
     * @param keyword user request for which web page rang calculated
     * @param description description of page to calc rang based on request
     * @return long rang of page in query
     */
    public long calc(String keyword,String description){
        long count=StringUtils.countMatches(keyword,description);
        long words=description.split(" ").length;
        return (long) count/words;
    }
}
