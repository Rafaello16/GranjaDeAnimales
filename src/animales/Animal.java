/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class Animal {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;
/**
 * Constructor de la clase Animal.
 * 
 * Crea un nuevo objeto Animal con un código identificativo,
 * fecha de nacimiento, su sexo y peso.
 * 
 * Realiza validaciones sobre los parámetros recibidos:
 * - El código debe tener exactamente 5 caracteres alfanuméricos en minúscula.
 * - El sexo debe ser 'M' (femenino) o 'H' (masculino).
 * - El peso debe ser mayor que 0.
 * - La fecha de nacimiento debe tener formato ISO yyyy-MM-dd.
 * 
 * @param codigo código identificativo del animal compuesto por 5 caracteres alfanuméricos
 * @param fechaNacimiento fecha de nacimiento del animal en formato yyyy-MM-dd
 * @param sexo sexo del animal, 'M' para hembra o 'H' para macho
 * @param peso peso del animal en kilogramos, debe ser mayor que 0
 * 
 * @throws IllegalArgumentException si el código no cumple el patrón,
 * si el sexo es incorrecto, si el peso no es positivo
 * o si la fecha no tiene formato válido
 */
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {

        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }/**
 * Devuelve el código identificativo del animal.
 *
 * @return código identificativo (5 caracteres alfanuméricos en minúscula)
 */
    public String getCodigo() {
        return codigo;
    }
/**
 * Modifica el código identificativo del animal.
 * El código debe contener exactamente 5 caracteres alfanuméricos en minúscula.
 *
 * @param codigo nuevo código identificativo
 * @throws IllegalArgumentException si el código no cumple el patrón [0-9a-z]{5}
 */
    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }
/**
 * Devuelve la fecha de nacimiento del animal.
 *
 * @return fecha de nacimiento como {@link LocalDate}
 */

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
/**
 * Modifica la fecha de nacimiento del animal.
 * La fecha debe tener formato ISO-8601 (yyyy-MM-dd) y ser válida.
 *
 * @param fechaNacimiento fecha en formato yyyy-MM-dd
 * @throws IllegalArgumentException si la fecha no tiene un formato válido
 */
    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }
/**
 * Devuelve el sexo del animal.
 *
 * @return sexo del animal ('M' o 'H')
 */

    public char getSexo() {
        return sexo;
    }
/**
 * Modifica el sexo del animal.
 *
 * @param sexo nuevo sexo del animal ('M' o 'H')
 * @throws IllegalArgumentException si el sexo no es 'M' ni 'H'
 */
    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }
/**
 * Modifica el peso del animal.
 *
 * @param peso nuevo peso en kilogramos, debe ser mayor que 0
 * @throws IllegalArgumentException si el peso es menor o igual que 0
 */
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }
/**
 * Calcula el código hash del animal a partir de sus atributos.
 *
 * @return valor hash del objeto
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }
/**
 * Compara este animal con otro objeto para determinar si son iguales.
 * Se considera que dos animales son iguales si tienen los mismos valores
 * en sus atributos.
 *
 * @param obj objeto con el que se compara
 * @return true si son iguales; false en caso contrario
 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }
/**
 * Devuelve una representación en forma de texto del animal.
 *
 * @return cadena con los datos del animal
 */
    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }
/**
 * Devuelve el sonido característico del animal.
 *
 * @return sonido del animal
 *//**
 * Devuelve el sonido característico del animal.
 *
 * @return sonido del animal
 */
    public abstract String hacerSonido();
/**
 * Devuelve el mensaje/acción que representa que el animal se alegra.
 *
 * @return mensaje de alegría del animal
 */
    public abstract String alegrarse();
/**
 * Devuelve el mensaje/acción que representa que el animal se enfada.
 *
 * @return mensaje de enfado del animal
 */
    public abstract String enfadarse();
/**
 * Devuelve el tipo de animal (por ejemplo: perro, gato, etc.).
 *
 * @return descripción del animal
 */
    public abstract String queSoy();

}
