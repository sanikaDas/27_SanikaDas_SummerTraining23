package frc.robot;

import frc.robot.commands.ToggleIntake;
import frc.robot.commands.ToggleRaise;
import harkerrobolib.joysticks.XboxGamepad;
import harkerrobolib.util.Constants;

public class OI {
    private static OI instance; 
    private XboxGamepad driver;
    
    private OI() {
        driver = new XboxGamepad(Constants.DRIVER_ID);
        initBindings();
    }
    
    public XboxGamepad getDriver() {
        return driver;
    }

    
    private void initBindings() {
        driver.getButtonX().whileTrue(new ToggleIntake());
        driver.getButtonY().whileTrue(new ToggleRaise());
    } 
    
    public static OI getInstance() {
        if(instance == null) {
            instance = new OI();  
        }
        return instance;
    }
}