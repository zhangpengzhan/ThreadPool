

import java.util.List;

import android.util.Log;

public class TABEntity {
	/**
	 * @Fields serialVersionUID
	 */
	/**
	 * @Fields list
	 */
	List<?> list;
	public TABEntity(List<?> gameListEntity) {
	//	Log.d("A::::", "list:::::"+gameListEntity);
		this.list = gameListEntity;
	}
	public void setList(List<?> list){
		this.list = list;
	}
	public List<?> getList(){
//		Log.d("A::::", "list:"+list);
		return this.list;
	}
	
}

