package October;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class October_16_3745 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = br.readLine()) != null) {
			int N = Integer.parseInt(line.trim());
			StringTokenizer lines = new StringTokenizer(br.readLine().trim());
			int max = Integer.MIN_VALUE;
			int count = 1;
			int prev = Integer.parseInt(lines.nextToken());
			while(lines.hasMoreTokens()) {
				int now = Integer.parseInt(lines.nextToken());
				if(prev < now) {
					prev = now;
					count++;
				}
				else {
					prev = now;
					if(max < count)
						max = count;
					count = 1;
				}
			}
			System.out.println(max);
		}
	}

}
