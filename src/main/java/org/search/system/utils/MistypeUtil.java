package org.search.system.utils;

/*
 * Mistype util
 * All tools to handle mistyping
 * @author Daniil Matkov
 */
public class MistypeUtil {

    public static int LevensteinDistance(String first, String second){
        if(first==null){
            throw new IllegalArgumentException("String can't be null");
        }
        if(second==null){
            throw new IllegalArgumentException("String can't be null");
        }
        int[] prev = new int[ second.length() + 1 ];
        for( int j = 0; j < second.length() + 1; j++ ) {
            prev[ j ] = j;
        }
        for( int i = 1; i < first.length() + 1; i++ ) {
            int[] curr = new int[ second.length() + 1 ];
            curr[0] = i;
            for( int j = 1; j < second.length() + 1; j++ ) {
                int d1 = prev[ j ] + 1;
                int d2 = curr[ j - 1 ] + 1;
                int d3 = prev[ j - 1 ];
                if ( first.charAt(i-1) != second.charAt( j - 1 ) ) {
                    d3 += 1;
                }
                curr[ j ] = Math.min( Math.min( d1, d2 ), d3 );
            }
            prev = curr;
        }
        return prev[ second.length() ];
    }
}
