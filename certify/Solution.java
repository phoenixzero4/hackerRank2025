package certify;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;



class Result
{

	/*
	 * Complete the 'maxPresentations' function below. The function is expected to return an INTEGER.
	 * The function accepts following parameters: 1. INTEGER_ARRAY scheduleStart 2. INTEGER_ARRAY
	 * scheduleEnd
	 */

	public static int maxPresentations( List<Integer> scheduleStart, List<Integer> scheduleEnd )
		{
			int n = scheduleStart.size();
			List<int[]> presentations = new ArrayList<>();

			for ( int i = 0; i < n; i++ )
				{
					presentations.add( new int[]
								{ scheduleStart.get( i ), scheduleEnd.get( i ) } );
				}

			// Sort by end time
			presentations.sort( Comparator.comparingInt( a -> a[1] ) );

			int count = 0;
			int lastEnd = -1;

			for ( int[] p : presentations )
				{
					if ( p[0] >= lastEnd )
						{
							count++;
							lastEnd = p[1];
						}
				}

			return count;
		}
}

public class Solution
{
	public static void main( String[] args ) throws IOException
		{
			BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
			BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( System.getenv( "OUTPUT_PATH" ) ) );

			int scheduleStartCount = Integer.parseInt( bufferedReader.readLine().trim() );

			List<Integer> scheduleStart = IntStream.range( 0, scheduleStartCount ).mapToObj( i ->
				{
					try
						{
							return bufferedReader.readLine().replaceAll( "\\s+$", "" );
						} catch ( IOException ex )
						{
							throw new RuntimeException( ex );
						}
				} ).map( String::trim ).map( Integer::parseInt ).collect( toList() );

			int scheduleEndCount = Integer.parseInt( bufferedReader.readLine().trim() );

			List<Integer> scheduleEnd = IntStream.range( 0, scheduleEndCount ).mapToObj( i ->
				{
					try
						{
							return bufferedReader.readLine().replaceAll( "\\s+$", "" );
						} catch ( IOException ex )
						{
							throw new RuntimeException( ex );
						}
				} ).map( String::trim ).map( Integer::parseInt ).collect( toList() );

			int result = Result.maxPresentations( scheduleStart, scheduleEnd );

			bufferedWriter.write( String.valueOf( result ) );
			bufferedWriter.newLine();

			bufferedReader.close();
			bufferedWriter.close();
		}
}
