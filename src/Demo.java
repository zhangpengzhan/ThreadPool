



/**
 * @author zhang
 *
 */
public class Demo {

	public static void main(String[] args) {
		System.out.println("==="+System.currentTimeMillis());
		TABDataManager.getEntity(TAB.APP);
		System.out.println("==="+System.currentTimeMillis());
	}
}
