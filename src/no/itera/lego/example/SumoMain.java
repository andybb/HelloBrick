package no.itera.lego.example;

import lejos.hardware.Button;
import lejos.robotics.RegulatedMotor;
import no.itera.lego.EV3Helper;
import no.itera.lego.SampleSet;

public class SumoMain {
	private final RegulatedMotor motorLeft;
	private final RegulatedMotor motorRight;
	private SampleSet lastSampleSet;
	private EV3Helper ev3Helper;

	public SumoMain() {
		ev3Helper = new EV3Helper(true);
		motorLeft = ev3Helper.getMotorLeft();
		motorRight = ev3Helper.getMotorRight();
		lastSampleSet = new SampleSet(ev3Helper);
	}

	/**
	 * Drives forward until the color black or none is seen, then back up 30 cm
	 * and turns left about 110 degrees.
	 * Stops as long as the distance sensor sees an object closer than.
	 * positive infinity, in reality about 50 cm.
	 */
	private void drive() {
		boolean run = true;
		ev3Helper.forward();

		while (run) {	
			lastSampleSet.takeSamples();
			if (lastSampleSet.getLastDistance() < Float.POSITIVE_INFINITY) { // stops as long as it sees something
				ev3Helper.stop(); //immediate return
			} else if (lastSampleSet.getLastColor().equals("BLACK") || lastSampleSet.getLastColor().equals("NONE")) { // turns left while reading the color black
				ev3Helper.backward(30); // blocking, won't read sensors while backing
				ev3Helper.turnRight(110); // blocking, won't read sensors while turning
			} else {
				ev3Helper.forward(); // immediate return
			}
		}
	}

	public static void main(String[] args) {
		SumoMain sumo = new SumoMain();
		System.out.println("startup complete.\nClick any button to drive");
		Button.waitForAnyPress();
		try {
			Thread.sleep(3000); // wait 3 seconds
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sumo.drive();
	}

}
