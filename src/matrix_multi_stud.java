/******************************************************************************
 *
 *	Required Tasks:
 *	1. Complete methods 
 *
 *	   multiply1(): Non-recursive conventional matrix multiplication
 *	   multiply2(): Simple divide and conquer matrix multiplication
 *	   multiply3(): Strassen Matrix Multiplication
 *
 * 	   each method:
 *	   	input: A B matrices; 
 *	   	output: return a result matrix, say C
 *
 *	2. Run quick test to ensure your program is working properly
 *	   debug = true		
 *	   int n=16;	    // can adjust size of matrices 
 *	   int baseSize=1   // can adjust base case size of recursive methods
 *	   int repeat=1	    // number of repetitions to compute 
 *	                    // result of same set matrices A, B
 *
 *	3. Run pre-defined long tests to completed required table
 *	   debug = false
 *
 *	Do not change other parts of the programs, 
 *	unless you know what you are doing.
 *
 **************************************************************/

import java.util.*;

class MatrixMultiply { 

	static boolean debug = true; // for quick checking
	static int n=2048;       // size of matrices
	static int baseSize=16; // adjust base case size for recursive methods
	static int repeat=1;   // number of repetitions for same set of matrices


	// Non-recursive conventional matrix multiplication
	static int[][] multiply1(int A[][], int B[][]) 
	{

		int n = A.length; //A row
		int C[][] = new int[n][n];


		// implement the conventional matrix multiplication
		for(int i = 0; i < n; i++){
			for(int k = 0; k < n; k++) {
				for (int j = 0; j < n; j++) {
//					result = (A[i][j]) * (B[j][k]);
//					C[i][k] += result;
					C[i][k] += (A[i][j]) * (B[j][k]);
				}
			}
		}
		return C;

	} 


	// Simple divide and conquer matrix multiplication
    	static int[][] Multiply2(int[][] A, int[][] B) {
        	int n = A.length;
        	int split = (n/2);
        	int[][] C11,C12,C21,C22;
			int[][] A11,A12,A21,A22;
			int[][] B11,B12,B21,B22;
        	int[][] C = new int[n][n];

		// if the input matrix size is <= base case size, 
		// call multiply1() directly
        	if (n <= baseSize) {
	    	    C = multiply1(A, B); 
        	} else {
                    // implement the recursive part
		    
                    // Split A to 4 n/2 X n/2 matrices: A11, A12, A21, A22


					// Split B to 4 n/2 X n/2 matrices: B11, B12, B21, B22


				//Filling A11
				A11 = splitMatrix(0,split,0,split,0,0,A,split);
				//Filling A12
				A12 = splitMatrix(0,split,split,n,0,split,A,split);
				//Filling A21
				A21 = splitMatrix(split,n,0,split,split,0,A,split);
				//Filling A22
				A22 = splitMatrix(split,n,split,n,split,split,A,split);
				//Filling B11
				B11 = splitMatrix(0,split,0,split,0,0,B,split);
				//Filling B12
				B12 = splitMatrix(0,split,split,n,0,split,B,split);
				//Filling B21
				B21 = splitMatrix(split,n,0,split,split,0,B,split);
				//Filling B22
				B22 = splitMatrix(split,n,split,n,split,split,B,split);

//					//Filling up A11
//					for(int i = 0; i < split; i++){
//						for(int j = 0; j < split; j++){
//							A11[i][j] = A[i][j];
//						}
//					}
//					//Filling up A12
//					for(int i = 0; i < split; i++){
//						for(int j = split; j < n; j++){
//							A12[i][j - split] = A[i][j];
//						}
//					}
//					//Filling up A21
//					for(int i = split; i < n; i++){
//						for(int j = 0; j < split; j++){
//							A21[i - split][j] = A[i][j];
//						}
//					}
//					//Filling up A22
//					for(int i = split; i < n; i++){
//						for(int j = split; j < n; j++){
//							A22[i - split][j - split] = A[i][j];
//						}
//					}
//					//Filling up B11
//					for(int i = 0; i < split; i++){
//						for(int j = 0; j < split; j++){
//							B11[i][j] = B[i][j];
//						}
//					}
//					//Filling up B12
//					for(int i = 0; i < split; i++){
//						for(int j = split; j < n; j++){
//							B12[i][j - split] = B[i][j];
//						}
//					}
//					//Filling up B21
//					for(int i = split; i < n; i++){
//						for(int j = 0; j < split; j++){
//							B21[i - split][j] = B[i][j];
//						}
//					}
//					//Filling up B22
//					for(int i = split; i < n; i++){
//						for(int j = split; j < n; j++){
//							B22[i- split][j - split] = B[i][j];
//						}
//					}
		    // Compute 8 n/2 * n/2 matrix multiplication recursively
            	    // A11 * B11
				C11 = addMatrices(Multiply2(A11, B11) ,Multiply2(A12, B21));
		    // A12 * B21
				C12 = addMatrices(Multiply2(A11, B12) ,Multiply2(A12, B22));
                    // A11 * B12
				C21 = addMatrices(Multiply2(A21, B11) ,Multiply2(A22, B21));
		    // A12 * B22
				C22 = addMatrices(Multiply2(A21, B12) ,Multiply2(A22, B22));
                    // A21 * B11
//				r5 = Multiply2(A21, B11);
//		    // A22 * B21
//				r6 = Multiply2(A22, B21);
//	            // A21 * B12
//				r7 = Multiply2(A21, B12);
//		    // A22 * B22
//				r8 = Multiply2(A22, B22);
		    //
		    // Combine results to get C11, C12, C21, C22
            	    // C11 = A11 * B11 + A12 * B21
                    // C12 = A11 * B12 + A12 * B22
                    // C21 = A21 * B11 + A22 * B21
	            // C22 = A21 * B12 + A22 * B22


//				C11 = addMatrices(r1,r2);
//				C12 = addMatrices(r3,r4);
//				C21 = addMatrices(r5,r6);
//				C22 = addMatrices(r7,r8);

 	    	    // Grouping the results obtained in a result matrix C
//				for(int i = 0; i < n; i++) {
//					for(int j = 0; j < n; j++) {
////						C = myList.toArray(C);
//						C[i][j] += C11[i][j] + C12[i][j] + C21[i][j] + C22[i][j];
//					}
//				}
				combine(C11, C, 0,0);
				combine(C12, C, 0, split);
				combine(C21, C, split, 0);
				combine(C22, C, split,split);
                }
            return C;
    	}

	private static void combine(int[][] subMat, int[][]mainMat, int startI, int startJ) {
		for(int i = 0; i < subMat.length ; i++) {
			for(int j = 0; j < subMat.length; j++) {

				mainMat[i + startI][j + startJ] = subMat[i][j];
			}
		}
	}
	// Strassen Matrix Multiplication
        static int[][] Multiply3(int[][] A, int[][] B) {
		int [][] a,b,c,d,e,f,g,h;
        	int n = A.length;
        	int split = n/2;
        	int[][] C= new int [n][n];
        	int [][] p1,p2,p3,p4,p5,p6,p7,C11,C12,C21,C22;

		// if the input matrix size is <= base case size, 
		// call multiply1() directly
        	if (n <= baseSize) {
	    	    C = multiply1(A, B); 
        	} else {

                    // implement the recursive part

                    // Split A to 4 n/2 X n/2 matrices: a, b, c, d
				a = splitMatrix(0,split,0,split,0,0,A,split);

				b = splitMatrix(0,split,split,n,0,split,A,split);

				c = splitMatrix(split,n,0,split,split,0,A,split);

				d = splitMatrix(split,n,split,n,split,split,A,split);

				e = splitMatrix(0,split,0,split,0,0,B,split);

				f = splitMatrix(0,split,split,n,0,split,B,split);

				g = splitMatrix(split,n,0,split,split,0,B,split);

				h = splitMatrix(split,n,split,n,split,split,B,split);
                    // Split B to 4 n/2 X n/2 matrices: e, f, g, h

		    // Compute 7 n/2 X n/2 matrix multiplication recursively
                    //	 p1 = (a + d)(e + h)
						p1 = Multiply3(addMatrices(a,d), addMatrices(e,h));
              	    //	 p2 = (c + d)e
						p2 = Multiply3(addMatrices(c,d),e);
                    //	 p3 = a(f - h)
						p3 = Multiply3(a,subMatrices(f,h));
                    //	 p4 = d(g - e)
						p4 = Multiply3(d,subMatrices(g,e));
                    //	 p5 = (a + b)h
						p5 = Multiply3(addMatrices(a,b), h);
                    //	 p6 = (c - a) (e + f)
						p6 = Multiply3(subMatrices(c,a), addMatrices(e,f));
                    //	 p7 = (b - d) (g + h)
						p7 = Multiply3(subMatrices(b,d), addMatrices(g,h));
           
           	    // Combine results to get C11, C12, C21, C22
              	    //	 C11 = p1 + p4 - p5 + p7
						C11 = addMatrices(subMatrices(addMatrices(p1,p4), p5),p7);
                    //	 C12 = p3 + p5
						C12 = addMatrices(p3,p5);
                    //	 C21 = p2 + p4
						C21 = addMatrices(p2, p4);
              	    //	 C22 = p1 - p2 + p3 + p6
						C22 = addMatrices(addMatrices(subMatrices(p1,p2),p3),p6);
           
 	    	    // Grouping the results obtained in a result matrix C
				combine(C11, C, 0,0);
				combine(C12, C, 0, split);
				combine(C21, C, split, 0);
				combine(C22, C, split,split);
        	  }
            return C;
    	}        

	//=======================================
	//     Do not change anything below 
	//=======================================
    
    	// Helper methods 
	
    	// Function to print a matrix M
    	static void printMatrix(int M[][]) 
    	{ 
        	int n = M.length;
		for (int i = 0; i < n; i++)  {
			for (int j = 0; j < n; j++) 
				System.out.print(M[i][j] + " "); 
			System.out.println(); 
		}
    	}

    	
    	// Adding 2 matrices C=A+B
    	static int[][] addMatrices(int[][] A, int[][] B) {
        	int n = A.length;
        	int[][] C = new int[n][n];
        	for (int i = 0; i < n; i++) 
            		for (int j = 0; j < n; j++) 
                		C[i][j] = A[i][j] + B[i][j];
        	return C;
    	}

    	// Subtracting 2 matrices C=A-B
    	static int[][] subMatrices(int[][] A, int[][] B) {
        	int n = A.length;
        	int[][] C= new int[n][n];
        	for (int i = 0; i < n; i++) 
            		for (int j = 0; j < n; j++) 
                		C[i][j] = A[i][j] - B[i][j];
        	return C;
    	}

	// Generate a matrix with random data of size n x n
    	static int[][] generateRandomMatrix(int n) {
        	int[][] A = new int[n][n];
		int max = 100;
		Random rand = new Random();

        	for (int i = 0; i < n; i++) 
            		for (int j = 0; j < n; j++) 
				A[i][j] = rand.nextInt(max);
		return A;
   	}
   	private static int[][] splitMatrix(int startI, int endI, int startJ, int endJ, int adjustI, int adjustJ, int[][] main, int size){
		int sub[][] = new int[size][size];
		for(int i = startI; i < endI; i++){
			for(int j = startJ; j < endJ; j++){
				sub[i-adjustI][j-adjustJ] = main[i][j];
			}
		}
		return sub;
	}


	//======================================================================
	// Run Test cases : main()  ->  runTest()
	// These tests are driven by class data values:
	//    boolean debug = true; // for quick checking
	//    int n=16;       	    // size of matrices
        //    int baseSize=1; 	    // adjust base case for recursive method
        //    int repeat=1;   	    // number of repetitions for same matrices
	//======================================================================


    	private static void runTest() {
    	    	int[][] A = null;  
    	    	int[][] B = null;
    	    	int[][] C = null;
		long startTime=0;
		long endTime=0;
		long avg1 = 0;
		long avg2 = 0;
		long avg3 = 0;

		System.out.println("Matrix size: " + n); 
		System.out.println("Recursive base case size: " + baseSize); 

    		A = generateRandomMatrix(n);
    		B = generateRandomMatrix(n);
    		C = null;
		for (int j=1; j <= repeat; j++) {

	        	if (debug) { 
				System.out.println("\nMatrix A:"); 
				printMatrix(A); 
				System.out.println("\nMatrix B:"); 
				printMatrix(B); 
				System.out.println("\nResults: "); 
			}

			startTime= System.currentTimeMillis();
			C = multiply1(A, B);
			endTime= System.currentTimeMillis();
			avg1 += endTime-startTime;
	        	if (debug & (C !=null)) 
				{ printMatrix(C); System.out.println(); }

			startTime= System.currentTimeMillis();
			C = Multiply2(A, B);
			endTime= System.currentTimeMillis();
			avg2 += endTime-startTime;
	        	if (debug & (C !=null)) 
				{ printMatrix(C); System.out.println(); }

			startTime= System.currentTimeMillis();
			C = Multiply3(A, B);
			endTime= System.currentTimeMillis();
			avg3 += endTime-startTime;
	        	if (debug & (C !=null)) 
				{ printMatrix(C); System.out.println(); }

		}
		System.out.println("Number of loops: " + repeat); 
		System.out.println("\nNon-recursive method average time = \t "+ (avg1/repeat));
		System.out.println("Divide and conquer method average time = "+ (avg2/repeat));
		System.out.println("Strassen method average time = \t\t "+(avg3/repeat));
		System.out.println("\n=======================================================\n"); 
	}

	// Main Test Driver - call runTest() methods 
	public static void main(String[] args) 
	{ 

	    if (debug) {  	// debug true
    		runTest(); 	// quick test using default 16 X 16 matrices 
	    } else {		// debug = false
	        int number=11; 	// number of runs, see n values below
		repeat=5;	// run 5 times each method for same set of data
	    	for (int i=1; i<=number; i++) {
			n = (int) Math.pow(2,i); // n = 2, 4, 8, ..., 1024, 2048

			if (n >= 256) {  
				// for n >= 256, change base case size: 4, 8, 16
				baseSize=4;
    				runTest(); 
				baseSize=8;
    				runTest(); 
				baseSize=16;
    				runTest(); 
			} else {
				// for n < 256, base case is 1
    				runTest(); 
			}
	        } 
	   }
     }
}
