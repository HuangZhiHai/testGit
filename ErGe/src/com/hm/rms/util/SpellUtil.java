package com.hm.rms.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class SpellUtil {
	private static String getString(String[] text){
		return text[0].charAt(0)+"";
	}
	
	public static String getSpell(String text){
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();  
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
		format.setVCharType(HanyuPinyinVCharType.WITH_V);  
		
		String spell="";
		String[] texts=null;
		for(int i=0;i<text.length();i++){
			try {
				texts=PinyinHelper.toHanyuPinyinStringArray(text.charAt(i),format);
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}
			if(texts==null){
				spell+=text.charAt(i);
			}else{
				spell+=getString(texts);
			}
		}
		return spell;
	}
}
