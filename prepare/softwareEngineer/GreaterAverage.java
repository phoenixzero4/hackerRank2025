package prepare.softwareEngineer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GreaterAverage
{

	public static int countResponseTimeRegressions( List<Integer> responseTimes )
		{

			int count = 0, total = responseTimes.get( 0 ), average = 0;
			int index = responseTimes.size();
			for ( int i = 0; i < index; i++ )
				{
					if ( i > 0 )
						{
							total += responseTimes.get( i );
							average = total / ( i + 1 );
							if ( responseTimes.get( i ) > average )
								{
									count++;
								}
						}
				}
			return count;
		}

	public static void main( String[] args ) throws IOException
		{
			// BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
			//
			// int responseTimesCount = Integer.parseInt( bufferedReader.readLine().trim() );
			// List<Integer> responseTimes = IntStream.range( 0, responseTimesCount ).mapToObj( i ->
			// {
			// try
			// {
			// return bufferedReader.readLine().replaceAll( "\\s+$", "" );
			// } catch ( IOException ex )
			// {
			// throw new RuntimeException( ex );
			// }
			// } ).map( String::trim ).map( Integer::parseInt ).collect( toList() );
			//
			// int result = Result.countResponseTimeRegressions( responseTimes );
			// System.out.println( result );
			// bufferedReader.close();

			ArrayList<Integer> list = new ArrayList<>();
			list.add( 100 );
			list.add( 200 );
			list.add( 150 );
			list.add( 300 );

			int x = countResponseTimeRegressions( list );
			System.out.println( "Number of elements greater than average of previous elements: " + x );
		}
}
