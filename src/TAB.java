/**
	 * @ClassName: TAB
	 * @Description:
	 * @author: zhangpengzhan
	 * @date 2015年4月2日 下午1:40:29
	 * 
	 */
	public enum TAB {
		TV(0), BLUE(1), APP(2), GAME(3), HOME(4), CINEMA(5), EDU(6);
		/**
		 * @Fields TabIndex
		 */
		private int TabIndex;

		/**
		 * @param @param TabIndex
		 */
		private TAB(int TabIndex) {
			this.TabIndex = TabIndex;
		}

		public int getTabIndex() {
			return this.TabIndex;
		}

	}