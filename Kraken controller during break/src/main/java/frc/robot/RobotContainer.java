package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  private final MotorSubsystem m_motorSubsystem = new MotorSubsystem();
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.a().whileTrue(m_motorSubsystem.spinMotorCommand(1));
    m_driverController.b().whileTrue(m_motorSubsystem.spinMotorCommand(-1));
    m_driverController.x().whileTrue(m_motorSubsystem.spinMotorCommand(3));
    m_driverController.y().whileTrue(m_motorSubsystem.spinMotorCommand(-3));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}



