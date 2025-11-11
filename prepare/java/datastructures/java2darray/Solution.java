
package prepare.java.datastructures.java2darray;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class Solution
{

	public static void main( String[] args ) throws IOException
		{
			BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );

			List<List<Integer>> arr = new ArrayList<>();

			IntStream.range( 0, 6 ).forEach( i ->
				{
					try
						{
							arr.add( Stream.of( bufferedReader.readLine().replaceAll( "\\s+$", "" ).split( " " ) )
									.map( Integer::parseInt ).collect( toList() ) );
						} catch ( IOException ex )
						{
							throw new RuntimeException( ex );
						}
				} );

			bufferedReader.close();

			int sum = 0, max = Integer.MIN_VALUE;

			for ( int i = 1; i < 5; i++ )
				{

					for ( int j = 1; j < 5; j++ )
						{
							sum = arr.get( i - 1 ).get( j - 1 ) + arr.get( i - 1 ).get( j ) + arr.get( i - 1 ).get(
									j + 1 ) + arr.get( i ).get( j ) + arr.get( i + 1 ).get( j - 1 ) + arr.get( i + 1 )
									.get( j ) + arr.get( i + 1 ).get( j + 1 );

							max = Math.max( max, sum );
						}


				}
			System.out.println( max );
		}
}
