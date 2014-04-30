
public interface QueueInterface<E> {
	public void	enqueue	(E item);
	public E	dequeue		();
	public E	peekFirst	();
	public E	peekLast	();
	public int	size		();
}
