package com.nurinamu.study.algo.hw.chapter.one;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import com.nurinamu.algo.AlgoBase;

/**
 * PC/UVa IDs: 110108/10142, Popularity: B, Success rate: low Level: 1
 **/

public class AustralianVoting extends AlgoBase {
	
//	private final int BALLOT_THRESHOLD = 1000;
	
	private class Candidate{
		public final String name;
		public int ballot = 0;
		public Candidate(String name_p){
			name = name_p;
		}
	}
	
	@Override
	protected void algorithm() {
		int totalElection = Integer.parseInt(readNext()[0]);
		int numberOfCandidate = -1;
		for(int i=0;i<totalElection;i++){
			if(numberOfCandidate < 0){
				numberOfCandidate = Integer.parseInt(readNext()[0]);
			}
			ArrayList<Candidate> candidates = new ArrayList<Candidate>();
			
			for(int j=0;j<numberOfCandidate;j++){
				candidates.add(new Candidate(readNextLine()));
				tick();
			}
			String[] result = null;
			int totalBallot = 0;
			while((result=readNext()) != null && result.length > 1){
				candidates.get(Integer.parseInt(result[0])-1).ballot++;
				totalBallot++;
				tick();
			}
			
			TreeSet<Candidate> rankSet = new TreeSet(new Comparator<Candidate>() {

				@Override
				public int compare(Candidate o1, Candidate o2) {
					tick();
					if(o1.ballot > o2.ballot) return -1;
					return 1;
				}
				
			});
			
			rankSet.addAll(candidates);
			
			while(rankSet.size() > 0 && rankSet.first().ballot < (totalBallot/2+(totalBallot%2)) && rankSet.first().ballot != rankSet.last().ballot){
				totalBallot -= rankSet.last().ballot;
				rankSet.pollLast();
			}
			
			
			if(rankSet.first().ballot == rankSet.last().ballot){
				for(Candidate elected : rankSet){
					write(elected.name+" "+elected.ballot+", ");
				}
			}else if(rankSet.first().ballot >= (totalBallot/2+(totalBallot%2))){
				write(rankSet.first().name+" "+rankSet.first().ballot);
			}else{
				write("no one was elected.->"+rankSet.size()+"\n");
			}
			
			if(result != null){
				numberOfCandidate = Integer.parseInt(result[0]);
			}
			write("\n");
			printTick();
		}
		
		
	}
	
	public static void main(String[] args){
		try {
			new AustralianVoting().run("ballot.txt", false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
