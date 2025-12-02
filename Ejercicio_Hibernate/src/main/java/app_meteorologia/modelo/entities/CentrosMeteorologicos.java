package app_meteorologia.modelo.entities;
// Generated 18 dic 2024, 20:07:14 by Hibernate Tools 6.5.1.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "centros_meteorologicos")

public class CentrosMeteorologicos implements Serializable {

	private static final long serialVersionUID = -826048818372657632L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_centro_met")
	private Integer idCentroMet;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_municipio")
	private Municipios municipios;
	@Column(name = "nombre", length = 100)
	private String nombre;
	@Column(name = "direccion", length = 255)
	private String direccion;
	@Column(name = "latitud")
	private Double latitud;
	@Column(name = "longitud")
	private Double longitud;
	@Column(name = "url")
	private String url;
	@Column(name = "hash")
	private String hash;
	@OneToMany(mappedBy = "centrosMeteorologicos", fetch = FetchType.LAZY)
	private Set<MedicionesCentroMet> medicionesCentroMets = new HashSet<>(0);

	public CentrosMeteorologicos() {
	}

	public CentrosMeteorologicos(Municipios municipios, String nombre, String direccion, Double latitud,
			Double longitud, String url, String hash, Set medicionesCentroMets) {
		this.municipios = municipios;
		this.nombre = nombre;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.url = url;
		this.hash = hash;
		this.medicionesCentroMets = medicionesCentroMets;
	}

	public Integer getIdCentroMet() {
		return this.idCentroMet;
	}

	public void setIdCentroMet(Integer idCentroMet) {
		this.idCentroMet = idCentroMet;
	}

	public Municipios getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(Municipios municipios) {
		this.municipios = municipios;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Set getMedicionesCentroMets() {
		return this.medicionesCentroMets;
	}

	public void setMedicionesCentroMets(Set medicionesCentroMets) {
		this.medicionesCentroMets = medicionesCentroMets;
	}

}
