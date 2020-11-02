package October;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class October_22_20009 {
	
	static HashMap<String, match> man;
	static HashMap<String, match> woman;
	static class match {
		HashMap<Integer, String> prefer;
		HashSet<String> input;
		String selected = "";
		int index = 0;
		boolean couple = false;
		public match() {
			prefer = new HashMap<>();
			input = new HashSet<>();
		}
	}
	
	static boolean all_coupled() {
		for(String key : woman.keySet()) {
			match temp = woman.get(key);
			if(!temp.couple)
				return false;
		}
		return true;
	}
	
	static void man_select() {
		for(String key : man.keySet()) {
			match temp = man.get(key);
			if(!temp.couple) {
				woman.get(temp.prefer.get(temp.index)).input.add(key);
			}
		}
	}
	
	static void woman_select() {
		for(String key : woman.keySet()) {
			match temp = woman.get(key);
			if(temp.input.size() > 0) {
				String selected = temp.selected;
				boolean rob = false;
				for(int i=0;i<temp.prefer.size();i++) {
					if(temp.prefer.get(i).equals(selected)) {
						break;
					}
					if(temp.input.contains(temp.prefer.get(i))) {
						selected = temp.prefer.get(i);
						rob = true;
						break;
					}
				}
				if(rob && !temp.selected.equals("")) {
					man.get(temp.selected).couple = false;
					man.get(temp.selected).index += 1;
				}
				for(String unselected : temp.input) {
					if(!selected.equals(unselected)) {
						man.get(unselected).couple = false;
						man.get(unselected).index += 1;
					}
				}
				temp.selected = selected;
				temp.couple = true;
				man.get(selected).couple = true;
			}
			temp.input = new HashSet<>();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		man = new HashMap<>();
		woman = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		while(line.hasMoreTokens()) {
			String temp = line.nextToken();
			man.put(temp, new match());
		}
		line = new StringTokenizer(br.readLine(), " ");
		while(line.hasMoreTokens()) {
			String temp = line.nextToken();
			woman.put(temp, new match());
		}
		for(int i=0;i<N;i++) {
			line = new StringTokenizer(br.readLine(), " ");
			String temp = line.nextToken();
			int temp_i = 0;
			while(line.hasMoreTokens()) {
				man.get(temp).prefer.put(temp_i, line.nextToken());
				temp_i++;
			}
		}
		for(int i=0;i<N;i++) {
			line = new StringTokenizer(br.readLine(), " ");
			String temp = line.nextToken();
			int temp_i = 0;
			while(line.hasMoreTokens()) {
				woman.get(temp).prefer.put(temp_i, line.nextToken());
				temp_i++;
			}
		}
		//System.out.println("hello");
		while(!all_coupled()) {
			man_select();
			woman_select();
		}
		for (String key : woman.keySet()) {
			System.out.println(woman.get(key).selected + " " + key);
		}
	}

}
