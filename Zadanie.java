package Example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Zadanie {
	String KEY_SPLIT = "[ ,.;\"()-?]" ;
	public ArrayList<String> lines; 
	// KONSTRUKTOR - odczytuje plik i wstawia linijki do ArrayList
	public Zadanie() throws FileNotFoundException {
		File plik = new File("C:\\Users\\Tomek\\eclipse-workspace\\Example\\src\\Example/tekst.txt");
		Scanner sc= new Scanner(plik);
		this.lines = new ArrayList<String>();
		String line;
		line=sc.nextLine();
		this.lines.add(line);
		
		try {
			while(line!=null) {
				this.lines.add(line);
				
				line=sc.nextLine();
			} 
		}
		catch (NoSuchElementException e) {
			// error
		}

	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Zadanie zadanie = new Zadanie();
		// po ilosci slow
		HashMap<String , Integer > howMany = new HashMap<>();
		howMany= zadanie.howManyWords();
		// sortowanie po Key
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(howMany);	//sortowanie
		int ii=0;
		for(String i : treeMap.keySet()) {
			System.out.println(i + "  -  " + treeMap.get(i));
			ii++;
			if(ii==10) break;
		} 
		System.out.println("-----------------------------");
		// sortowanie po Value ilosci slow
		Map<String, Integer> sortedWordsMany= sortByValue(howMany);
		ii=0;
		for(String i : sortedWordsMany.keySet()) {
			System.out.println(i + "  -  " + sortedWordsMany.get(i));
			ii++;
			if(ii==10) break;
		} 
		zadanie.chmura(sortedWordsMany);
		
		// po dlugosci slow
		HashMap<String , Integer > howLong = new HashMap<>();
		howLong= zadanie.howManyChars();
		// sortowanie po Value dlugosci slow
		Map<String, Integer> sortedWordsLong= sortByValue(howLong);
		ii=0;
		for(String i : sortedWordsLong.keySet()) {
			System.out.println(i + "  -  " + sortedWordsLong.get(i));
			ii++;
			if(ii==10) break;
		} 
	}
	
	public HashMap<String , Integer> howManyWords() {
		HashMap<String , Integer> word=new HashMap<>();
		for(String i : lines) {
			for(String j : i.split(KEY_SPLIT)) {
				j.trim();
				if(!j.isEmpty()) {
					
					if(word.isEmpty()) word.put(j, 1);
					else {							
						if(word.containsKey(j)) word.replace(j, word.get(j)+1);
						else word.put(j, 1);
					}
					
				}	
			}	
		}
		return word;
	}
	
	public HashMap<String , Integer> howManyChars() {
		HashMap<String , Integer> word=new HashMap<>();
		for(String i : lines) {
			for(String j : i.split(KEY_SPLIT)) {
				j.trim();
				if(!j.isEmpty()) {
					
					if(word.isEmpty()) word.put(j, j.length());
					else {							
						if(!word.containsKey(j)) word.put(j, j.length());
						//else word.put(j, j.length();
					}
					
				}	
			}	
		}
		return word;
	}
	
	public void chmura(Map<String, Integer> mapa) throws FileNotFoundException {
		Random generator = new Random();
		
		int howBig;
		int ii=0;
		
		String part_1 = "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "	<head>\n"
				+ "	 <meta charset='utf-8'>\n"
				+ "	</head>\n"
				+ "<body>\n";
		String part_2 ;
		String part_3 = "</body>\r\n" 
				+ "</html>" ;
		String partAll = "";
		
		partAll=partAll.concat(part_1);
		for(String i : mapa.keySet()) {
			ii++;
			howBig = (int) Math.round((mapa.get(i)/4+10));
			part_2="<div style='position:absolute;"
					+ "	left: "+generator.nextInt(500)+"px; "
					+ "	top: "+generator.nextInt(500)+"px;"
					+ "	font-size: "+ howBig +"px'>"
					+ i + "</div>\n" ;
			partAll=partAll.concat(part_2);
			if(ii==500) break;
			//System.out.println(part_2);
		}
		partAll=partAll.concat(part_3);
		//System.out.println(partAll);
		PrintWriter zapis=new PrintWriter("C:\\xampp\\htdocs\\chmura/index.html");
		zapis.print(partAll);
		zapis.close();
		
	}
	//============================================================================
	// DEFINICJA METODY SORTUJACEJ HashMap po wartosciach
	private static Map<String, Integer> sortByValue(Map<String,Integer> unsortMap) {
		// 1. convertowanie Map na List - list (wewnetrzna zmienna)
		List<Map.Entry<String, Integer>> list= new LinkedList<Map.Entry<String,Integer>>(unsortMap.entrySet());		
		// 2. sortowanie listy za pomocą Collections.sort()
		// zmiana kolejności o1 i o2 zmienia kierunek sortowania
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer> o1,
								Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});		
		// 3. pętla umieszcza wynik w Map
		Map<String,Integer> sortedMap= new LinkedHashMap<String,Integer>();
		for(Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
