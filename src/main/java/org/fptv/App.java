package org.fptv;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Author: AFZ
 *
 */
public class App {
	static double minimum = 0;
    static PrintWriter writer ;

	public static void main(String[] args) {
		try {
			writer = new PrintWriter("results.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ServicePackage servicePackage = new ServicePackage();
		DevicePackage devicePackage = new DevicePackage();

		writer.println("Service package results...");
		writer.println("\n\n");
		writer.println(">> Service price = NumVoiceCalls	NumTextMsgs	NetDataQuota");
		writer.println();
		for (int NoVC = 100; NoVC < 301; NoVC += 10) {
			for (int NoTm = 100; NoTm < 301; NoTm += 10) {
				 for (int IDQ = 2; IDQ < 7; IDQ++) {
/*					for (int IDT = 2; IDT < 6; IDT++) {
						for (int DRP = 700; DRP < 1500; DRP += 100) {
							for (int DuFP = 200; DuFP < 301; DuFP += 10) {
								for (int TDSP = 300; TDSP < 1000; TDSP += 100) {
*/									servicePackage.setData(NoVC, NoTm, IDQ /*, DRP, DuFP, TDSP*/);
									if(servicePackage.getPackagePrice() != null){
										writer.println(servicePackage.getPackagePrice());
									}
//								}
//							}
//						}
//					}

				}
			}
			writer.println("Device package results...");
			writer.println("\n\n");
			writer.println(">> DeviceBill = DeviceRetailPrice DevicePrice	DeviceUpFronts DeviceRebate DeviceContract");
			writer.println();
			for (int Dp = 1500; Dp < 2500; Dp += 100) {
				for (int Drp = 3008; Drp < 4500; Drp += 100) {
					for (int Dr = 20; Dr < 51; Dr += 10) {
						devicePackage.setData(Dp, Drp, Dr);
						writer.println(devicePackage.getDevicePackagePrice());
					}
				}
			}

			 // System.out.println("Minimum = "+minimum);
			  writer.close();
		}
	}
}
