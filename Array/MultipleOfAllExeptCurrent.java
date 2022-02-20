// using camelCase as varname and method name
// PascalCase for class name

import java.util.Arrays;

class MultipleOfAllExeptCurrent  
{  
  public static int[] findProduct(int arr[])  
  {    
    int [] result = { 0 };
    int inputArrayLen = arr.length;

    int[] leftToRight = new int[inputArrayLen];
    int[] rightToLeft= new int[inputArrayLen];
    // 1. product all element from left to right
    // 2. product all element from right to left
    // 3. for each position we will multiply previous and next element in the left,right array
    // 4. complexity O(N) ,space O(2N)


    int i = inputArrayLen -2; 


    rightToLeft[inputArrayLen-1] = arr[inputArrayLen-1];
    leftToRight[0] = arr[0];
    for(int j = 1 ; j < inputArrayLen ; j ++){
      
      leftToRight[j] = arr[j] * leftToRight[j-1];
      rightToLeft[i] = arr[i] * rightToLeft[i+1]; 
      
      i --;

    }

    //System.out.println(Arrays.toString(leftToRight));
    //System.out.println(Arrays.toString(rightToLeft)); // debug

    result = new int[inputArrayLen];
    
    result[0] = rightToLeft[1];                                // only from the right except first
    result[inputArrayLen-1] = leftToRight[inputArrayLen-2];   // only last from the left except current
    
    for (i = 1 ; i < inputArrayLen -1; i ++){
        result[i] = leftToRight[i-1] * rightToLeft[i + 1];
    }


    return result; 
   } 
} 
