package prepare.softwareEngineer;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

class Result
{

	public static int countResponseTimeRegressions( List<Integer> responseTimes )
		{
			int count = 0;
			// use double for precision to avoid failing edge cases
			double sum = 0.0;

			for ( int i = 1; i < responseTimes.size(); i++ )
				{
					sum += responseTimes.get( i - 1 );
					double avg = sum / i;
					if ( responseTimes.get( i ) > avg )
						{
							count++;
						}
				}

			return count;
		}
}

public class CountElementsGreaterThanPreviousAverage
{
	// HackerRanks overkill on input

	public static void main( String[] args ) throws IOException
		{
			BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );

			int responseTimesCount = Integer.parseInt( bufferedReader.readLine().trim() );

			List<Integer> responseTimes = IntStream.range( 0, responseTimesCount ).mapToObj( i ->
				{
					try
						{
							return bufferedReader.readLine().replaceAll( "\\s+$", "" );
						} catch ( IOException ex )
						{
							throw new RuntimeException( ex );
						}
				} ).map( String::trim ).map( Integer::parseInt ).collect( toList() );

			int result = Result.countResponseTimeRegressions( responseTimes );

			System.out.println( result );

			bufferedReader.close();
		}
}

