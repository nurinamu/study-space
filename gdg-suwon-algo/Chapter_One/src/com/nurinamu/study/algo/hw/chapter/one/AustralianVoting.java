package com.nurinamu.study.algo.hw.chapter.one;

import java.io.FileNotFoundException;
import java.util.SortedSet;
import java.util.Vector;

import com.nurinamu.algo.AlgoBase;

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
			Candidate[] candidates = new Candidate[numberOfCandidate];
			
			for(int j=0;j<numberOfCandidate;j++){
				candidates[j] = new Candidate(readNextLine());
				tick();
			}
			String[] result = null;
			int totalBallot = 0;
			while((result=readNext()) != null && result.length > 1){
				candidates[Integer.parseInt(result[0])-1].ballot++;
				totalBallot++;
				tick();
			}
			
			
			if(result != null){
				numberOfCandidate = Integer.parseInt(result[0]);
			}
			
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
