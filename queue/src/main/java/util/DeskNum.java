package util;

public class DeskNum {
	
	private static Integer aNum = 1;
	
	private static Integer bNum = 1;
	
	private static Integer cNum = 1;

	public static String getNum(String type){
		if(type.equals("A")){
			if(aNum>100){
				aNum = 1;
			}
			return "A"+formatNum(aNum++);
		}
		
		if(type.equals("B")){
			if(bNum>100){
				bNum = 1;
			}
			return "B"+formatNum(bNum++);
		}
		
		if(type.equals("C")){
			if(cNum>100){
				cNum = 1;
			}
			return "C"+formatNum(cNum++);
		}		
		return "000";		
	}
	
	private static String formatNum(Integer num){
		if(num<10){
			return "00"+num;
		}
		if(num<100){
			return "0"+num;
		}
		return ""+num;
	}
	
	public static void setaNum(Integer aNum) {
		DeskNum.aNum = aNum;
	}
	
	public static void setbNum(Integer bNum) {
		DeskNum.bNum = bNum;
	}
	
	public static void setcNum(Integer cNum) {
		DeskNum.cNum = cNum;
	}
	
	

}
