package vitals;

public class BatteryCheck {
	public static float UPPER_LIMIT_TEMPERATURE = 45;
	public static float LOWER_LIMIT_TEMPERATURE = 0;
	public static float UPPER_LIMIT_SOC = 80;
	public static float LOWER_LIMIT_SOC = 20;
	public static float MAX_CHARGE_RATE = 0.8f;
	
	float temperature;
	float soc;
	float chargeRate;

	public BatteryCheck(float temperature, float soc, float chargeRate) {
		this.temperature = temperature;
		this.soc = soc;
		this.chargeRate = chargeRate;
	}
	public boolean isBatteryOk() {
		return (checkTemperatureOk(temperature) && checkSocOk(soc)) && checkChargeRateOk(chargeRate);
	}
	public boolean checkTemperatureOk(float temperature) {		
		if(!checkLimitRange(LOWER_LIMIT_TEMPERATURE, UPPER_LIMIT_TEMPERATURE, temperature))
		{
			//Temperature out of range
			return false;
		}	
		return true;
	}
	public boolean checkSocOk(float soc) {
		if(!checkLimitRange(LOWER_LIMIT_SOC, UPPER_LIMIT_SOC, soc))
		{
			//soc out of range
			return false;
		}	
		return true;
	}
	public boolean checkChargeRateOk(float chargeRate) {
		if(checkCharge(MAX_CHARGE_RATE, chargeRate).equals("high"))
		{
			//Charge Rate out of range
            return false;
		}
		return true;
	}
	private boolean checkLimitRange(float min, float max, float value) {
		return !(value < min || value > max); 
	}
	private String checkCharge(float max, float value) {
		return (value>max) ? "high" : "low"; 
	}	
}
