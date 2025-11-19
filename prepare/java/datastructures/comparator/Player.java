package prepare.java.datastructures.comparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<Player> {



    @Override
    public int compare( Player o1, Player o2 ) {

        int score1 = o1.score;
        int score2 = o2.score;

        if ( score1 == score2 ) {

            // compare by names to sort
            if ( o1.name.equals( o2.name ) ) {
                System.err.println( "Names are equal" );
                return 0;
            } else {
                return o1.name.compareTo( o2.name );
            }
        } else {
            return score2 - score1;
        }
    }
}
class Player {
    String name;
    int score;

    Player( String name, int score ) {
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main( String[] args ) throws FileNotFoundException {
        File file = new File( "player.txt" );

        Scanner scan = new Scanner( file );
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for ( int i = 0; i < n; i++ ) {
            player[i] = new Player( scan.next(), scan.nextInt() );
        }
        scan.close();

        Arrays.sort( player, checker );
        for ( int i = 0; i < player.length; i++ ) {
            System.out.printf( "%s %s\n", player[i].name, player[i].score );
        }
    }
}
