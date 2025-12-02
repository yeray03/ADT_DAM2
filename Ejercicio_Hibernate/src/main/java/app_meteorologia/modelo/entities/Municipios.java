package app_meteorologia.modelo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "municipios")
public class Municipios implements Serializable {

	private static final long serialVersionUID = 3929594558240552756L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MUNICIPIO")
	private Integer idMunicipio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROVINCIA")
	private Provincias provincias;
	@Column(name = "NOMBRE", length = 100)
	private String nombre;
	@Column(name = "DESCRIPCION", columnDefinition = "TEXT")
	private String descripcion;
	@Column(name = "COD_MUNICIPIO")
	private Integer codMunicipio;
	@OneToMany(mappedBy = "municipios", fetch = FetchType.LAZY)
	private Set<MunicipiosEspaciosNat> municipiosEspaciosNats = new HashSet<>(0);
	@OneToMany(mappedBy = "municipios", fetch = FetchType.LAZY)
	private Set<CentrosMeteorologicos> centrosMeteorologicoses = new HashSet<>(0);

	public Municipios() {
	}

	public Municipios(Provincias provincias, String nombre, String descripcion, Integer codMunicipio,
			Set municipiosEspaciosNats, Set centrosMeteorologicoses) {
		this.provincias = provincias;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codMunicipio = codMunicipio;
		this.municipiosEspaciosNats = municipiosEspaciosNats;
		this.centrosMeteorologicoses = centrosMeteorologicoses;
	}

	public Integer getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public Provincias getProvincias() {
		return this.provincias;
	}

	public void setProvincias(Provincias provincias) {
		this.provincias = provincias;
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

	public Integer getCodMunicipio() {
		return this.codMunicipio;
	}

	public void setCodMunicipio(Integer codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public Set getMunicipiosEspaciosNats() {
		return this.municipiosEspaciosNats;
	}

	public void setMunicipiosEspaciosNats(Set municipiosEspaciosNats) {
		this.municipiosEspaciosNats = municipiosEspaciosNats;
	}

	public Set getCentrosMeteorologicoses() {
		return this.centrosMeteorologicoses;
	}

	public void setCentrosMeteorologicoses(Set centrosMeteorologicoses) {
		this.centrosMeteorologicoses = centrosMeteorologicoses;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
