// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PistonConstants;

public class PneumaticsSubsystem extends SubsystemBase {
  /** Creates a new PneumaticsSubsystem. */
  private final Compressor m_Compressor;
  private final Solenoid m_Solenoid;
  public PneumaticsSubsystem() {
    m_Compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    m_Solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, PistonConstants.kPistonConstant);
    m_Compressor.disable();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void onSolenoid(Boolean active) {
    m_Solenoid.set(active);
  }

  public void setCompressor(boolean isActive){
    if (isActive)
      m_Compressor.enableDigital();
    else 
      m_Compressor.disable();
  }
}
