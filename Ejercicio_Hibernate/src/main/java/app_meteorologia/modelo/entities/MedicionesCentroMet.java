package app_meteorologia.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "mediciones_centro_met")
public class MedicionesCentroMet implements Serializable {

	private static final long serialVersionUID = 64071800526901271L;
	@EmbeddedId
	@Column(name = "id")
	private MedicionesCentroMetId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_centro_met", insertable = false, updatable = false)
	private CentrosMeteorologicos centrosMeteorologicos;
	@Column(name = "dir_viento")
	private Integer dirViento;
	@Column(name = "h_relativa")
	private Integer HRelativa;
	@Column(name = "p_atmosferica")
	private Float PAtmosferica;
	@Column(name = "precip")
	private Float precip;
	@Column(name = "rad_solar")
	private Float radSolar;
	@Column(name = "temp_ambiente")
	private Float tempAmbiente;
	@Column(name = "vviento")
	private Float VViento;
	@Column(name = "ica")
	private String ica;

	public MedicionesCentroMet() {
	}

	public MedicionesCentroMet(MedicionesCentroMetId id, CentrosMeteorologicos centrosMeteorologicos) {
		this.id = id;
		this.centrosMeteorologicos = centrosMeteorologicos;
	}

	public MedicionesCentroMet(MedicionesCentroMetId id, CentrosMeteorologicos centrosMeteorologicos, Integer dirViento,
			Integer HRelativa, Float PAtmosferica, Float precip, Float radSolar, Float tempAmbiente, Float VViento,
			String ica) {
		this.id = id;
		this.centrosMeteorologicos = centrosMeteorologicos;
		this.dirViento = dirViento;
		this.HRelativa = HRelativa;
		this.PAtmosferica = PAtmosferica;
		this.precip = precip;
		this.radSolar = radSolar;
		this.tempAmbiente = tempAmbiente;
		this.VViento = VViento;
		this.ica = ica;
	}

	public MedicionesCentroMetId getId() {
		return this.id;
	}

	public void setId(MedicionesCentroMetId id) {
		this.id = id;
	}

	public CentrosMeteorologicos getCentrosMeteorologicos() {
		return this.centrosMeteorologicos;
	}

	public void setCentrosMeteorologicos(CentrosMeteorologicos centrosMeteorologicos) {
		this.centrosMeteorologicos = centrosMeteorologicos;
	}

	public Integer getDirViento() {
		return this.dirViento;
	}

	public void setDirViento(Integer dirViento) {
		this.dirViento = dirViento;
	}

	public Integer getHRelativa() {
		return this.HRelativa;
	}

	public void setHRelativa(Integer HRelativa) {
		this.HRelativa = HRelativa;
	}

	public Float getPAtmosferica() {
		return this.PAtmosferica;
	}

	public void setPAtmosferica(Float PAtmosferica) {
		this.PAtmosferica = PAtmosferica;
	}

	public Float getPrecip() {
		return this.precip;
	}

	public void setPrecip(Float precip) {
		this.precip = precip;
	}

	public Float getRadSolar() {
		return this.radSolar;
	}

	public void setRadSolar(Float radSolar) {
		this.radSolar = radSolar;
	}

	public Float getTempAmbiente() {
		return this.tempAmbiente;
	}

	public void setTempAmbiente(Float tempAmbiente) {
		this.tempAmbiente = tempAmbiente;
	}

	public Float getVViento() {
		return this.VViento;
	}

	public void setVViento(Float VViento) {
		this.VViento = VViento;
	}

	public String getIca() {
		return this.ica;
	}

	public void setIca(String ica) {
		this.ica = ica;
	}

}
