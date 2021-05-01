package com.thalesdeluca.app;

import com.thalesdeluca.contents.AluminiumContent;
import com.thalesdeluca.contents.CalciumContent;
import com.thalesdeluca.contents.MagnesiumContent;
import com.thalesdeluca.contents.PhosphorContent;
import com.thalesdeluca.contents.PotassiumContent;
import com.thalesdeluca.contents.SulfurContent;
import com.thalesdeluca.enums.GroundTexture;
import com.thalesdeluca.enums.Metric;
import com.thalesdeluca.enums.PhosphorSource;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

public class Testes4 {
    
    @Test
    public void testeAluminioIdeal() {
        AluminiumContent aluminium = new AluminiumContent("Aluminium", Metric.MGDM, 0);
        assertEquals(0f, aluminium.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
    }

    @Test
    public void testeCalcioIdeal() {
        CalciumContent calcium = new CalciumContent("Calcium", Metric.CMOL, 0);
        assertEquals(6f, calcium.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
    }

    @Test
    public void testeMagnesioIdeal() {
        MagnesiumContent magnesium = new MagnesiumContent("Magnesium", Metric.CMOL, 0);
        assertEquals(1.5f, magnesium.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
    }

    @Test
    public void testeFosforoIdeal() {
        PhosphorContent phosphor = new PhosphorContent("Phosphor", Metric.MEHLICH, 0);
        assertEquals(9f, phosphor.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
    }

    @Test
    public void testePotassioIdeal() {
        PotassiumContent potassium = new PotassiumContent("Potassium", Metric.CMOL, 0);
        assertEquals(0.35f, potassium.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
    }

    @Test
    public void testeEnxofreIdeal() {
        SulfurContent sulfur = new SulfurContent("Sulfur", Metric.MGDM, 0);
        assertEquals(9f, sulfur.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
    }  
    
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
          0.1);
    }

    @Test
    public void testeMOPercentual() {
      assertEquals(3.07, CTCEquilibriumCorrection.getMOPercentual(30.7), 0);
    }

    @Test
    public void testeCarbono() {
      assertEquals(17.84, CTCEquilibriumCorrection.getCarbon(CTCEquilibriumCorrection.getMOPercentual(30.7)),
          0.1);
    }
    
    @Test
    public void testeGetResiduals() {
        PhosphorContent content = new PhosphorContent("Fósforo", Metric.MGDM, 8.59f);
        Map<String, Double> results = PhosphorCorrection.getResiduals(PhosphorSource.SIMPLE_SUPERPHOSPHATE, 12, 70,
            content);

        assertEquals(12.4, results.get("Enxofre"), 0.01);
        assertEquals(34.7, results.get("CÁLCIO"), 0.01);
    }
    
    @Test
    public void testeGetKgHectare() {
        PhosphorContent content = new PhosphorContent("Fósforo", Metric.MGDM, 8.59f);
        
        assertEquals(123.95, PhosphorCorrection.getKgHectare(PhosphorSource.SIMPLE_SUPERPHOSPHATE, 12, 70, content), 0.01);
    }

    @Test
    public void testeGetCost() {
    PhosphorContent content = new PhosphorContent("Fósforo", Metric.MGDM, 8.59f);
    double result = PhosphorCorrection.getCost(PhosphorSource.SIMPLE_SUPERPHOSPHATE, 1260f, 12f, 70f, content);

    assertEquals(156.18, result, 0.01);
    }
}
