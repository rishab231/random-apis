## CSVReader

While working on a large dataset in Java, I came across a need to create an efficient way to store CSV files. This API reads in a CSV file for you using Java's `BufferedReader` and stores it as a list of maps from Header (Stored as a `String`) -> `Attribute`, which is a wrapper class around either an `Integer` or a `String`. (This can be modified for other types such as `Double` as well as other User-Defined Classes).

### Prerequisites

This program works with any CSV file where there are no missing items in rows/columns or the missing items have been adequately trimmed/winsorized. The program also allows you to specify your own record delimiter; "," is the default.

```java
public CSVReader(String fileDirectory, String recordDelimiter=",");
```
where `fileDirectory` is the location of the file. For example, "databases/players.csv".

### Methods

I have included two methods `getHeaders` and `printFile`. Their API is given below

```java
public String[] getHeaders; // Returns the column headers (first line of the CSV) as an Array of Strings

/* Returns the contents of the file in a List of Maps format. 
The maps have the column header as a key and an `Attribute` (Wrapper class) as value. 
As a result, each row is represesnted as a map in the list. 
*/
public List<Map<String, Attribute>> compiled() {
	return lstMaps; // lstMaps is constructed in the constructor of CSVReader itself using the private method readmyFile
}
```

#### Testing

I have included a personal test in the main function of the class. The file contains only 2 data types - namely Strings and Integers. The function, upon running, returned the correct output for both functions.

```java
public static void main(String[] args) {
		CSVReader csvx = new CSVReader("fut2016_database/fut2016_database.csv",",");
		csvx.printFile();
		String[] myHeaders = csv.getHeaders();
		for (String s : myHeaders) {
			System.out.println(s+" ");
		}
	}
```


### Built With

[IntelliJ for Java](https://www.jetbrains.com/idea/) 

### Author

* **Rishab Srivastava** - [Data Spelunking](https://rishab231.github.io/)

## Acknowledgments

* [Mkyong.com](https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/)
* Inspiration