/**
 * This code is part of the exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 * 
 * @author 21860 | 21836
 */
package org.hua.unihash;

import java.util.Scanner;
import java.util.StringTokenizer;

import org.hua.unihash.Dictionary.Entry;

public class App {

	public static void main(String args[]) {

		Dictionary<String, Integer> dict = new OpenHashTable<>();
		
		try (Scanner scanner = new Scanner(System.in)) {
			while(scanner.hasNext()) { 
				String line = scanner.nextLine();
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens()) { 
					String word  = st.nextToken();
					Integer curFreq = dict.get(word);
					if (curFreq == null) { 
						curFreq = 1;
					} else { 
						curFreq++;
					}
					dict.put(word, curFreq);
				}
			}
		}
		
		for(Entry<String, Integer> e: dict) { 
			System.out.println("Word " + e.getKey() + " appeared " + e.getValue() + " times");
		}

	}

}

