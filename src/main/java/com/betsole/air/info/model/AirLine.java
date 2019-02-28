package com.betsole.air.info.model;

public class AirLine {
	
	private long alId;
	
	private String alName;
	
	private String alInfo;

	public long getAlId() {
		return alId;
	}

	public void setAlId(long alId) {
		this.alId = alId;
	}

	public String getAlName() {
		return alName;
	}

	public void setAlName(String alName) {
		this.alName = alName;
	}

	public String getAlInfo() {
		return alInfo;
	}

	public void setAlInfo(String alInfo) {
		this.alInfo = alInfo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (alId ^ (alId >>> 32));
		result = prime * result + ((alName == null) ? 0 : alName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirLine other = (AirLine) obj;
		if (alId != other.alId)
			return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AirLine [alId=" + alId + ", alName=" + alName + ", alInfo=" + alInfo + "]";
	}
	
	

}
