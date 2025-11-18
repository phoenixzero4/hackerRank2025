package prepare.java.bigNumber.bigDecimal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    static List<String> list = new ArrayList<>();

    public static void main( String[] args ) throws Exception {
        BufferedReader b = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( b.readLine().trim() );

        String[] s = new String[n];

        for ( int i = 0; i < n; i++ ) {
            s[i] = b.readLine();
        }

        Arrays.sort( s, 0, n, new Comparator<String>() {

            public int compare( String a, String b ) {
                BigDecimal bda = new BigDecimal( a );
                BigDecimal bdb = new BigDecimal( b );

                return bdb.compareTo( bda );
            }
        } );

        for ( int i = 0; i < n; i++ ) {
            System.out.println( s[i] );
        }

    }
}