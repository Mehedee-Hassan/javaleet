import java.util.Arrays;


class ArrayTest{

	public void swapArrayElement(int[] arr,int fromPos ,int toPos){

		int temp = arr[fromPos];
		arr[fromPos] = arr[toPos];
		arr[toPos] = temp;
		// swaped array positon in place -- > as reference was passed
	}

	public int partition(int[] arr,int low,int high){

		int pivot = arr[high]; // take first element as pivot
		int i = low;     // take low position - 1 


		// from low to high


		for (int j = low ; j < high; j ++){

			if (arr[j] < arr[pivot]){

				// i is in lower position so swap with curren smaller value
				this.swapArrayElement(arr,i,j);

				i ++;
			}


		}

		// swap the pivot position with the i postion as i si the place where we stopped 
		// all the elements in the left is smaller than the pivot

		this.swapArrayElement(arr,i,high);

		return i ;

	}

	public void sort(int[] arr,int low,int high){

		if (low < high){
			// if still some element left in current array
			int getPartitionPoint = partition(arr,low,high);
			this.sort(arr,low,getPartitionPoint-1) ; // pivot at partition point is already sorted
			this.sort(arr,getPartitionPoint + 1 ,high); // pivot at partiiton point is already sorted

		}

	}

	public static void main(String[] args){

		System.out.println("test");

		ArrayTest arrayTest = new ArrayTest();
		int[] toPass = new int[] {1,2,0,10,3};
		

		arrayTest.sort(toPass,0,toPass.length-1);


		System.out.println(Arrays.toString(toPass));
	}






}
