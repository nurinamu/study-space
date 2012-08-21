package com.nurinamu.study.algo.hw.chapter.three;

import java.util.HashMap;
import java.util.Vector;

import com.nurinamu.algo.AlgoBase;

public class CryptKicker extends AlgoBase {
	
	private HashMap<Integer, Vector<String>> dic = new HashMap<Integer, Vector<String>>();

	@Override
	protected void algorithm() {
		int wordCnt = Integer.parseInt(readNextLine());
		String word = null;
		Vector<String> wordVec = null;
		for(int i=0;i<wordCnt;i++){
			word = readNextLine();
			if(dic.containsKey(word.length())){
				dic.get(word.length()).add(word);
			}else{
				wordVec = new Vector<String>();
				wordVec.add(word);
				dic.put(word.length(), wordVec);
			}
		}
		
		boolean encrypted = false;
		String[] targetStatement = null;
		HashMap<Character, Character> codeTable = new HashMap<Character, Character>();
		StringBuffer encryptedStr = null;
		while((targetStatement = readNext()) != null){
			encryptedStr = new StringBuffer();
			for(int i=0;i<targetStatement.length;i++){
				
				String targetWord = targetStatement[i];
				Vector<String> dicVec = dic.get(targetWord.length());
				if(dicVec != null){
					
				}else{
					break;
				}
				
			}
			
			if(encrypted){
				
			}else{
				for(int i=0;i<targetStatement.length;i++){
					String targetWord = targetStatement[i];
				}
			}
		}
		
	}
	
	private String findMatched(Vector<String> dicVec, String targetWord,
			HashMap<Character, Character> codeTable){
		
		for(String dicWord:dicVec){
			for(int j=0;j<dicWord.length();j++){
				if(dicWord.charAt(j) != targetWord.charAt(j)){
					if(codeTable.containsKey(dicWord.charAt(j))){
						
					}else{
						codeTable.p
					}
				}else{
					//exit;
				}
			}
		}
		return null;
	}

}
