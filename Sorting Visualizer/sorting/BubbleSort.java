
public class BubbleSort extends Thread {
	
	int block;
	int[] color; 
	Node[] node;
	int check = 0;
	int delay;
	Boolean loopBreak = false;
	
	
	BubbleSort(Node node[],int color[], int block,int check,int delay){
		this.node = node;
		this.color = color;
		this.block = block;
		this.check = check;
		this.delay = delay;
	}

	@Override
	public void run() {
		bubbleSort();
	}
	
	public void bubbleSort() {
//		  int i, j;
		    boolean swapped;
		    for (int i = 0; i < block - 1; i++) {
		        swapped = false;
		        for (int j = 0; j < block - i - 1; j++) {
//		        	color[j] = 1;
//		        	color[j+1] = 1;
		            if (node[j].y < node[j + 1].y) {
		                int temp = node[j].y;
		                node[j].y = node[j+1].y;
		                node[j+1].y = temp;
		                swapped = true;
		            }
		            if(loopBreak) {
			        	loopBreak = false;
			        	break;
			        }
		            sleep();
//		            color[j] = 0;
//		        	color[j+1] = 0;
		        }
		        // If no two elements were swapped by inner loop,
		        // then break
		        if(loopBreak) {
		        	loopBreak = false;
		        	break;
		        }
		        if (swapped == false)
		            break;
		    }
		    check = 1;
//		    this.interrupt();
		    System.out.println("Interrupted ");
		    
	}
	
	public void changeToWhite() {
		
		for(int i=0;i<color.length;i++) {
			System.out.println("Change to white");
			color[i] = 0;
		}
	}
	
	public void sleep() { try{ Thread.sleep(delay);}catch(Exception e) {} }
	
	public void setDelay( int delay ) { this.delay = delay; }	
	
	public int returnCheck() { return check; }
	
	public void setBreak(boolean x) { loopBreak  = x; }
}
