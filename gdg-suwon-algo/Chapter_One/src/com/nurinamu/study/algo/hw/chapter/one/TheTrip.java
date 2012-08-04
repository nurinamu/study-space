package com.nurinamu.study.algo.hw.chapter.one;

import java.io.FileNotFoundException;

import com.nurinamu.algo.AlgoBase;

public class TheTrip extends AlgoBase {

	@Override
	protected void algorithm() {
		int numberOfMembers = 0;
		
		try{
			while((numberOfMembers = Integer.parseInt(readNext()[0])) > 0){
				double sum = 0.0;
				double avg = 0.0;
				double exchange = 0.0;
				double[] costs = new double[numberOfMembers];
				for(int i=0;i<numberOfMembers;i++){
					sum += (costs[i] = Double.parseDouble(readNext()[0]));
					tick();
				}
				avg = Math.floor(sum*100.0)/100.0/(double)numberOfMembers;
				
				for(int i=0;i<numberOfMembers;i++){
					if(costs[i] < avg){
						exchange += avg-costs[i];
						tick();
					}
				}
				
				write(Math.floor(exchange*100.0)/100.0+"\n");
			}
			printTick();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		try {
			new TheTrip().run("trip.txt", false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
