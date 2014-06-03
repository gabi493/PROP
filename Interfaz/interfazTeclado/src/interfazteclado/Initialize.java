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
    int matrizDistancias[][];
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
            int np = this.tec.getNumeroPosiciones();
			int filas = tec.getNumeroFilas();
			int columnas = tec.getNumeroColumnas();
            matrizDistancias = new int[np][np];
			matrizTeclado = new int[filas][columnas];
			primerasPosicionesForma = new int[tec.getNumeroFilas()];
            this.dist = new distancia(tec.getForma(), tec.getNumeroFilas(), tec.getNumeroColumnas(), tec.getNumeroPosiciones());
            if ("Rectangular".equals(tec.getForma())) matrizDistanciasRect(np);
            else if ("Hexagonal".equals(tec.getForma())) matrizDistanciasHex(np);
            
        }
        
        public void matrizDistanciasHex(int np) {
            
        }
	
        public void matrizDistanciasRect(int np) {
            int filas = tec.getNumeroFilas();
            int columnas = tec.getNumeroColumnas();
			System.out.println("filas = " + filas + "	columnas = " + columnas + "	posiciones = " + tec.getNumeroPosiciones());
            for (int filaI = 0; filaI < filas; ++filaI) {
                this.dist.setPrimeraPosicionForma(filaI, filaI*columnas);
            }
            for (int filaI = 0; filaI < filas; ++filaI) {
                this.primerasPosicionesForma[filaI] = this.dist.getPrimeraPosicionForma(filaI);
            }
            //rellenarMatrizDistancias(np);
			rellenarMatrizDistanciasCuadradas(np);
            
        }
        
		public void rellenarMatrizDistanciasCuadradas(int np) {
			int filas = tec.getNumeroFilas();
			int columnas = tec.getNumeroColumnas();
			
			crearMatrizTeclado(filas, columnas);
			dibujarMatrizTeclado(filas, columnas);
			
			crearMatrizDistancias(filas, columnas, np);
			dibujarMatrizDistancias(np);
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
		
		
		if = getFila(i)
		ic = getColumna(i)
		jf = getFila(j)
		jc = getColumna(j)
		
		dist = (jf - if) + (jc - ic)
		setDist(i, j, dist)
		*/
		
		
		public int getFila(int i, int columnas) {
			return i/columnas;
		}
		
		public int getColumna(int j, int columnas) {
			return j%columnas;
		}
		
		public void setDist(int fila, int columna, int distancia) {
			matrizDistancias[fila][columna] = distancia;
			matrizDistancias[columna][fila] = distancia;
		}
		
		public void crearMatrizTeclado(int filas, int columnas) {
			for (int i = 0; i < filas; ++i) {
				for (int j = 0; j < columnas; ++j) {
					matrizTeclado[i][j] = i*columnas + j;
				}
			}
			System.out.println();
		}
		
		public void dibujarMatrizTeclado(int filas, int columnas) {
			for (int i = 0; i < filas; ++i) {
				System.out.println();
				for (int j = 0; j < columnas; ++j) {
					int num = matrizTeclado[i][j];
					System.out.print(num + " ");
					if (num < 10) System.out.print(" ");
				}
			}
			System.out.println();
		}
		
        public void crearMatrizDistancias(int filas, int columnas, int np) {
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
					
					/*int num = (j - i)%(columnas);
					num += (j - i)/columnas;
					if ((i%columnas == columnas - 1)&&(j%columnas == 0)) num = columnas + j%filas - 1;
					this.matrizDistancias[i][j] = num;
					this.matrizDistancias[j][i] = num;*/
					
				}
			}
        }
		
		public void dibujarMatrizDistancias(int np) {
			for (int i = 0; i < np; ++i) {
				System.out.println();
				for (int j = 0; j < np; ++j) {
					int num = matrizDistancias[i][j];
					System.out.print(num + " ");
					if (num < 10) System.out.print(" ");
				}
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
