import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @author zhang
 * 
 */
public class TABThreadPool {
	ThreadPoolExecutor threadPoolExecutor = null;
	CreatThread creatThread = null;
	/**
	 * 线程池基本数量
	 */
	private int corePoolSize = 5;
	/**
	 * 最大数量
	 */
	private int maximumPoolSize = 90;
	/**
	 * 空闲的线程活跃时间
	 */
	private long keepAliveTime = 1;
	/**
	 * 单位时间
	 */
	private TimeUnit milliseconds = TimeUnit.HOURS;
	/**
	 * runnableTaskQueue（任务队列）：用于保存等待执行的任务的阻塞队列。 可以选择以下几个阻塞队列。
		ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行排序。
		LinkedBlockingQueue：一个基于链表结构的阻塞队列，此队列按FIFO （先进先出） 排序元素，吞吐量通常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列。
		SynchronousQueue：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，静态工厂方法Executors.newCachedThreadPool使用了这个队列。
		PriorityBlockingQueue：一个具有优先级的无限阻塞队列。
	 */
	private BlockingQueue<Runnable> runnableTaskQueue = new ArrayBlockingQueue<Runnable>(corePoolSize);
	/**
	 * RejectedExecutionHandler（饱和策略）：当队列和线程池都满了，说明线程池处于饱和状态，那么必须采取一种策略处理提交的新任务。这个策略默认情况下是AbortPolicy，表示无法处理新任务时抛出异常。以下是JDK1.5提供的四种策略。
		AbortPolicy：直接抛出异常。
		CallerRunsPolicy：只用调用者所在线程来运行任务。
		DiscardOldestPolicy：丢弃队列里最近的一个任务，并执行当前任务。
		DiscardPolicy：不处理，丢弃掉。
		当然也可以根据应用场景需要来实现RejectedExecutionHandler接口自定义策略。如记录日志或持久化不能处理的任务。
	 */
	private ThreadFactory handler = (ThreadFactory) new AbortPolicy();

	/**
	 * 
	 */
	TABThreadPool() {

	}

	/**
	 * @author zhang
	 *
	 */
	private class CreatThread {

		private CreatThread() {
			threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
					maximumPoolSize, keepAliveTime, milliseconds,
					runnableTaskQueue, handler);
		}
	}

	/**
	 * @return
	 */
	public ThreadPoolExecutor getInstance() {
		if (null == creatThread) {
			synchronized ("lock") {
				if (null == creatThread) {
					creatThread = new CreatThread();
					return threadPoolExecutor;
				} else {
					return threadPoolExecutor;
				}
			}
		}
		return threadPoolExecutor;
	}
}
