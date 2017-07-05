import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by rishabsrivastava on 17/05/17.
 */
public class SparseMatrixTester {

    @Test
    public void printTest () {
        SparseMatrix<Integer> check = putter();
        check.print();
        System.out.println("===============");
        System.out.println("Expected output");
        System.out.println("[[12 NOVALUE NOVALUE NOVALUE ]\n" +
                "[100 34 NOVALUE NOVALUE ]\n" +
                "[NOVALUE 10 NOVALUE NOVALUE ]]");
    }

    private SparseMatrix<Integer> putter() {
        SparseMatrix<Integer> check = new SparseMatrix<>(3,4);
        check.put(2,1,100);
        check.put(3,2,10);
        check.put(1,1,12);
        check.put(2,2,34);
        return check;
    }

    @Test
    public void getRowTester () {
        SparseMatrix<Integer> check = putter();
        assertEquals((int) check.getRow(1).get(0), 12);
        assertEquals(check.getRow(1).get(1), null);
    }

    @Test
    public void getColTester () {
        SparseMatrix<Integer> check = putter();
        assertEquals((int) check.getCol(1).get(0), 12);
        assertEquals((int) check.getCol(1).get(1), 100);
        assertEquals(check.getRow(1).get(2), null);
    }

    @Test
    public void getTester () {
        SparseMatrix<Integer> check = putter();
        assertEquals((int) check.get(2,2), 34);
        assertEquals(check.get(1,4), null);
        assertEquals((int) check.get(3,2), 10);
    }
}
