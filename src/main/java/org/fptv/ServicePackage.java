package org.fptv;

import java.io.PrintWriter;

public class ServicePackage {
	public double Rv = 0.05;
	public double Rd = 2.75;
	public double Rt = 0.01;
	//public int DCP = 24;
	
	public int NoVC = 0;
	public int NoTM = 0;
	public int IDQ = 0;
	
	//public int DRP = 0;
	//public int DuFP = 0;
	//public int TDSP = 0;
	
	PrintWriter writer ;
	

	public ServicePackage() {
		
	}
	public void setData(int NumVoiceCalls, int NumTextMsgs, int InternetDataQuota
		/*	 ,int DeviceRetailPrice, int UpFrontPayment, int TDeviceServicePrice*/ ) {
		this.NoVC = NumVoiceCalls;
		this.NoTM = NumTextMsgs;
		this.IDQ  = InternetDataQuota;
		
//		this.DRP = DeviceRetailPrice;
//		this.DuFP = UpFrontPayment;
//		this.TDSP = TDeviceServicePrice;
		
	}
	
	public String getPackagePrice(){
		double Pp = 0;
		
		Pp = ((Rv*NoVC)+(Rt*NoTM)+(Rd*IDQ))/* + ((DRP-(TDSP+DuFP))/DCP)  */ ;
		if(Pp < 19){
			return null;
		}
		return ">> "+round(Pp,2) +" = "+ NoVC +"\t"+NoTM +"\t"+IDQ +"\t"/* +DRP+"\t"+DuFP+"\t"+TDSP*/;
	}
		
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
