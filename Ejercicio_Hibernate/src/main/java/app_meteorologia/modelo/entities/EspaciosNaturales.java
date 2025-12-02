package app_meteorologia.modelo.entities;
// Generated 18 dic 2024, 20:07:14 by Hibernate Tools 6.5.1.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "espacios_naturales")
public class EspaciosNaturales implements Serializable {

	private static final long serialVersionUID = 20153009663153159L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_espacio")
	private Integer idEspacio;
	@Column(name = "nombre", length = 100)
	private String nombre;
	@Column(name = "descripcion", columnDefinition = "TEXT")
	private String descripcion;
	@Column(name = "tipo", length = 50)
	private String tipo;
	@Column(name = "categoria", length = 50)
	private String categoria;
	@Column(name = "latitud")
	private Double latitud;
	@Column(name = "longitud")
	private Double longitud;
	@OneToMany(mappedBy = "espaciosNaturales", fetch = FetchType.LAZY)
	private Set<MunicipiosEspaciosNat> municipiosEspaciosNats = new HashSet<>(0);

	public EspaciosNaturales() {
	}

	public EspaciosNaturales(String nombre, String descripcion, String tipo, String categoria, Double latitud,
			Double longitud, Set municipiosEspaciosNats) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.categoria = categoria;
		this.latitud = latitud;
		this.longitud = longitud;
		this.municipiosEspaciosNats = municipiosEspaciosNats;
	}

	public Integer getIdEspacio() {
		return this.idEspacio;
	}

	public void setIdEspacio(Integer idEspacio) {
		this.idEspacio = idEspacio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Set getMunicipiosEspaciosNats() {
		return this.municipiosEspaciosNats;
	}

	public void setMunicipiosEspaciosNats(Set municipiosEspaciosNats) {
		this.municipiosEspaciosNats = municipiosEspaciosNats;
	}

}
