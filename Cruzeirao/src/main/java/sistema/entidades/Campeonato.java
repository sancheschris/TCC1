package sistema.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.primefaces.event.SelectEvent;

@Entity
@NamedQueries 
({
	@NamedQuery(name="Campeonato.findNome", 
			query=" Select c From Campeonato c Where c.nome = :nome")
})
public class Campeonato {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCampeonato;
	private String nome;
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="campeonato")
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	
	
	@ManyToOne
	private Usuario usuario;
	
	
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioInscricao;
	@Temporal(TemporalType.DATE)
	private Date dataFimInscricao;
	@Temporal(TemporalType.DATE)
	private Date dataInicioCampeonato;
	@Temporal(TemporalType.DATE)
	private Date dataFimCampeonato;
	private double valorTaxa;
	/*
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario; // por direcional nao deve existir esse atributo. rever
	*/
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

	
	public long getIdCampeonato() {
		return idCampeonato;
	}


	public void setIdCampeonato(long idCampeonato) {
		this.idCampeonato = idCampeonato;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Date getDataInicioInscricao() {
		return dataInicioInscricao;
	}

	public void setDataInicioInscricao(Date dataInicioInscricao) {
		this.dataInicioInscricao = dataInicioInscricao;
	}

	public Date getDataFimInscricao() {
		return dataFimInscricao;
	}

	public void setDataFimInscricao(Date dataFimInscricao) {
		this.dataFimInscricao = dataFimInscricao;
	}

	public Date getDataInicioCampeonato() {
		return dataInicioCampeonato;
	}

	public void setDataInicioCampeonato(Date dataInicioCampeonato) {
		this.dataInicioCampeonato = dataInicioCampeonato;
	}

	public Date getDataFimCampeonato() {
		return dataFimCampeonato;
	}

	public void setDataFimCampeonato(Date dataFimCampeonato) {
		this.dataFimCampeonato = dataFimCampeonato;
	}

	public double getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}

	public void addCategorias(Categoria categoria) {
		categorias.add(categoria);
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
