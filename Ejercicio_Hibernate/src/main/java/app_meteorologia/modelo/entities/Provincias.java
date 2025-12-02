package app_meteorologia.modelo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "provincias")

public class Provincias implements Serializable {

	private static final long serialVersionUID = -5525908594051990651L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROVINCIA")
	private int idProvincia;
	
	@Column(name = "NOMBRE", length = 100)
	private String nombre;
	
	@OneToMany(mappedBy = "provincias", fetch = FetchType.LAZY)
	private Set<Municipios> municipioses = new HashSet<>(0);

	public Provincias() {
	}

	public Provincias(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Provincias(int idProvincia, String nombre, Set municipioses) {
		this.idProvincia = idProvincia;
		this.nombre = nombre;
		this.municipioses = municipioses;
	}

	public int getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getMunicipioses() {
		return this.municipioses;
	}

	public void setMunicipioses(Set municipioses) {
		this.municipioses = municipioses;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
