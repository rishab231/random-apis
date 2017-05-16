import java.util.*;

public class SparseMatrix<T> {
	Map<Integer, Map<Integer, T>> matrix;
	int numRows = 0;
	int numCols = 0; // Length of the longest row

	// Initializes a new SparseMatrix
	public SparseMatrix() {
		matrix = new HashMap();
	}

	// Initializes an N by M matrix
	public SparseMatrix(int N, int M) {
		matrix = new HashMap();
		numRows = N;
		numCols = M;
	}

	public void put(int N, int M, T item) {
		Map<Integer, T> reqdRow = matrix.get(N);
		if (reqdRow==null) {
			matrix.put(N, new HashMap<Integer, T>());
			matrix.get(N).put(M, item);
		} else {
			reqdRow.put(M, item);
		}
	}

	public void setRows(int N) {
		numRows = N;
	}

	public void setCols(int M) {
		numCols = M;
	}

	// Prints out the matrix
	public void print() {
		System.out.print("[");
		if (numRows==0) {
			System.out.println("Matrix is empty");
			return;
		} else if (numCols==0) {
			for (int i = 1; i <= numRows; i++) {
				System.out.println("[]");
			}
			return;
		} else {
			for (int i = 1; i <= numRows; i++) {
				if (i!=1) {
					System.out.println();
				}
				System.out.print("[");
				Map<Integer, T> reqdRow = matrix.get(i);
				if (reqdRow==null) {
					System.out.println(new String(new char[numCols]).replace("\0", "NOVALUE ").trim()+"]");
				} else {
					for (int j = 1; j <= numCols; j++) {
						T item = matrix.get(i).get(j);
						if (item==null) {
							System.out.print("NOVALUE ");
						} else {
							System.out.print(item + " ");
						}
					}
					System.out.print("]");
				}
			}
		}
		System.out.println("]");
	}

	// Return the item in the row N and column M
	public T get(int N, int M) {
		return matrix.get(N).get(M);
	}

	// Prints the Nth row of the matrix
	public void printRow(int x) {
		Map<Integer, T> row = matrix.get(x);
		if (row==null) {
			System.out.println("[]");
		} else {
			System.out.print("[");
			for (int i = 1; i <= numCols; i++) {
				T item = row.get(i);
				if (item==null) {
					System.out.print("NOVALUE ");
				} else {
					System.out.print(item+" ");
				}
			}
			System.out.print("]");
		}
		System.out.println();
	}

	// Get the Nth row of matrix as a list
	public List<T> getRow(int N) {
		List<T> items = new LinkedList<T>();
		Map<Integer, T> reqdRow = matrix.get(N);
		for (int i = 1; i <= numCols; i++) {
			items.add(reqdRow.get(i));
		}
		return items;
	}

	// Prints the Mth column of the matrix
	public void printCol(int M) {
		for (int i = 1; i <= numRows; i++) {
			Map<Integer, T> tRow = matrix.get(i);
			if (tRow==null) {
				System.out.println("NOVALUE");
			}
			T item = tRow.get(M);
			if (item==null) {
				System.out.println("NOVALUE");
			} else {
				System.out.println(item);
			}
		}
	}

	// Get the Mth column of matrix as a list
	public List<T> getCol(int M) {
		List<T> items = new LinkedList<T>();
		for (int i = 1; i <= numRows; i++) {
			Map<Integer, T> tRow = matrix.get(i);
			if (tRow==null) {
				items.add(null);
			} else {
				T prom = tRow.get(M);
				items.add(prom);
			}
		}
		return items;
	}

	public static void main(String[]args) {
		SparseMatrix<Integer> check = new SparseMatrix<>(3,4);
		check.put(2,1,100);
		check.put(3,2,10);
		check.put(1,1,12);
		check.put(2,2,34);
		check.print();
		System.out.println("=========");
		List<Integer> secondRow = check.getRow(2);
		for (Object r2 : secondRow) {
			System.out.println(r2);
		}
		System.out.println("=========");
		List<Integer> secondCol = check.getCol(2);
		for (Object c2 : secondCol) {
			System.out.println(c2);
		}
		System.out.println("=========");
		check.printCol(4);
		System.out.println("=========");
		check.printRow(2);
		System.out.println("=========");
		double currPoints = 531.93;
		double goldPoints = 7.212;
		double finalScore = 115;
		double sumScores = 91.83 + 62.1 + finalScore;
		double additionalPoints = 2*(goldPoints-goldPoints*sumScores/400);
		System.out.println(currPoints+6+finalScore+additionalPoints);
	}
}