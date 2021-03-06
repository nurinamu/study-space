package com.nurinamu.study.algo.hw.chapter.one;

import java.io.FileNotFoundException;

import com.nurinamu.algo.AlgoBase;

public class ThreeNPlusOne extends AlgoBase {

	@Override
	protected void algorithm() {
		String[] inputArr = null;
		while((inputArr = readNext()) != null){
			countNumberWithTrick(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
			printTick();
			countNumber(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
			printTick();
		}
	}
	
	private void countNumber(int firstNum_p, int lastNum_p){
		int count = 0, maxCount = 0;
		
		for(int j = firstNum_p; j <= lastNum_p ; j++){
			count = 1;
			
			for(int i=j;i!=1;i=(i%2==0)?(i/2):(3*i+1)){
				//write(i+" ");
				count++;
				tick();
			}
//			write(count+"\n");
			if(maxCount < count){
				maxCount = count;
			}
		}
		write(firstNum_p+" "+lastNum_p+" "+maxCount+"\n");
	}
	
	private void countNumberWithTrick(int firstNum_p, int lastNum_p){
		int count = 0, maxCount = 0, n;
		
		for(int j = firstNum_p; j <= lastNum_p ; j++){
			count = 1;
			
			for(int i=j;i!=1;i=(i%2==0)?(i/2):(3*i+1)){
				//write(i+" ");
				tick();
				
				//trick code
				n = (int)(Math.log(i)/Math.log(2));
				if(Math.pow(2, n) == i){
//					write("got it : "+i+"\n");
					count += n;
					break;
				}else{
					count++;
				}
			}
//			write(count+"\n");
			if(maxCount < count){
				maxCount = count;
			}
		}
		write(firstNum_p+" "+lastNum_p+" "+maxCount+"\n");
	}
	
	public static void main(String args_p[]){
		try {
			new ThreeNPlusOne().run("3n1.txt", false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
