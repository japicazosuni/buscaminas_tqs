package Model;

public class Casilla {
  private Boolean abierta;
  private Boolean mina;
  private Integer fila;
  private Integer columna;

  public Casilla(Integer _fila, Integer _col ) {
    fila = _fila;
    columna = _col;
    
    abierta = false;
    mina = false;
  }

  public boolean getAbierta() {
	  return this.abierta;
  }
	
  public int getColumna() {
	  return this.columna;
  }
	
  public int getFila() {
	  return this.fila;
  }
  
  public boolean getMina() {
	  return this.mina;
  }
  
  public void setMina(Boolean _mina) {
	  this.mina = _mina;
  }
		
	
}