		package Test;
		
		import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
		
import java.util.UUID;

import com.util.Utils;
		
		public class T1 {
			public String getStr(String[] s ){
				String str="[";
				for (int i = 0; i < s.length-1; i++) {
					str=str+"'"+s[i]+"',";
				}str=str+"'"+s[s.length-1]+"'"+",oper"+"]";
				return str;
			}
		public static void main(String[] args) {
			T1 t = new T1();
			/*for (int i = 1; i <=31; i++) {
				System.out.println(" <option value="+"\""+i+"\""+">"+i+"</option>");
			}*/
			//System.out.println(Utils.getConstellation(new Date(1994-1900,10-1,31)));
		//	Date d = new Date(1994-1900,10-1,31);
			
		//	DateFormat df =new  SimpleDateFormat("YYYY-MM-dd");
		//	String birth=df.format(d);
		//	String now = df.format(new Date());
		//	Calendar cs = Calendar.getInstance();
		//	cs.setTime(d);
		//	Calendar ce = Calendar.getInstance();
		//	ce.setTime(new Date());
		//	cs.g
		//	System.out.println(new Date().getYear()-d.getYear());
			String str1="./photo/"+UUID.randomUUID().toString();
			System.out.println(str1.substring(8, 44).length());
			System.out.println("----------------------------------");
			String[] a = new String[]{"1","2","3"};
			String[] b = new String[]{"4","5","6"};
			String[] c = new String[]{"7","8","9"};
			List<String[]> list = new ArrayList<String[]>();
			String str="";
			list.add(a);
			list.add(b);
			list.add(c);
			
			
//			String res="[";
		for (int i = 0; i <list.size(); i++) {
//			res=res+ Utils.getStr(list.get(i))+",";
			if(list.get(i)[1].equals("2"))
			list.remove(list.get(i));
		}
		System.out.println(list.size());
//		res=res+ Utils.getStr(list.get(list.size()-1))+"]";
//		System.out.println(res);
		
		System.out.println("------------------------------------");
		List list1 = new ArrayList();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		List list2 = new ArrayList();
		list2.add("4");
		list2.add("5");
		list2.add("6");
		List list3 = new ArrayList();
		list3.add("7");
		list3.add("8");
		list3.add("9");
		list1.addAll(list2);
		list1.addAll(list3);
		System.out.println(list1);
		}
		
		
		
		
		
		}
