package pe.edu.cibertec.cibertec.repository;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class AtletaCheckerImplTest {

//    Se necesita un programa que diga si una persona es apta o no para ser atleta de la selección “Cibertec Juvenil”.
//    Para que sea apto debe cumplir que si es hombre, sea mayor de edad, mida más de 1.70 y pese menos de 70 kg.
//    Si es mujer que tenga más de 16 años, mida como mínimo 1.70 y pese como máximo 60 kg.
//    Los datos de entrada son el sexo (M: masculino; F: femenino), la edad, la estatura y el peso.


    @Test
    public void testEsAptoHombreCumpleRequisitos() {
        AtletaChecker checker = new AtletaCheckerImpl();
        assertTrue(checker.esAptoParaAtletaJuvenil('M', 20, 1.75, 65.0));
    }

    @Test
    public void testEsAptoMujerCumpleRequisitos() {
        AtletaChecker checker = new AtletaCheckerImpl();
        assertTrue(checker.esAptoParaAtletaJuvenil('F', 17, 1.75, 55.0));
    }

    @Test
    public void testNoEsAptoSexoNoValido() {
        AtletaChecker checker = new AtletaCheckerImpl();
        assertFalse(checker.esAptoParaAtletaJuvenil('X', 18, 1.80, 68.0));
    }

    @Test
    public void testNoEsAptoHombreNoCumpleRequisitos() {
        AtletaChecker checker = new AtletaCheckerImpl();
        assertFalse(checker.esAptoParaAtletaJuvenil('M', 16, 1.60, 75.0));
    }

    @Test
    public void testNoEsAptoMujerNoCumpleRequisitos() {
        AtletaChecker checker = new AtletaCheckerImpl();
        assertFalse(checker.esAptoParaAtletaJuvenil('F', 18, 1.60, 65.0));
    }
}
