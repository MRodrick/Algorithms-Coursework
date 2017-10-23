/*****************************************************/
/*** Purpose:                                      ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/17   ***/
/***     Extended by: Your Name    Date            ***/
/*****************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

	/** Array of integers to sort **/
	private int[] A;

	/** Size of the array **/
	private int size;

	/** Number of elements actually used in array **/
	private int usedSize;

	/** Global variables for counting sort comparisons **/
	public int compIS;
	/** Global comparison count for Insertion Sort **/
	public int compQS;
	/** Global comparison count for Quicksort **/
	public int compNewS;

	/** Global comparison count for new sort **/

	/*****************/
	/** Constructor **/
	/*****************/
	Sort(int max) {
		/** Initialiase global sort count variables **/
		compIS = 0;
		compQS = 0;
		compNewS = 0;

		/** Initialise size variables **/
		usedSize = 0;
		size = max;

		/** Create Array of Integers **/
		A = new int[size];
	}

	/***************************/
	/**** Insertion Sort *******/
	/***************************/
	public void insertion() {
		int key = 0;
		int j;
		for (int i = 0; i < usedSize;) {
			key = A[i];
			j = i;
			while (j > 0 && key < A[j - 1]) {
				compIS++;
				A[j] = A[j - 1];
				j = j - 1;
			}
			A[j] = key;
			i++;
		}
	}

	/***************************/
	/******* Quick Sort ********/
	/***************************/
	public void quick(int L, int R) {
		int p;
			if (R > L) {
				p = partition(L, R);
				quick(L, p - 1);
				quick(p + 1, R);
			}
		
	}

	public int partition(int left, int right) {
		int pL = left;
		int pR = right;
		int v = A[pR];
		int leftH;
		int rightH;
		while (pL < pR) {
			while (A[pL] < v) { // THINK THIS IS THE LINE THAT ISNT WORKING :(
				pL++;
			}
			while (A[pR] >= v && pR > pL) {
				pR--;
			}
			if (pL < pR) {
			leftH = A[pL];
			A[pL] = A[pR];
			A[pR] = leftH;
			}
		}
		rightH = A[pR];
		A[pR] = A[pL];
		A[pL] = rightH;
		return pL;
	}
	/***************************/
	/******** New Sort *********/
	/***************************/
	public void newsort() {
		int min, pos, i, iHold;
		pos = 0;
		while(pos<A.length) {
			min = A[pos];
			for(i = pos; i <= A.length - 1;) {
				if(A[i]==min) {
					iHold = i;
					A[i] = A[pos];
					A[pos] = A[iHold];
					pos = pos + 1;
				}
			}
		}
		Algorithm newSort
		Inputs A: Array of Integers
		Variables min,pos,i: Integer
		Begin
		pos:=0
		while (pos<size(A)) do
		min:=findMinFrom(A,pos)
		 for i:=pos to size(A)-1 do
		if (A[i]=min) then
		swap(A,i,pos)
		pos:=pos+1
		fi
		od
		od
		End
		The function findMinFrom(A,pos) simply returns the minimum value in the
		elements A[pos],A[pos+1],…,A[size(A)-1] and is defined by the pseudo
		code below:
		Algorithm findMinFrom(A,pos)
		Inputs A: Array of Integers; pos: Integer
		Variables min,i: Integer
		Begin
		min:=A[pos]
		 for i:=pos+1 to size(A)-1 do
		if (A[i]<min) then
		min:=A[i]
		fi
		od
		return min
		End
	}
	/*********************************************/
	/*** Read a file of integers into an array ***/
	/*********************************************/
	public void readIn(String file) {
		try {
			/** Initialise loop variable **/
			usedSize = 0;

			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data while array not full **/
			while (in.hasNextInt() && (usedSize < size)) {
				A[usedSize] = in.nextInt();
				usedSize++;
			}

		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	/**********************/
	/*** Display array ***/
	/**********************/
	public void display(int line, String header) {
		/*** Integer Formatter - three digits ***/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n" + header);

		/** Display array data **/
		for (int i = 0; i < usedSize; i++) {
			/** Check if new line is needed **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display an array element **/
			System.out.print(FI.format(A[i]) + " ");
		}
	}
} /** End of Sort Class **/