package app_meteorologia.modelo.entities;

import java.io.Serializable;

public class MunicipiosEspaciosNat implements Serializable {

	private static final long serialVersionUID = -4882092065927222320L;
	
	private MunicipiosEspaciosNatId id;
	private EspaciosNaturales espaciosNaturales;
	private Municipios municipios;

	public MunicipiosEspaciosNat() {
	}

	public MunicipiosEspaciosNat(MunicipiosEspaciosNatId id, EspaciosNaturales espaciosNaturales,
			Municipios municipios) {
		this.id = id;
		this.espaciosNaturales = espaciosNaturales;
		this.municipios = municipios;
	}

	public MunicipiosEspaciosNatId getId() {
		return this.id;
	}

	public void setId(MunicipiosEspaciosNatId id) {
		this.id = id;
	}

	public EspaciosNaturales getEspaciosNaturales() {
		return this.espaciosNaturales;
	}

	public void setEspaciosNaturales(EspaciosNaturales espaciosNaturales) {
		this.espaciosNaturales = espaciosNaturales;
	}

	public Municipios getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(Municipios municipios) {
		this.municipios = municipios;
	}

}
