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

I have included a basic `SparseMatrixTester` class to test the main class. Feel free to modify it to include tests for your specific 2D array.

#### Test #1: Tests the print function of the class

Instead of using `assertEquals` to checking if the print functionality works correctly. This prints out both the observed as well as the expected output to the console and allows the user to judge the differences themselves.

```java
public void printTest();
```

#### Test #2: Tests if the correct row is returned by the program

```java
public void getRowTester();
```

#### Test #3: Tests if the correct column is returned by the program

```java
public void getColTester();
```

#### Test #4: Tests if the correct item of the matrix is returned by the program

```java
public void getTester();
```


### Built With

[IntelliJ for Java](https://www.jetbrains.com/idea/) 

### Author

* **Rishab Srivastava** - [Data Spelunking](https://rishab231.github.io/)