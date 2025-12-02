package app_meteorologia.modelo.entities;

import java.io.Serializable;

import jakarta.persistence.*;

@Embeddable
public class MunicipiosEspaciosNatId implements Serializable {

	private static final long serialVersionUID = 7411651692183639630L;

	@Column(name = "id_espacio")
	private int idEspacio;
	@Column(name = "id_municipio")
	private int idMunicipio;

	public MunicipiosEspaciosNatId() {
	}

	public MunicipiosEspaciosNatId(int idEspacio, int idMunicipio) {
		this.idEspacio = idEspacio;
		this.idMunicipio = idMunicipio;
	}

	public int getIdEspacio() {
		return this.idEspacio;
	}

	public void setIdEspacio(int idEspacio) {
		this.idEspacio = idEspacio;
	}

	public int getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MunicipiosEspaciosNatId))
			return false;
		MunicipiosEspaciosNatId castOther = (MunicipiosEspaciosNatId) other;

		return (this.getIdEspacio() == castOther.getIdEspacio())
				&& (this.getIdMunicipio() == castOther.getIdMunicipio());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdEspacio();
		result = 37 * result + this.getIdMunicipio();
		return result;
	}

}
