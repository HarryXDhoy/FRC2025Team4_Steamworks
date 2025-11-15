package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;

public class RobotContainer {

  private final MotorSubsystem m_motorSubsystem = new MotorSubsystem();
  private final CommandPS4Controller m_driverController =
      new CommandPS4Controller(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.cross().whileTrue(m_motorSubsystem.spinMotorCommand(1));
    m_driverController.circle().whileTrue(m_motorSubsystem.spinMotorCommand(-1));
    m_driverController.square().whileTrue(m_motorSubsystem.spinMotorCommand(3));
    m_driverController.triangle().whileTrue(m_motorSubsystem.spinMotorCommand(-3));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
