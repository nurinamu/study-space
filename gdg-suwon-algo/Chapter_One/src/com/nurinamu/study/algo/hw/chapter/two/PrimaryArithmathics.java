package com.nurinamu.study.algo.hw.chapter.two;

import java.io.FileNotFoundException;

import com.nurinamu.algo.AlgoBase;

public class PrimaryArithmathics extends AlgoBase {

	@Override
	protected void algorithm() {
		String[] value = null;
		while((value=readNext()) != null && value.length == 2 
				&& !(value[0].equals("0") && value[1].equals("0"))){
			
			write(value[0]+":"+value[1]);
			
			int carryCnt = 0;
			int maxTry = Math.max(value[0].length(), value[1].length());
			value[0] = String.format("%0"+maxTry+"d", Long.parseLong(value[0]));
			value[1] = String.format("%0"+maxTry+"d", Long.parseLong(value[1]));
			maxTry--;
			int carry = 0;
			while(maxTry >= 0){
				if(Integer.parseInt(value[0].charAt(maxTry)+"") 
						+ Integer.parseInt(value[1].charAt(maxTry)+"") + carry >= 10){
					carry = 1;
					carryCnt++;
				}else{
					carry = 0;
				}
				maxTry--;
			}
			
			write(" "+(carryCnt>0?carryCnt:"No")+" carryOperation"+(carryCnt>1?"s.\n":".\n"));
		}

	}
	
	public static void main(String[] args){
		try {
			new PrimaryArithmathics().run("primary.txt", false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
