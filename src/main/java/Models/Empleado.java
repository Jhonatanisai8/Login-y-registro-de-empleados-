package Models;

/**
 *
 * @author Jhonatan
 */
public class Empleado {

    private int id;
    private String nombre;
    private String appPaterno;
    private String appMaterno;
    private double sueldoBase;
    private String area;
    private String sexo;
    private String estadoCivil;
    private int numHijos;

    //constructor donde nostros le vamos a establecer los atrubitos a traves de los set
    public Empleado() {

    }

    //contructor que nos va ayudara a eliminar 
    public Empleado(int id) {
        this.id = id;
    }

    //constuctor que nos va a ayudara modificar
    public Empleado(String nombre, String appPaterno, String appMaterno, double sueldoBase, String area, String sexo, String estadoCivil, int numHijos) {
        this.nombre = nombre;
        this.appPaterno = appPaterno;
        this.appMaterno = appMaterno;
        this.sueldoBase = sueldoBase;
        this.area = area;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.numHijos = numHijos;
    }

    //constructor que nos va ayudara eliminar
    public Empleado(int id, String nombre, String appPaterno, String appMaterno, double sueldoBase, String area, String sexo, String estadoCivil, int numHijos) {
        this.id = id;
        this.nombre = nombre;
        this.appPaterno = appPaterno;
        this.appMaterno = appMaterno;
        this.sueldoBase = sueldoBase;
        this.area = area;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.numHijos = numHijos;
    }

}
