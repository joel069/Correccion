package ec.edu.ups.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Libro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private int isbn;
	private int numpag;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "libro" , orphanRemoval = true)
	private  List<Capitulo> capitulos;
	
	
	public Libro() {
		
		capitulos = new ArrayList <Capitulo>();
		
	}


	public Libro( String nombre, int isbn, int numpag ) {
		super();
		
		this.nombre = nombre;
		this.isbn = isbn;
		this.numpag = numpag;
		capitulos = new ArrayList<Capitulo>();
	}


	public int getCodigo() {
		return codigo;
		
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public int getNumpag() {
		return numpag;
	}


	public void setNumpag(int numpag) {
		this.numpag = numpag;
	}


	public List<Capitulo> getCapitulos() {
		return capitulos;
	}


	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	
	public void addCapitulo(Capitulo capitulo) {
		if (!capitulos.contains(capitulo)) {
			capitulos.add(capitulo);
			capitulo.setLibro(this);
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capitulos == null) ? 0 : capitulos.hashCode());
		result = prime * result + codigo;
		result = prime * result + isbn;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numpag;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (capitulos == null) {
			if (other.capitulos != null)
				return false;
		} else if (!capitulos.equals(other.capitulos))
			return false;
		if (codigo != other.codigo)
			return false;
		if (isbn != other.isbn)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numpag != other.numpag)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", nombre=" + nombre + ", isbn=" + isbn + ", numpag=" + numpag
				+ ", capitulos=" + capitulos + "]";
	}


	
	
	
	
}
