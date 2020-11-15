package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TableroTest {
	Tablero tablero;
	
	@Before
	public void setUp() throws Exception{
		tablero = new Tablero(9,9);
		tablero.initBoard();
	}

	@Test
	public void testInitBoard() {
		
		Casilla casilla1 = tablero.getCasilla(0, 0);
		assertTrue(casilla1.getAbierta() == false);
		assertTrue(casilla1.getMina() == false);	
		
		Casilla casilla2 = tablero.getCasilla(8, 8);
		assertTrue(casilla2.getAbierta() == false);
		assertTrue(casilla2.getMina() == false);	
		
		Casilla casilla3 = tablero.getCasilla(4, 4);
		assertTrue(casilla3.getAbierta() == false);
		assertTrue(casilla3.getMina() == false);	
		
		Casilla casilla4 = tablero.getCasilla(3, 4);
		assertTrue(casilla4.getAbierta() == false);		
		assertTrue(casilla4.getMina() == false);	
	}

	@Test
	public void testConstructor() {	
		assertTrue(tablero.getNumFilas() == 9);
		assertTrue(tablero.getNumCols() == 9);
	}
	
	@Test
	public void testColocarMinas() {
		int [][] posiciones = posicionesAleatoriasTablero();
		
		tablero.colocarMinas(posiciones);
		
		for (int i = 0; i < posiciones.length; i++) {
    		Casilla auxCasilla = tablero.getCasilla(posiciones[i][0],posiciones[i][1]);
    		assertEquals(auxCasilla.getMina(),true);
        }
	}
	
	@Test
	public void testContarMinasVecinas() {
		int [][] posiciones = posicionesAleatoriasTablero();
		tablero.colocarMinas(posiciones);
		tablero.contarMinasVecinas(posiciones);		
		
		Casilla casilla1 = tablero.getCasilla(1,0);
		assertEquals(casilla1.getMinasVecinas(),2);
		
		Casilla casilla2 = tablero.getCasilla(3,4);
		assertEquals(casilla2.getMinasVecinas(),3);
		
		Casilla casilla3 = tablero.getCasilla(7,4);
		assertEquals(casilla3.getMinasVecinas(),1);
		
		Casilla casilla4 = tablero.getCasilla(8,0);
		assertEquals(casilla4.getMinasVecinas(),0);
	}	
	
	private int[][] posicionesAleatoriasTablero() {
		int posiciones[][] = new int[10][2];
		
		posiciones[0][0] = 0;
		posiciones[0][1] = 0;
		
		posiciones[1][0] = 0;
		posiciones[1][1] = 1;
		
		posiciones[2][0] = 1;
		posiciones[2][1] = 2;
		
		posiciones[3][0] = 4;
		posiciones[3][1] = 4;
		
		posiciones[4][0] = 6;
		posiciones[4][1] = 4;
		
		posiciones[5][0] = 2;
		posiciones[5][1] = 3;
		
		posiciones[6][0] = 7;
		posiciones[6][1] = 7;
		
		posiciones[7][0] = 3;
		posiciones[7][1] = 5;
		
		posiciones[8][0] = 8;
		posiciones[8][1] = 8;

		posiciones[9][0] = 6;
		posiciones[9][1] = 7;
		
		return posiciones;
	}
	
	@Test
	public void testMarcarCasilla() {
		Casilla casilla = new Casilla(1,1);
		casilla.setMarcada(true);
		assertEquals(casilla.getMarcada(),true);
		
		Casilla casilla2 = new Casilla(2,2);
		assertEquals(casilla2.getMarcada(),false);
	}
	
	@Test
	public void testDesmarcarCasilla() {
		Casilla casilla = new Casilla(1,1);
		casilla.setMarcada(false);
		assertEquals(casilla.getMarcada(),false);
		
		Casilla casilla2 = new Casilla(2,2);
		assertEquals(casilla2.getMarcada(),false);
	}
	
	@Test
	public void testAbrirCasilla() {
		Casilla casilla = new Casilla(1,1);
		assertEquals(casilla.getAbierta(),false);
		assertEquals(casilla.getMarcada(),false);
		assertEquals(casilla.getMina(),false);
		casilla.setAbierta(true);
		assertEquals(casilla.getAbierta(),true);
		
		int [][] posiciones = casilla.getPosicionVecinos(tablero.getNumFilas(), tablero.getNumFilas());
		for (int i = 0; i < posiciones.length; i++) {
    		Casilla auxCasilla = tablero.getCasilla(posiciones[i][0],posiciones[i][1]);
    		
    		assertEquals(auxCasilla.getAbierta(),false);
    		assertEquals(auxCasilla.getMarcada(),false);
    		assertEquals(auxCasilla.getMina(),false);
    		auxCasilla.setAbierta(true);
    		assertEquals(auxCasilla.getAbierta(),true);
		}
	}
	
	
}
