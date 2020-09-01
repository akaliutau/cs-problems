package org.problems.favourite;

import java.util.Arrays;
import org.problems.utils.Utils;

/**
 * Music on Flight
 * 
 * You are given int[] music_duration which includes all the music durations.
 * You are also given the duration of the flight which is d in minutes. Now, you
 * need to pick two musics and the total duration of the two musics is less than
 * or equal to (d - 30min). 
 * Find the pair of musics with the longest total
 * duration. If multiple found, return the pair with the longest music.
 * 
 * Example: 
 * Input 
 * music_duration: [90, 85, 75, 60, 120, 150, 125] 
 * d: 250
 * 
 * Output [90, 125] 
 * 90min + 125min = 215 is the maximum number
 * within 220 (250min - 30min)
 * 
 * 
 */
public class MuximumDuration {
	
	static class Pair {
		public int[] ret = new int[2];
		
		public Pair(int i, int j) {
			ret[0] = i;
			ret[1] = j;
		}

		public int diff() {
			return Math.abs(ret[0] - ret[1]);
		}
		
		public int getDuration() {
			return ret[0] + ret[1];
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(ret);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!Arrays.equals(ret, other.ret))
				return false;
			return true;
		}
		
	}
	
	public static int[] findPair(int[] musicDuration, int d) {
		int n = musicDuration.length;
		Pair pair = new Pair(0, 0);

		int right = n - 1;
		int left = 0;
		Arrays.parallelSort(musicDuration);
		Utils.print(musicDuration);
		
		while (left < right) {
			int r = right;
			while(r >= 0 && musicDuration[r] >= d - 30) {
				r --;
			}
			if (r <= 0) {
				break;
			}
			int l = left;
			while(l < r && musicDuration[l] + musicDuration[r] <= d - 30) {
				l ++;
			}
			if (l - 1 > 0 && musicDuration[l - 1] + musicDuration[r] <= d - 30) {
				Pair p = new Pair(musicDuration[l - 1], musicDuration[r]);
				if (p.getDuration() > pair.getDuration()) {
					pair = p;
				}else if (p.getDuration() == pair.getDuration()) {
					if (p.diff() > pair.diff()) {
						pair = p;
					}
				}
			}
			right = r - 1;
			
		}
		
		return pair.ret;
	}

	public static void main(String[] arg) {
		
		int[] musicDuration = {90, 85, 75, 60, 120, 150, 125};
		Utils.print(findPair(musicDuration, 250));
	}

}
