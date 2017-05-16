import javax.management.Attribute;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* Stores CSV file as a List of Maps going from Header to the Attribute */
public class CSVReader {
	private String csvFile;
	private String line;
	private String csvSplitBy;
	public List<Map<String, Attribute>> lstMaps;
	String[] headers;

	public CSVReader(String fileDirectory, String recordDelimiter) {
		csvFile = fileDirectory;
		csvSplitBy = recordDelimiter;
		lstMaps = new LinkedList<>();
		String headers[] = new String[1];
		readPlayers();
	}

	private void readPlayers() {
		boolean isHeader = true;

		//String csvFile = "/Users/mkyong/csv/country.csv";
		BufferedReader br = null;
		//String line = "";
		//String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				Map<String, Attribute> itemMap = new HashMap<>();
				if (isHeader) {
					headers = line.split(csvSplitBy);
					isHeader = false;
				} else {
					String[] items = line.split(csvSplitBy);
					for (int i = 0; i < headers.length; i++) {
						String item = items[i];
						if (!item.matches(".*[a-zA-Z]+.*")) {
							itemMap.put(headers[i], new Attribute("Integer", Integer.parseInt(item)));
						} else {
							itemMap.put(headers[i], new Attribute("String", item));
						}
					}
					lstMaps.add(itemMap);
				}

			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void printFile() {
		for (String s : headers) {
			//String spaces =  String.format("%"+(10-s.length())+"s", "");
			System.out.print(s+spaceMaker(25-s.length()));
		}
		System.out.println();
		for (Map m : lstMaps) {
			for (String k : headers) {
				Attribute attr = (Attribute) m.get(k);
				//Integer lensp = attr.getValue().toString().length();
				//String spaces = String.format("%"+(10-lensp)+"s", "");
				System.out.print(attr.getValue()+spaceMaker(25-attr.getValue().toString().length()));
			}
			System.out.println();
		}
	}

	public List<Map<String, Attribute>> compiled() {
		return lstMaps;
	}

	public class Attribute<T> {
		String type;
		T value;

		public Attribute(String type, T value) {
			this.type = type;
			this.value = value;
		}

		public T getValue() {
			return value;
		}
	}

	private String spaceMaker(int count) {
		StringBuilder sb = new StringBuilder(count);
		for (int i=0; i < count; i++){
			sb.append(" ");
		}
		String s = sb.toString();
		return s;
	}

	public String[] getHeaders() {
		return headers;
	}

	public static void main(String[] args) {
		CSVReader csvx = new CSVReader("fut2016_database/fut2016_database.csv",",");
		csvx.printFile();
		csv.getHeaders();
	}
}
