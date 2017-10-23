
/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Jason Steggles    20/09/2017      ***/
/*************************************************/


public class TestSort
{
	public static void main(String[] args) 
    {
        Sort sortTest = new Sort(100);
        
        /** Display comparison counters **/
        
        System.out.println("Insertion Sorts:");
        
        sortTest.readIn("test1.txt");
        sortTest.insertion();
        sortTest.display(100,"Input Array 1");
        System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
        
        sortTest.readIn("test2.txt");
        sortTest.insertion();
        sortTest.display(100, "Input Array 2");
        System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);

        System.out.println("\nQuick Sorts:");
        sortTest.readIn("test1.txt");
        sortTest.quick(0, 99);
        sortTest.display(100,"Input Array 1");
        System.out.println("\n\nQuicksort comparison counter: " + sortTest.compIS);
    }
    
} /** End of Test class **/