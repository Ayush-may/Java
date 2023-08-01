
public class QuickSort extends Thread{

	int block;
	int[] color; 
	Node[] node;
	int check = 0;
	int delay;
	Boolean loopBreak = false;

	QuickSort(Node node[],int color[], int block,int check,int delay){
		this.node = node;
		this.color = color;
		this.block = block;
		this.check = check;
		this.delay = delay;
	}
	
	public void run() {
		quickSort(node,0,block-1);
	}
	
	 public void quickSort(Node array[], int low, int high) {
		    if (low < high && !loopBreak) {
		      int pi = partition(array, low, high);
		      quickSort(array, low, pi - 1);
		      quickSort(array, pi + 1, high);
		    }
	 }
	
	 public int partition(Node array[], int low, int high) {
		    
		    int pivot = array[high].y;
		    
		    int i = (low - 1);

		    for (int j = low; j < high; j++) {
		      if (array[j].y<= pivot) {
		        i++;
		        sleep();
		        int temp = array[i].y;
		        array[i].y = array[j].y;
		        array[j].y = temp;
		      }
		    }
		    int temp = array[i + 1].y;
		    array[i + 1].y = array[high].y;
		    array[high].y = temp;

		    return (i + 1);
		  }
	 
		public void sleep() { try{ Thread.sleep(delay);}catch(Exception e) {} }
		public void setDelay( int delay ) { this.delay = delay; }
		public int returnCheck() { return check; }
		public void setBreak(boolean x) { loopBreak  = x; }
}
