package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.configs.VoltageConfigs;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private TalonFX motor1;
    private TalonFX motor2;
    private TalonFXConfiguration config = new TalonFXConfiguration();


    public Intake (){
        motor1 = new TalonFX(0);
        motor2 = new TalonFX(1);
        
        
    }

    public void runMotor1(){
        
    }
    


    







}
