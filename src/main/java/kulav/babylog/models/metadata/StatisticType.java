package kulav.babylog.models.metadata;

public enum StatisticType {
	SUM_TIME_BAR_CHART(true),
	SUM_VAL_BAR_CHART(true),
	TIME_RANGE_BAR_CHART(true),
	NUMBER_OF_TIMES_PER_DAY(false),
	SUM_TIME_PER_DAY(false),
	SUM_VAL_PER_DAY(false),
	SUM_ONCE_PER_DAY(false);
	
	private final boolean isChart;
	
	StatisticType(boolean isChart) {
		this.isChart = isChart;
	}

	public boolean isChart() {
		return isChart;
	}
}
