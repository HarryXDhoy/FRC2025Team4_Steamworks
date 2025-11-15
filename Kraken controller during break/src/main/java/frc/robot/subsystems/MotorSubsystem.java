// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VoltageOut;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {

  private final TalonFX m_Motor;
  private final TalonFX m_Follower;
  private final TalonFXConfiguration motorConfigurator = new TalonFXConfiguration();
  private final double voltageInput = 0.5;

  public MotorSubsystem() {
    m_Motor = new TalonFX(0);
    m_Follower = new TalonFX(1);
    configMotors();
  }

  private void configMotors() {
    motorConfigurator.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    motorConfigurator.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    motorConfigurator.Feedback.RotorToSensorRatio = 6.0;

    motorConfigurator.CurrentLimits.SupplyCurrentLimit = 40.0;
    motorConfigurator.CurrentLimits.StatorCurrentLimit = 40.0;
    motorConfigurator.CurrentLimits.SupplyCurrentLimitEnable = true;

    m_Motor.getConfigurator().apply(motorConfigurator);
    m_Follower.getConfigurator().apply(motorConfigurator);

    Follower followerConfig = new Follower(m_Motor.getDeviceID(), true);
    m_Follower.setControl(followerConfig);
}

  private void setMotorVoltage(double volts) {
    m_Motor.setControl(new VoltageOut(volts));
  }

  public void voltageUp() {
    setMotorVoltage(voltageInput);
  }

  public void voltageDown() {
    setMotorVoltage(-voltageInput);
  }

  private void stopMotor() {
    setMotorVoltage(0);
  }

  private double motorSpeedRPS() {
    return m_Motor.getVelocity().getValueAsDouble();
  }

  public Command spinMotorCommand(double volts) {
    return Commands.startEnd(
        () -> setMotorVoltage(volts),
        this::stopMotor,
        this
    );
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Motor1 Speed", motorSpeedRPS());
  }
}

  @Override
  public void periodic() {//this gets run every 20ms by the commandscheduler
    SmartDashboard.putNumber("Motor1 Speed", motorSpeedRPS());
  }
}
