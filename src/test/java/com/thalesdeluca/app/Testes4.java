package com.thalesdeluca.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class Testes4 {
    
  @Test
  public void testeSCmol() {
    assertEquals(7.54, CTCEquilibriumCorrection.getSCmol(0.15, 5.76, 1.63), 0);
  }

  @Test
  public void testeCTCCmol() {
    assertEquals(12.89, CTCEquilibriumCorrection.getCTCCmol(0.15, 5.76, 1.63, 5.35), 0);
  }

  @Test
  public void testeVPercentual() {
    assertEquals(58.49,
        CTCEquilibriumCorrection.getVPercentual(CTCEquilibriumCorrection.getSCmol(0.15, 5.76, 1.63),
            CTCEquilibriumCorrection.getCTCCmol(0.15, 5.76, 1.63, 5.35)),
        0);
  }

  @Test
  public void testeMOPercentual() {
    assertEquals(3.07, CTCEquilibriumCorrection.getMOPercentual(30.7), 0);
  }

  @Test
  public void testeCarbono() {
    assertEquals(17.84, CTCEquilibriumCorrection.getCarbon(CTCEquilibriumCorrection.getMOPercentual(30.7)),
        0.00001);
  }
}
