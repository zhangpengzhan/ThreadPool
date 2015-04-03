import java.util.concurrent.TimeUnit;

import android.util.Log;

/**
 * @ClassName: TABDataMap
 * @Description:
 * @author: zhangpengzhan
 * @param <E>
 * @date 2015年4月2日 上午11:59:14
 * 
 */
public class TABDataManager {

	/**
	 * @Fields entities
	 */
	private static TABEntity[] entities = new TABEntity[8];
	/**
	 * 阻塞时长
	 */
	private static long timeOut = 50000;

	/**
	 * 
	 * @Title: TABDataMap
	 * @author:张鹏展
	 * @Description:
	 * @return
	 */
	private static TABEntity getData(TAB tab) {
		/*
		 * Log.d("A::::", tab.getTabIndex() + ":::entity::::::" +
		 * entities[tab.getTabIndex()]); Log.d("A::::", "entity-list::::::" +
		 * entities[tab.getTabIndex()]);
		 */
		return getTABEntites()[tab.getTabIndex()];

	}

	/**
	 * 对外公开的获取entity的方法
	 * 
	 * @param tab
	 * @return
	 */
	public static TABEntity getEntity(final TAB tab) {
		TABEntity tabEntity = null;
		long beginTime = System.currentTimeMillis();
		do {
			tabEntity = getData(tab);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				continue;
			}
			if ((System.currentTimeMillis() - beginTime) >= timeOut) {
				break;
			}
			continue;
		} while (tabEntity == null);

		return tabEntity;
	}

	/**
	 * 对外提供的set 数据的方法
	 * 
	 * @param tab
	 * @param entity
	 */
	public static void setEntity(TAB tab, TABEntity entity) {
		setData(tab, entity);
	}

	/**
	 * 
	 * @Title: TABDataMap
	 * @author:张鹏展
	 * @Description:
	 * @return
	 */
	private static void setData(TAB tab, TABEntity tabEntity) {
		// Log.d("A::::", +tab.getTabIndex() + "::::entity" + tabEntity);
		getTABEntites()[tab.getTabIndex()] = tabEntity;
	}

	private static synchronized TABEntity[] getTABEntites() {
		return entities;
	}

}
