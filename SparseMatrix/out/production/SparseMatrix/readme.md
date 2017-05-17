## Sparse Matrix / 2D Array

While working on a large dataset in Java, I came across a need to create an efficient way to create a very sparse matrix i.e. one with a large number of 0/Null/NaN values. This API gives an slightly better alternative way to store and perform operations on such values.

### Prerequisites
All items (Integer, Float, Double et all.), including user defined objects can be stored in the array.

```java
public class SparseMatrix<T> {

	public void put(int N, int M, T item) // Puts an item T in row N and column M
	public void print() // Prints out the matrix
	public T get(int N, int M) // Get the item in row N and column M
	public void printRow(int x) // Prints the Nth row of the matrix
	public List<T> getRow(int N) // Get the Nth row of matrix as a list
	public void printCol(int M) // Prints the Mth column of the matrix
	public List<T> getCol(int M) // Get the Mth column of matrix as a list
}
```

### Running the tests

I have included a ```SparseMatrixTester``` class to test the main class. Feel free to modify it to include tests for your specific 2D array.

#### Test #1: Placeholder

Explain what this test does and why

```java
public static void main()
```

#### Test #1: Placeholder

Explain what this test does and why

```java
public static void main()
```

#### Test #1: Placeholder

Explain what this test does and why

```java
public static void main()
```

### Built With

[IntelliJ for Java](http://www.dropwizard.io/1.0.2/docs/) 

### Author

* **Rishab Srivastava** - [Data Spelunking](https://rishab231.github.io/)

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc