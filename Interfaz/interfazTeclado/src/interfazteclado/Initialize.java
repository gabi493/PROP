/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfazteclado;

/**
 *
 * @author gabrielcarrillolopez
 */
public class Initialize extends javax.swing.JFrame {

	/**
	 * Creates new form Initialize
	 */
    
    teclado tec = new teclado();
	int valorDescartado;
	int np;
	int nuevoNp;
    int matrizDistancias[][];
	int matrizDistanciasCompacta[][];
	int matrizTeclado[][];
    int primerasPosicionesForma[];
    distancia dist = new distancia();
    
    
	
	
	public Initialize() {
		initComponents();
		inicializarCampos();
	}
    
	public void inicializarCampos() {
		this.lbMsg.setText("");
	}
	
        public void recibirTeclado(teclado tec) {
            this.tec = tec;
            this.np = this.tec.getNumeroPosiciones();
			int filas = tec.getNumeroFilas();
			int columnas = tec.getNumeroColumnas();
			valorDescartado = -1;
            matrizDistancias = new int[np][np];
			matrizTeclado = new int[filas][columnas];
			primerasPosicionesForma = new int[tec.getNumeroFilas()];
            this.dist = new distancia(tec.getForma(), tec.getNumeroFilas(), tec.getNumeroColumnas(), tec.getNumeroPosiciones());
            if ("Rectangular".equals(tec.getForma())) matrizDistanciasRect();
            else if ("Hexagonal".equals(tec.getForma())) matrizDistanciasHex();
            
        }
        
        public void matrizDistanciasHex() {
			//System.out.println("entra en matrizDistanciasHex");
            int filas = tec.getNumeroFilas();
            int columnas = tec.getNumeroColumnas();
			//System.out.println("filas = " + filas + "	columnas = " + columnas + "	posiciones = " + tec.getNumeroPosiciones());
			
			crearMatrizTecladoHexagonal(filas);
			dibujarMatrizTeclado(filas, columnas);
			
			crearMatrizDistancias(filas, columnas);	//<-- -  -   -    -     -      -
			compactarMatrizDistancias(filas, columnas);
			dibujarMatrizDistancias();
			dibujarMatrizDistanciasCompacta();
        }
		
		void crearMatrizTecladoHexagonal (int filas) {
			//System.out.println("entra en crearMatrizTecladoHex");
			int nPos = filas/2;
            rellenarDescartados (filas, nPos);
			rellenarResto();
		}
		
		void rellenarResto() {
			int filas = tec.getNumeroFilas();
            int columnas = tec.getNumeroColumnas();
			int valor = 0;
			//System.out.println("np antes = " + np);
			for (int i = 0; i < filas; ++i) {
				for (int j = 0; j < columnas; ++j) {
					if (matrizTeclado[i][j] != valorDescartado) {
						matrizTeclado[i][j] = valor;
						++valor;
					}
				}
			}
			//tec.setNumeroPosiciones(valor);
			this.nuevoNp = valor;
			//System.out.println("nuevoNp = " + nuevoNp);
		}
		
		void rellenarDescartados (int filas, int nPos) {
			for (int filaI = 0; filaI < filas/2; ++filaI) {
				rellenaPpioFin(filaI, nPos);
				--nPos;
			}
			nPos = filas/2;
            for (int filaI = filas - 1; filaI > filas/2; --filaI) {
				rellenaPpioFin(filaI, nPos);
				--nPos;
			}
		}
		
		void rellenaPpioFin(int filaI, int nPos) {
			int columnas = tec.getNumeroColumnas();
			for (int j = 0; j < nPos; ++j) {
				matrizTeclado[filaI][j] = valorDescartado;
				matrizTeclado[filaI][columnas - (j+1)] = valorDescartado;
			}
		}
		
		
        public void matrizDistanciasRect() {
            int filas = tec.getNumeroFilas();
            int columnas = tec.getNumeroColumnas();
			tec.setNumeroPosiciones(filas*columnas);
			//System.out.println("filas = " + filas + "	columnas = " + columnas + "	posiciones = " + tec.getNumeroPosiciones());
            for (int filaI = 0; filaI < filas; ++filaI) {
                this.dist.setPrimeraPosicionForma(filaI, filaI*columnas);
            }
            for (int filaI = 0; filaI < filas; ++filaI) {
                this.primerasPosicionesForma[filaI] = this.dist.getPrimeraPosicionForma(filaI);
            }
			rellenarMatrizDistanciasCuadradas();
            
        }
        
		public void rellenarMatrizDistanciasCuadradas() {
			int filas = tec.getNumeroFilas();
			int columnas = tec.getNumeroColumnas();
			
			crearMatrizTecladoRectangular(filas, columnas);
			dibujarMatrizTeclado(filas, columnas);
			
			crearMatrizDistancias(filas, columnas);
			dibujarMatrizDistancias();
        }
		
		/*
			0	1	2 (col)		0	1	2	3	4	5
		 ------------		 ------------------------
		0|	0	1	2		0|	0	1	2	1	2	3
		 |					 |						
		1|	3	4	5		1|	1	0	1	2	1	2
	(fila)					 |						
							2|	2	1	0	3	2	1
							 |						
							3|	1	2	3	0	1	2
							 |						
							4|	2	1	2	1	0	1
							 |						
							5|	3	2	1	2	1	0
		
		*/
		
		
		public int getFila(int i, int columnas) {
			return i/columnas;
		}
		
		public int getColumna(int j, int columnas) {
			return j%columnas;
		}
		
		public void setDist(int fila, int columna, int distancia) {
			matrizDistancias[fila][columna] = distancia;
			//System.out.print("		cierto");
			matrizDistancias[columna][fila] = distancia;
			//System.out.print(" ;)");
		}
		
		public void crearMatrizTecladoRectangular(int filas, int columnas) {
			//System.out.println("entra en crearMatrizTecladoRectangular");
			for (int i = 0; i < filas; ++i) {
				for (int j = 0; j < columnas; ++j) {
					matrizTeclado[i][j] = i*columnas + j;
				}
			}
			System.out.println();
		}
		
		public void dibujarMatrizTeclado(int filas, int columnas) {
			System.out.println("entra en dibujarMatrizTeclado");
			System.out.println();
			for (int i = 0; i < filas; ++i) {
				for (int j = 0; j < columnas; ++j) {
					int num = matrizTeclado[i][j];
					System.out.print(num + " ");
					if (num < 10) System.out.print(" ");
					if (num >= 0) System.out.print(" ");
				}
				System.out.println();
				System.out.println();
			}
			System.out.println();
		}
		
        /*public void crearMatrizDistancias(int filas, int columnas, int np) {
			for (int i = 0; i < np; ++i) {
				for (int j = i; j < np; ++j) {
					int iF = getFila(i, columnas);
					int iC = getColumna(i, columnas);
					int jF = getFila(j, columnas);
					int jC = getColumna(j, columnas);
					
					int distFilas = jF - iF;
					if (distFilas < 0) distFilas = -distFilas;
					int distColumnas = jC - iC;
					if (distColumnas < 0) distColumnas = -distColumnas;
		
					int dm = distFilas + distColumnas;
					setDist(i, j, dm);
					
				}
			}
        }*/
		
		public void crearMatrizDistancias(int filas, int columnas) {
			//System.out.println("entra en crearMatrizDistancias con np = " + np);
			for (int i = 0; i < np; ++i) {
				for (int j = i; j < np; ++j) {
					int iF = getFila(i, columnas);
					int iC = getColumna(i, columnas);
					int jF = getFila(j, columnas);
					int jC = getColumna(j, columnas);
					//System.out.print("entrará...?");
					if (matrizTeclado[iF][iC] != valorDescartado && matrizTeclado[jF][jC] != valorDescartado) {
						int distFilas = jF - iF;
						if (distFilas < 0) distFilas = -distFilas;
						int distColumnas = jC - iC;
						if (distColumnas < 0) distColumnas = -distColumnas;

						int dm = distFilas + distColumnas;
						//System.out.print("	matrizDistancias = " + matrizDistancias.length + "	");
						//System.out.print("...SÍ!	[" + i + "][" + j + "] = " + dm);
						setDist(i, j, dm);
					}
					//System.out.println();
				}
			}
        }
		
		void compactarMatrizDistancias(int filas, int columnas) {
			//System.out.println("entra en compactarMatrizDistancias");
			matrizDistanciasCompacta = new int[nuevoNp][nuevoNp];		//int[np][np];
			int iC = 0;
			int jC = 0;
			boolean b = true;
			for (int i = 1; i < np; ++i) {								//empezaba en i = 0;
				for (int j = 1; j < np; ++j) {							//empezaba en j = 0;
					if ((iC == jC) || (matrizDistancias[i][j] != 0)) {	//(matrizDistancias[i][j] != 0) || (i == j)
						if (b) {			//if ((i != 0) && (j != 0)) {
							matrizDistanciasCompacta[iC][jC] = matrizDistancias[i][j];
							//System.out.println("matrizDistanciasCompacta[" + iC + "][" + jC + "] = " + matrizDistanciasCompacta[iC][jC]);
							++jC;
							if (jC == nuevoNp) {		//np) {
								++iC;
								jC = 0;
								if (iC == nuevoNp) b = false;
							}
						}
					}
				}
			}
		}
		
		public void dibujarMatrizDistanciasCompacta() {
			System.out.println("entra en dibujarMatrizDistanciasCompacta");
			System.out.println();
			for (int i = 0; i < nuevoNp; ++i) {
				for (int j = 0; j < nuevoNp; ++j) {
					int num = matrizDistanciasCompacta[i][j];
					System.out.print(num + " ");
					if (num < 10) System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println();
			np = nuevoNp;
			tec.setNumeroPosiciones(np);
		}
		
		public void dibujarMatrizDistancias() {
			System.out.println("entra en dibujarMatrizDistancias");
			System.out.println();
			for (int i = 0; i < np; ++i) {
				for (int j = 0; j < np; ++j) {
					int num = matrizDistancias[i][j];
					System.out.print(num + " ");
					if (num < 10) System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println();
		}
        
	public void recibirMsg(String s) {
		this.lbMsg.setText(s);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        btVisualizacion = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        lbMsg = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnAlfabeto = new javax.swing.JMenu();
        mnCjtoTextos = new javax.swing.JMenu();
        mnTeclado = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTitulo.setText("giTeclado");

        btVisualizacion.setBackground(new java.awt.Color(0, 204, 51));
        btVisualizacion.setText("VISUALIZACIÓN");

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        lbMsg.setText("jLabel1");

        mnAlfabeto.setText("ALFABETO");
        mnAlfabeto.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnAlfabetoMenuSelected(evt);
            }
        });
        jMenuBar1.add(mnAlfabeto);

        mnCjtoTextos.setText("CJTO TEXTOS");
        mnCjtoTextos.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnCjtoTextosMenuSelected(evt);
            }
        });
        jMenuBar1.add(mnCjtoTextos);

        mnTeclado.setText("TECLADO");
        mnTeclado.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mnTecladoMenuSelected(evt);
            }
        });
        mnTeclado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTecladoActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnTeclado);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btVisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addGap(62, 62, 62)
                .addComponent(btVisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalir)
                    .addComponent(lbMsg))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnTecladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTecladoActionPerformed
		//no ha de hacer nada
    }//GEN-LAST:event_mnTecladoActionPerformed

    private void mnTecladoMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnTecladoMenuSelected
   		Initialize.this.setVisible(false);
		configurarTeclado confTeclado = new configurarTeclado(Initialize.this, tec);
		confTeclado.setVisible(true);
    }//GEN-LAST:event_mnTecladoMenuSelected

    private void mnCjtoTextosMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnCjtoTextosMenuSelected
        Initialize.this.setVisible(false);
		configurarCTextos confCT = new configurarCTextos();
		confCT.setVisible(true);
    }//GEN-LAST:event_mnCjtoTextosMenuSelected

    private void mnAlfabetoMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mnAlfabetoMenuSelected
        Initialize.this.setVisible(false);
		configurarAlfabeto confAlf = new configurarAlfabeto();
		confAlf.setVisible(true);
    }//GEN-LAST:event_mnAlfabetoMenuSelected

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSalirActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Initialize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Initialize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Initialize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Initialize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Initialize().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalir;
    private javax.swing.JButton btVisualizacion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JMenu mnAlfabeto;
    private javax.swing.JMenu mnCjtoTextos;
    private javax.swing.JMenu mnTeclado;
    // End of variables declaration//GEN-END:variables
}
