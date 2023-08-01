
public class SlowSort extends Thread{
	
	int block;
	int[] color; 
	Node[] node;
	int check = 0;
	int delay;
	Boolean loopBreak = false;
	
	SlowSort(Node node[],int color[], int block,int check,int delay){
		this.node = node;
		this.color = color;
		this.block = block;
		this.check = check;
		this.delay = delay;
	}
	
	public void run() {
		slowSort(node,0,block-1);
	}
	
	public void slowSort(Node A[], int i, int j){    
	    // Recursion break condition
	    if (i >= j && !loopBreak)
	        return;
	 
	    // Store the middle value
	    int m = (i + j) / 2;
	 
	    // Recursively call with the
	    // left half
	    slowSort(A, i, m);
	 
	    // Recursively call with the
	    // right half
	    slowSort(A, m + 1, j);
	    sleep();
	    // Swap if the first element is
	    // lower than second
	    if (A[j].y < A[m].y)
	    {
	        int temp = A[j].y;
	        A[j].y = A[m].y;
	        A[m].y = temp;
	    }
	 
	    // Recursively call with the
	    // array excluding the maximum
	    // element
	    slowSort(A, i, j - 1);
	}
	
	public void sleep() { try{ Thread.sleep(delay);}catch(Exception e) {} }
	public void setDelay( int delay ) { this.delay = delay; }
	public int returnCheck() { return check; }
	public void setBreak(boolean x) { loopBreak  = x; }
}

