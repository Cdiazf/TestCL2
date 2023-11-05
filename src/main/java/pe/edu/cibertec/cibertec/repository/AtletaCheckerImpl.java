package pe.edu.cibertec.cibertec.repository;

public class AtletaCheckerImpl implements AtletaChecker {
    @Override
    public boolean esAptoParaAtletaJuvenil(char sexo, int edad, double estatura, double peso) {
        if (sexo == 'M') {
            return edad >= 18 && estatura > 1.70 && peso < 70.0;
        } else if (sexo == 'F') {
            return edad > 16 && estatura >= 1.70 && peso <= 60.0;
        } else {
            return false; // Sexo no válido
        }
    }
}

