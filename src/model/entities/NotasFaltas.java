package model.entities;

import java.io.Serializable;


public class NotasFaltas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer faltasB1;
	private Integer faltasB2;
	private Integer faltasB3;
	private Integer faltasB4;
	private Double notaSalaAulaB1;
	private Double notaSalaAulaB2;
	private Double notaSalaAulaB3;
	private Double notaSalaAulaB4;
	private Double notaTarefasB1;
	private Double notaTarefasB2;
	private Double notaTarefasB3;
	private Double notaTarefasB4;
	private Double notaTrabalhoB1;
	private Double notaTrabalhoB2;
	private Double notaTrabalhoB3;
	private Double notaTrabalhoB4;
	private Double notaProvaB1;
	private Double notaProvaB2;
	private Double notaProvaB3;
	private Double notaProvaB4;
	
	private Aluno aluno;
	
	private int totalFaltas;
	
	private String situacaoAluno;
	
	public NotasFaltas() {
	}
	
	public NotasFaltas(Integer id, Integer faltasB1, Integer faltasB2, Integer faltasB3, Integer faltasB4,
			Double notasalaaulab1, Double notasalaaulab2, Double notasalaaulab3, Double notasalaaulab4,
			Double notatarefasb1, Double notatarefasb2, Double notatarefasb3, Double notatarefasb4,
			Double notatrabalhob1, Double notatrabalhob2, Double notatrabalhob3, Double notatrabalhob4,
			Double notaprovab1, Double notaprovab2, Double notaprovab3, Double notaprovab4) {
		//super();
		this.id = id;
		this.faltasB1 = faltasB1;
		this.faltasB2 = faltasB2;
		this.faltasB3 = faltasB3;
		this.faltasB4 = faltasB4;
		notaSalaAulaB1 = notasalaaulab1;
		notaSalaAulaB2 = notasalaaulab2;
		notaSalaAulaB3 = notasalaaulab3;
		notaSalaAulaB4 = notasalaaulab4;
		notaTarefasB1 = notatarefasb1;
		notaTarefasB2 = notatarefasb2;
		notaTarefasB3 = notatarefasb3;
		notaTarefasB4 = notatarefasb4;
		notaTrabalhoB1 = notatrabalhob1;
		notaTrabalhoB2 = notatrabalhob2;
		notaTrabalhoB3 = notatrabalhob3;
		notaTrabalhoB4 = notatrabalhob4;
		notaProvaB1 = notaprovab1;
		notaProvaB2 = notaprovab2;
		notaProvaB3 = notaprovab3;
		notaProvaB4 = notaprovab4;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFaltasB1() {
		return faltasB1;
	}

	public void setFaltasB1(Integer faltasb1) {
		this.faltasB1 = faltasb1;
	}

	public Integer getFaltasB2() {
		return faltasB2;
	}

	public void setFaltasB2(Integer faltasb2) {
		this.faltasB2 = faltasb2;
	}

	
	public Integer getFaltasB3() {
		return faltasB3;
	}

	
	public void setFaltasB3(Integer faltasb3) {
		this.faltasB3 = faltasb3;
	}

	
	public Integer getFaltasB4() {
		return faltasB4;
	}

	

	public void setFaltasB4(Integer faltasb4) {
		this.faltasB4 = faltasb4;
	}

	

	public Double getNotaSalaAulaB1() {
		return notaSalaAulaB1;
	}

	
	public void setNotaSalaAulaB1(Double notasalaaula1) {
		notaSalaAulaB1 = notasalaaula1;
	}

	
	public Double getNotaSalaAulaB2() {
		return notaSalaAulaB2;
	}

	
	public void setNotaSalaAulaB2(Double notasalaaulab2) {
		notaSalaAulaB2 = notasalaaulab2;
	}

	
	public Double getNotaSalaAulaB3() {
		return notaSalaAulaB3;
	}

	
	public void setNotaSalaAulaB3(Double notasalaaulab3) {
		notaSalaAulaB3 = notasalaaulab3;
	}

	
	public Double getNotaSalaAulaB4() {
		return notaSalaAulaB4;
	}

	
	public void setNotaSalaAulaB4(Double notasalaaulab4) {
		notaSalaAulaB4 = notasalaaulab4;
	}

	
	public Double getNotaTarefasB1() {
		return notaTarefasB1;
	}

	
	public void setNotaTarefasB1(Double notatarefasb1) {
		notaTarefasB1 = notatarefasb1;
	}

	
	public Double getNotaTarefasB2() {
		return notaTarefasB2;
	}

	
	public void setNotaTarefasB2(Double notatarefasb2) {
		notaTarefasB2 = notatarefasb2;
	}

	public Double getNotaTarefasB3() {
		return notaTarefasB3;
	}

	public void setNotaTarefasB3(Double notatarefasb3) {
		notaTarefasB3 = notatarefasb3;
	}

	public Double getNotaTarefasB4() {
		return notaTarefasB4;
	}

	public void setNotaTarefasB4(Double notatarefasb4) {
		notaTarefasB4 = notatarefasb4;
	}

	public Double getNotaTrabalhoB1() {
		return notaTrabalhoB1;
	}

	public void setNotaTrabalhoB1(Double notatrabalhob1) {
		notaTrabalhoB1 = notatrabalhob1;
	}

	public Double getNotaTrabalhoB2() {
		return notaTrabalhoB2;
	}

	public void setNotaTrabalhoB2(Double notatrabalhob2) {
		notaTrabalhoB2 = notatrabalhob2;
	}

	public Double getNotaTrabalhoB3() {
		return notaTrabalhoB3;
	}

	public void setNotaTrabalhoB3(Double notatrabalhob3) {
		notaTrabalhoB3 = notatrabalhob3;
	}

	public Double getNotaTrabalhoB4() {
		return notaTrabalhoB4;
	}

	public void setNotaTrabalhoB4(Double notatrabalhob4) {
		notaTrabalhoB4 = notatrabalhob4;
	}

	public Double getNotaProvaB1() {
		return notaProvaB1;
	}

	public void setNotaProvaB1(Double notaprovab1) {
		notaProvaB1 = notaprovab1;
	}

	public Double getNotaProvaB2() {
		return notaProvaB2;
	}

	public void setNotaProvaB2(Double notaprovab2) {
		notaProvaB2 = notaprovab2;
	}

	public Double getNotaProvaB3() {
		return notaProvaB3;
	}

	public void setNotaProvaB3(Double notaprovab3) {
		notaProvaB3 = notaprovab3;
	}

	public Double getNotaProvaB4() {
		return notaProvaB4;
	}

	public void setNotaProvaB4(Double notaprovab4) {
		notaProvaB4 = notaprovab4;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public int getTotalFaltas() {
		return totalFaltas;
	}

	public void setTotalFaltas(int totalFaltas) {
		this.totalFaltas = totalFaltas;
	}
	
	public String getSituacaoAluno() {
		return situacaoAluno;
	}

	public void setSituacaoAluno(String situacaoAluno) {
		this.situacaoAluno = situacaoAluno;
	}
	
	public double mediaBimestre1() {
		return notaSalaAulaB1 
				+ notaTarefasB1 
				+ notaTrabalhoB1
				+ notaProvaB1
				;
	}
	public double mediaBimestre2() {
		return notaSalaAulaB2 
				+ notaTarefasB2 
				+ notaTrabalhoB2
				+ notaProvaB2
				;
	}
	public double mediaBimestre3() {
		return notaSalaAulaB3 
				+ notaTarefasB3 
				+ notaTrabalhoB3
				+ notaProvaB3
				;
	}
	public double mediaBimestre4() {
		return notaSalaAulaB4 
				+ notaTarefasB4 
				+ notaTrabalhoB4
				+ notaProvaB4
				;
	}
	public double mediaFinal() {
		return 	(mediaBimestre1() + mediaBimestre2() + mediaBimestre3() + mediaBimestre4())	/ 4;
	}
	
	public int totalFaltas() {
		return 	this.faltasB1
			  + this.faltasB2
			  + this.faltasB3
			  + this.faltasB4
				;
	
	}
	
	
	public String situacaoAluno() {
		if (totalFaltas() > 120 ) {
			return "REPROVADO";
		}
		if (totalFaltas() < 120 && mediaFinal() >= 6.0 ) {
			return "APROVADO";
		}
		if (totalFaltas() < 120 && mediaFinal() <= 5.0 ) {
			return "REPROVADO";
		}
		if (mediaFinal() > 5.0 && mediaFinal() < 6.0 ) {
			return "RECUPERACAO";
		}
		return situacaoAluno();
		
		
	
		
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notaProvaB1 == null) ? 0 : notaProvaB1.hashCode());
		result = prime * result + ((notaProvaB2 == null) ? 0 : notaProvaB2.hashCode());
		result = prime * result + ((notaProvaB3 == null) ? 0 : notaProvaB3.hashCode());
		result = prime * result + ((notaProvaB4 == null) ? 0 : notaProvaB4.hashCode());
		result = prime * result + ((notaSalaAulaB1 == null) ? 0 : notaSalaAulaB1.hashCode());
		result = prime * result + ((notaSalaAulaB2 == null) ? 0 : notaSalaAulaB2.hashCode());
		result = prime * result + ((notaSalaAulaB3 == null) ? 0 : notaSalaAulaB3.hashCode());
		result = prime * result + ((notaSalaAulaB4 == null) ? 0 : notaSalaAulaB4.hashCode());
		result = prime * result + ((notaTarefasB1 == null) ? 0 : notaTarefasB1.hashCode());
		result = prime * result + ((notaTarefasB2 == null) ? 0 : notaTarefasB2.hashCode());
		result = prime * result + ((notaTarefasB3 == null) ? 0 : notaTarefasB3.hashCode());
		result = prime * result + ((notaTarefasB4 == null) ? 0 : notaTarefasB4.hashCode());
		result = prime * result + ((notaTrabalhoB1 == null) ? 0 : notaTrabalhoB1.hashCode());
		result = prime * result + ((notaTrabalhoB2 == null) ? 0 : notaTrabalhoB2.hashCode());
		result = prime * result + ((notaTrabalhoB3 == null) ? 0 : notaTrabalhoB3.hashCode());
		result = prime * result + ((notaTrabalhoB4 == null) ? 0 : notaTrabalhoB4.hashCode());
		result = prime * result + ((faltasB1 == null) ? 0 : faltasB1.hashCode());
		result = prime * result + ((faltasB2 == null) ? 0 : faltasB2.hashCode());
		result = prime * result + ((faltasB3 == null) ? 0 : faltasB3.hashCode());
		result = prime * result + ((faltasB4 == null) ? 0 : faltasB4.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		NotasFaltas other = (NotasFaltas) obj;
		if (notaProvaB1 == null) {
			if (other.notaProvaB1 != null)
				return false;
		} else if (!notaProvaB1.equals(other.notaProvaB1))
			return false;
		if (notaProvaB2 == null) {
			if (other.notaProvaB2 != null)
				return false;
		} else if (!notaProvaB2.equals(other.notaProvaB2))
			return false;
		if (notaProvaB3 == null) {
			if (other.notaProvaB3 != null)
				return false;
		} else if (!notaProvaB3.equals(other.notaProvaB3))
			return false;
		if (notaProvaB4 == null) {
			if (other.notaProvaB4 != null)
				return false;
		} else if (!notaProvaB4.equals(other.notaProvaB4))
			return false;
		if (notaSalaAulaB1 == null) {
			if (other.notaSalaAulaB1 != null)
				return false;
		} else if (!notaSalaAulaB1.equals(other.notaSalaAulaB1))
			return false;
		if (notaSalaAulaB2 == null) {
			if (other.notaSalaAulaB2 != null)
				return false;
		} else if (!notaSalaAulaB2.equals(other.notaSalaAulaB2))
			return false;
		if (notaSalaAulaB3 == null) {
			if (other.notaSalaAulaB3 != null)
				return false;
		} else if (!notaSalaAulaB3.equals(other.notaSalaAulaB3))
			return false;
		if (notaSalaAulaB4 == null) {
			if (other.notaSalaAulaB4 != null)
				return false;
		} else if (!notaSalaAulaB4.equals(other.notaSalaAulaB4))
			return false;
		if (notaTarefasB1 == null) {
			if (other.notaTarefasB1 != null)
				return false;
		} else if (!notaTarefasB1.equals(other.notaTarefasB1))
			return false;
		if (notaTarefasB2 == null) {
			if (other.notaTarefasB2 != null)
				return false;
		} else if (!notaTarefasB2.equals(other.notaTarefasB2))
			return false;
		if (notaTarefasB3 == null) {
			if (other.notaTarefasB3 != null)
				return false;
		} else if (!notaTarefasB3.equals(other.notaTarefasB3))
			return false;
		if (notaTarefasB4 == null) {
			if (other.notaTarefasB4 != null)
				return false;
		} else if (!notaTarefasB4.equals(other.notaTarefasB4))
			return false;
		if (notaTrabalhoB1 == null) {
			if (other.notaTrabalhoB1 != null)
				return false;
		} else if (!notaTrabalhoB1.equals(other.notaTrabalhoB1))
			return false;
		if (notaTrabalhoB2 == null) {
			if (other.notaTrabalhoB2 != null)
				return false;
		} else if (!notaTrabalhoB2.equals(other.notaTrabalhoB2))
			return false;
		if (notaTrabalhoB3 == null) {
			if (other.notaTrabalhoB3 != null)
				return false;
		} else if (!notaTrabalhoB3.equals(other.notaTrabalhoB3))
			return false;
		if (notaTrabalhoB4 == null) {
			if (other.notaTrabalhoB4 != null)
				return false;
		} else if (!notaTrabalhoB4.equals(other.notaTrabalhoB4))
			return false;
		if (faltasB1 == null) {
			if (other.faltasB1 != null)
				return false;
		} else if (!faltasB1.equals(other.faltasB1))
			return false;
		if (faltasB2 == null) {
			if (other.faltasB2 != null)
				return false;
		} else if (!faltasB2.equals(other.faltasB2))
			return false;
		if (faltasB3 == null) {
			if (other.faltasB3 != null)
				return false;
		} else if (!faltasB3.equals(other.faltasB3))
			return false;
		if (faltasB4 == null) {
			if (other.faltasB4 != null)
				return false;
		} else if (!faltasB4.equals(other.faltasB4))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NotasFaltas [id=" + id + ", faltasB1=" + faltasB1 + ", faltasB2=" + faltasB2 + ", faltasB3=" + faltasB3
				+ ", faltasB4=" + faltasB4 + ", notaSalaAulaB1=" + notaSalaAulaB1 + ", notaSalaAulaB2=" + notaSalaAulaB2
				+ ", notaSalaAulaB3=" + notaSalaAulaB3 + ", notaSalaAulaB4=" + notaSalaAulaB4 + ", notaTarefasB1="
				+ notaTarefasB1 + ", notaTarefasB2=" + notaTarefasB2 + ", notaTarefasB3=" + notaTarefasB3
				+ ", notaTarefasB4=" + notaTarefasB4 + ", notaTrabalhoB1=" + notaTrabalhoB1 + ", notaTrabalhoB2="
				+ notaTrabalhoB2 + ", notaTrabalhoB3=" + notaTrabalhoB3 + ", notaTrabalhoB4=" + notaTrabalhoB4
				+ ", notaProvaB1=" + notaProvaB1 + ", notaProvaB2=" + notaProvaB2 + ", notaProvaB3=" + notaProvaB3
				+ ", notaProvaB4=" + notaProvaB4 + "]";
	}

		
	
	}