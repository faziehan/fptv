package org.fptv;

public class DevicePackage {
	public double Dt = 24;
	public double Du = 512;

	
	public int Dp = 0;
	public int DRp = 0;
	public int Dr = 0;

	public void setData(int devicePrice, int deviceRPrice, int deviceRebate){
		this.Dp = devicePrice;
		this.DRp = deviceRPrice;
		this.Dr = deviceRebate;
	}
	
	public String getDevicePackagePrice(){
		double Db = 0;
		
		Db = (DRp - (Dp + Du + Dr))/Dt;
		
		return ">> "+round(Db,2) +" = "+ DRp +"\t"+ Dp +"\t"+Du +"\t"+Dr +"\t"+Dt;
//		return null;
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
