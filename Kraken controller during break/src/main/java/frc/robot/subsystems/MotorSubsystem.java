// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;


public class MotorSubsystem extends SubsystemBase {
  /** Creates a new MotorSubsystem. */
  private final TalonFX motor1;
  private final TalonFXConfiguration motorConfigurator = new TalonFXConfiguration();
private final VoltageOut voltageOut = new VoltageOut(0);

  public MotorSubsystem() {
    motor1 = new TalonFX(0);
    configMotors();
  }

  private void configMotors(){
    motorConfigurator.Feedback.withRotorToSensorRatio(6);
    motor1.getConfigurator().apply(motorConfigurator);
  }
  
  private void voltageOutControl(double volts){
    motor1.setControl(new VoltageOut(volts));
  }

  private void stopMotor(){
    motor1.stopMotor();
  }

  private double motorSpeedRPS(){
    return motor1.getVelocity().getValueAsDouble();
  }

  public Command spinMotorCommand(double volts){
    return startEnd(
      ()-> voltageOutControl(volts), 
      ()-> stopMotor());
  }

  @Override
  public void periodic() {//this gets run every 20ms by the commandscheduler
    SmartDashboard.putNumber("Motor1 Speed", motorSpeedRPS());
  }
}
