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

    //getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppPaterno() {
        return appPaterno;
    }

    public void setAppPaterno(String appPaterno) {
        this.appPaterno = appPaterno;
    }

    public String getAppMaterno() {
        return appMaterno;
    }

    public void setAppMaterno(String appMaterno) {
        this.appMaterno = appMaterno;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public double bonoArea() {
        double bonoMonto = 0;
        switch (this.area) {
            case "Desarrollo de Software" -> bonoMonto = this.sueldoBase * 0.05d;
            case "Gestión de Proyectos" -> bonoMonto = this.sueldoBase * 0.03d;
            case "Análisis y Diseño" -> bonoMonto = this.sueldoBase * 0.05d;
            case "Soporte y Mantenimiento" -> bonoMonto = this.sueldoBase * 0.04d;
            case "Infraestructura y Operaciones" -> bonoMonto = this.sueldoBase * 0.04d;
            case "Innovación y Desarrollo de Nuevas Tecnologías" -> bonoMonto = this.sueldoBase * 0.04d;
            case "ventas y Marketing" -> bonoMonto = this.sueldoBase * 0.03d;
        }
        return bonoMonto;
    }
}
