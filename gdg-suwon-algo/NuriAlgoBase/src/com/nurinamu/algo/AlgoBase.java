package com.nurinamu.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public abstract class AlgoBase {
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	private long tickCnt = 0;
	
	protected String readNextLine(){
		String nextStr = null;
		if(br != null){
			try {
				nextStr = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return nextStr;
	}
	
	protected String[] readNext(){
		String[] retStrArr = null;
	
		if(br != null){
			try {
				String nextStr = br.readLine();
				if(nextStr != null){
					StringTokenizer stoken = new StringTokenizer(nextStr, " ");
					retStrArr = new String[stoken.countTokens()];
					int idx=0;
					while(stoken.hasMoreTokens()){
						retStrArr[idx++] = stoken.nextToken();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return retStrArr;
		
	}
	
	protected void write(String msg_p){
		if(bw != null){
			try {
				bw.write(msg_p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.print(msg_p);
		}
	}
	
	private void init(String fileName_p, boolean createOutput_p){
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(new File(fileName_p))));
			if(createOutput_p){
				bw = new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(new File(fileName_p+".out"))));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void close(){
		if(br != null){
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(bw != null){
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected abstract void algorithm(); 
	
	protected void tick(){
		tickCnt++;
	}
	
	protected void printTick(){
		System.out.println("tick : "+tickCnt);
		tickCnt = 0;
	}
	
	public void run(String fileName_p, boolean createOutput_p) throws FileNotFoundException{
		if(fileName_p == null){
			throw new FileNotFoundException();
		}
		init(fileName_p, createOutput_p);
		algorithm();
		close();
	}  
}
