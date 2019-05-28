
public interface ringBufferInterface {
	public boolean isEmpty();
	public int size();
	public boolean isFull();
	public void enqueue(double item);
	public double dequeue();
	public double peek();
}
