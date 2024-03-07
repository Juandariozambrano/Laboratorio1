import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Clase base Moneda

class Moneda {
	
    BigDecimal cantidad;

    public Moneda(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    // Método para convertir a otras monedas
    public BigDecimal en(String monedaDestino) {
        // Implementa las conversiones aquí
        // Por defecto, no se realiza ninguna conversión
        return cantidad;
    }

    // Método para comparar con otra moneda
    public String comparar(Moneda otraMoneda) {
        int comparacion = cantidad.compareTo(otraMoneda.cantidad);
        if (comparacion < 0) {
            return ":menor";
        } else if (comparacion > 0) {
            return ":mayor";
        } else {
            return ":igual";
        }
    }
}

// Subclase Dolar
class Dolar extends Moneda {
    public Dolar(BigDecimal cantidad) {
        super(cantidad);
    }

    @Override
    public BigDecimal en(String monedaDestino) {
        // Implementa las conversiones a otras monedas aquí
        // Ejemplo: Dólar a Euro
        Map<String, BigDecimal> tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("euros", new BigDecimal("0.85"));
        tasasDeCambio.put("bolivares", new BigDecimal("36.17"));
        tasasDeCambio.put("bitcoins", new BigDecimal("0.00002"));
        tasasDeCambio.put("yen", new BigDecimal("148.84"));


        if (tasasDeCambio.containsKey(monedaDestino)) {
            BigDecimal tasa = tasasDeCambio.get(monedaDestino);
            return cantidad.multiply(tasa);
        } else {
            return super.en(monedaDestino);
        }
    }
}
    
//subclase Euro  
    class Euro extends Moneda {
        public Euro (BigDecimal cantidad) {
            super(cantidad);
        }

        @Override
        public BigDecimal en(String monedaDestino) {
            // Implementa las conversiones a otras monedas aquí
            Map<String, BigDecimal> tasasDeCambio = new HashMap<>();
            tasasDeCambio.put("dolar", new BigDecimal("1.09"));
            tasasDeCambio.put("bolivares", new BigDecimal("39.37"));
            tasasDeCambio.put("bitcoins", new BigDecimal("0.000017"));
            tasasDeCambio.put("yen", new BigDecimal("162.22"));

            if (tasasDeCambio.containsKey(monedaDestino)) {
                BigDecimal tasa = tasasDeCambio.get(monedaDestino);
                return cantidad.multiply(tasa);
            } else {
                return super.en(monedaDestino);
            }
        }
    }       

 //Subclase Yen
        class Yen extends Moneda {
            public Yen (BigDecimal cantidad) {
                super(cantidad);
            }

            @Override
            public BigDecimal en(String monedaDestino) {
                // Implementa las conversiones a otras monedas aquí
                Map<String, BigDecimal> tasasDeCambio = new HashMap<>();
                tasasDeCambio.put("dolar", new BigDecimal("0.0067"));
                tasasDeCambio.put("bolivares", new BigDecimal("24.26"));
                tasasDeCambio.put("bitcoins", new BigDecimal("0,0000001017335"));
                tasasDeCambio.put("Euro", new BigDecimal("0,0061628"));

                if (tasasDeCambio.containsKey(monedaDestino)) {
                    BigDecimal tasa = tasasDeCambio.get(monedaDestino);
                    return cantidad.multiply(tasa);
                } else {
                    return super.en(monedaDestino);
                }
            }
        }        
  
 // Subclase Bolivares
        class Bolivares extends Moneda {
                public Bolivares (BigDecimal cantidad) {
                    super(cantidad);
                }

                @Override
                public BigDecimal en(String monedaDestino) {
                    // Implementa las conversiones a otras monedas aquí
                    Map<String, BigDecimal> tasasDeCambio = new HashMap<>();
                    tasasDeCambio.put("dolar", new BigDecimal("0,0000002769"));
                    tasasDeCambio.put("yen", new BigDecimal("0,0000416188"));
                    tasasDeCambio.put("bitcoins", new BigDecimal("0,00000000000418906"));
                    tasasDeCambio.put("Euro", new BigDecimal("0,0000254295"));

                    if (tasasDeCambio.containsKey(monedaDestino)) {
                        BigDecimal tasa = tasasDeCambio.get(monedaDestino);
                        return cantidad.multiply(tasa);
                    } else {
                        return super.en(monedaDestino);
                    }
                }
         }
        
      //Subclase Bitcoin
        
        class Bitcoin extends Moneda {
             public Bitcoin (BigDecimal cantidad) {
                        super(cantidad);
              }

              @Override
              public BigDecimal en(String monedaDestino) {
              // Implementa las conversiones a otras monedas aquí
              Map<String, BigDecimal> tasasDeCambio = new HashMap<>();
              tasasDeCambio.put("dolar", new BigDecimal("66,175.80"));
              tasasDeCambio.put("yen", new BigDecimal("9,845,668.61"));
              tasasDeCambio.put("bolivares", new BigDecimal("2,388,056.98"));
              tasasDeCambio.put("Euro", new BigDecimal("60,693.13"));

                    if (tasasDeCambio.containsKey(monedaDestino)) {
                      BigDecimal tasa = tasasDeCambio.get(monedaDestino);
                      return cantidad.multiply(tasa);
                     } else {
                         return super.en(monedaDestino);
                      }
               }
        }
      
               
public class Mon {  
    
        public static void main(String[] args) {
        	
        //Modelo para convercion de moneda
        /*Dolar dolar = new Dolar(new BigDecimal("15"));
        BigDecimal euros = dolar.en("euros");
        System.out.println("15 dólares en euros: " + euros);
		
		Modelo paracomparacion de moneda
        Moneda bolivares = new Moneda(new BigDecimal("50"));
        Moneda dolares = new Dolar(new BigDecimal("2"));
        String comparacion = bolivares.comparar(dolares);
        System.out.println("Comparación: " + comparacion);*/
        	
       int Select, Select2=0;
       float cant, comp1, comp2;
       String aux, aux2;
        	Scanner teclado=new Scanner(System.in), capt=new Scanner(System.in);
            System.out.println("Conversion & Comparasion de Moneda");
            System.out.println("Seleccione la opcion deseada");
            
            do {

                System.out.println("1 - Convertir");
                System.out.println("2 - Comparar");
                System.out.println("3 - Salir");
                Select=Integer.parseInt(teclado.next());
                //caso de querer convertir a de unamoneda, te muestra el equivalente en las demas
                switch(Select) {
                case 1:
                	while(Select2<=5) {
                		System.out.println("Elija moneda a convertir");
                        System.out.println("1 - Dolar");
                        System.out.println("2 - Yen");
                        System.out.println("3 - Euro");
                        System.out.println("4 - Bitcoin");
                        System.out.println("5 - Bolivares");
                        System.out.println("6 - Volver al Menu Principal");
                		Select2=Integer.parseInt(teclado.next());
                		if(Select2==1) {
                			System.out.println("Inserte la cantidad a converitir: ");
                			cant=capt.nextFloat();
                			Dolar dolar = new Dolar(new BigDecimal(cant));
                	        BigDecimal euros = dolar.en("euros");
                	        System.out.println(cant+" dólares en euros: " + euros);
                	        BigDecimal yen = dolar.en("yen");
                	        System.out.println(cant+" dólares en yen: " + yen);
                	        BigDecimal Bitcoin = dolar.en("Bitcoin");
                	        System.out.println(cant+" dólares en Bitcoin: " + Bitcoin);
                	        BigDecimal Bolivares = dolar.en("Bolivares");
                	        System.out.println(cant+" dólares en Bolivares: " + Bolivares);
                	        
                		}else if(Select2==2) {
                			System.out.println("Inserte la cantidad a converitir: ");
                			cant=capt.nextFloat();
                			Yen yen = new Yen(new BigDecimal(cant));
                	        BigDecimal euros = yen.en("euros");
                	        System.out.println(cant+" yen en euros: " + euros);
                	        BigDecimal Dolar = yen.en("dolar");
                	        System.out.println(cant+" yen en dolares: " + Dolar);
                	        BigDecimal Bitcoin = yen.en("Bitcoin");
                	        System.out.println(cant+" yen en Bitcoin: " + Bitcoin);
                	        BigDecimal Bolivares = yen.en("Bolivares");
                	        System.out.println(cant+" yen en Bolivares: " + Bolivares);
                	        
                		}else if(Select2==3) {
                			System.out.println("Inserte la cantidad a converitir: ");
                			cant=capt.nextFloat();
                			Euro euros = new Euro(new BigDecimal(cant));
                	        BigDecimal yen = euros.en("yen");
                	        System.out.println(cant+" euros en yen: " + yen);
                	        BigDecimal Dolar = euros.en("dolar");
                	        System.out.println(cant+" euro en dolares: " + Dolar);
                	        BigDecimal Bitcoin = euros.en("Bitcoin");
                	        System.out.println(cant+" euro en Bitcoin: " + Bitcoin);
                	        BigDecimal Bolivares = euros.en("Bolivares");
                	        System.out.println(cant+" euro en Bolivares: " + Bolivares);
                	        
                		}else if(Select2==4) {
                			System.out.println("Inserte la cantidad a converitir: ");
                			cant=capt.nextFloat();
                			Bitcoin bit= new Bitcoin(new BigDecimal(cant));
                	        BigDecimal yen = bit.en("yen");
                	        System.out.println(cant+" bitcoin en yen: " + yen);
                	        BigDecimal Dolar = bit.en("dolar");
                	        System.out.println(cant+" bitcoin en dolares: " + Dolar);
                	        BigDecimal euros = bit.en("euros");
                	        System.out.println(cant+" bitcoin en euros: " + euros);
                	        BigDecimal Bolivares = bit.en("Bolivares");
                	        System.out.println(cant+" euro en Bolivares: " + Bolivares);
                	        
                		}else if(Select2==5) {
                			System.out.println("Inserte la cantidad a converitir: ");
                			cant=capt.nextFloat();
                			Bolivares bol = new Bolivares(new BigDecimal(cant));
                	        BigDecimal yen = bol.en("yen");
                	        System.out.println(cant+" bolivares en yen: " + yen);
                	        BigDecimal Dolar = bol.en("dolar");
                	        System.out.println(cant+" bolivares en dolares: " + Dolar);
                	        BigDecimal Bitcoin = bol.en("Bitcoin");
                	        System.out.println(cant+" bolivares en Bitcoin: " + Bitcoin);
                	        BigDecimal euros = bol.en("Euros");
               	        System.out.println(cant+" bolivares en euros: " + euros);
                	}
                }
                	//break;
                case 2:
              		System.out.println("Elija moneda a comparar");
              		aux=capt.nextLine();
              		System.out.println("Inserte cantidad");
              		comp1=capt.nextFloat();
              		System.out.println("Se desea comparar: "+comp1+" "+aux);
              		
              		System.out.println("Elija moneda con la que se quiera comparar");
              		aux2=capt.nextLine();
              		System.out.println("Inserte cantidad");
              		comp2=capt.nextFloat();
              		System.out.println("Se desea comparar "+comp1+" "+aux+" con: "+comp2+" "+aux2);
              		
              		//Comparando Bolivares con
              		if(aux.equalsIgnoreCase("Bolivares")&&aux2.equalsIgnoreCase("Dolares")) {  
              			
              		   Moneda bolivares = new Bolivares(new BigDecimal(comp1));
              	       Moneda dolares = new Dolar(new BigDecimal(comp2));
              	       String comparacion = bolivares.comparar(dolares);
              	       System.out.println("Comparación: " + comparacion);
              			
              		}else if(aux.equalsIgnoreCase("Bolivares")&&aux2.equalsIgnoreCase("Euros")) {  
              			
               		   Moneda bolivares = new Bolivares(new BigDecimal(comp1));
               	       Moneda euro = new Euro(new BigDecimal(comp2));
               	       String comparacion = bolivares.comparar(euro);
               	       System.out.println("Comparación: " + comparacion);
               			
               		}else if(aux.equalsIgnoreCase("Bolivares")&&aux2.equalsIgnoreCase("Yenes")) {  
              			
                		   Moneda bolivares = new Bolivares(new BigDecimal(comp1));
                	       Moneda yen = new Yen(new BigDecimal(comp2));
                	       String comparacion = bolivares.comparar(yen);
                	       System.out.println("Comparación: " + comparacion);
                			
                	}else if(aux.equalsIgnoreCase("Bolivares")&&aux2.equalsIgnoreCase("Bitcoins")) {  
              			
                		   Moneda bolivares = new Bolivares(new BigDecimal(comp1));
                	       Moneda Bitcoin = new Bitcoin(new BigDecimal(comp2));
                	       String comparacion = bolivares.comparar(Bitcoin);
                	       System.out.println("Comparación: " + comparacion);
                			
                	}
              		
              		//Comparando dolares con:
              		
              		if(aux.equalsIgnoreCase("Dolares")&&aux2.equalsIgnoreCase("Bolivares")) {  
              			
               		   Moneda dolares = new Dolar(new BigDecimal(comp1));
               	       Moneda Bolivares = new Bolivares(new BigDecimal(comp2));
               	       String comparacion = dolares.comparar(Bolivares);
               	       System.out.println("Comparación: " + comparacion);
               			
               		}else if(aux.equalsIgnoreCase("Dolares")&&aux2.equalsIgnoreCase("Euros")) {  
              			
                		   Moneda dolares = new Dolar(new BigDecimal(comp1));
                	       Moneda euro = new Euro(new BigDecimal(comp2));
                	       String comparacion = dolares.comparar(euro);
                	       System.out.println("Comparación: " + comparacion);
                			
                	}else if(aux.equalsIgnoreCase("Dolares")&&aux2.equalsIgnoreCase("Yenes")) {  
              			
                		   Moneda dolares = new Dolar(new BigDecimal(comp1));
                	       Moneda yen = new Yen(new BigDecimal(comp2));
                	       String comparacion = dolares.comparar(yen);
                	       System.out.println("Comparación: " + comparacion);
                			
                	}else if(aux.equalsIgnoreCase("Dolares")&&aux2.equalsIgnoreCase("Bitcoins")) {  
                  			
                    		Moneda dolares = new Dolar(new BigDecimal(comp1));
                    	    Moneda bitcoin = new Bitcoin(new BigDecimal(comp2));
                    	    String comparacion = dolares.comparar(bitcoin);
                    	    System.out.println("Comparación: " + comparacion);
                    			
                    }
              		
              		//Comparando euros con:
              		
              		if(aux.equalsIgnoreCase("Euros")&&aux2.equalsIgnoreCase("Bolivares")) {  
              			
               		   Moneda euro = new Euro(new BigDecimal(comp1));
               	       Moneda Bolivares = new Bolivares(new BigDecimal(comp2));
               	       String comparacion = euro.comparar(Bolivares);
               	       System.out.println("Comparación: " + comparacion);
               			
               		}else if(aux.equalsIgnoreCase("Euros")&&aux2.equalsIgnoreCase("Dolares")) {  
              			
                		   Moneda euro = new Euro(new BigDecimal(comp1));
                	       Moneda dolares = new Dolar(new BigDecimal(comp2));
                	       String comparacion = euro.comparar(dolares);
                	       System.out.println("Comparación: " + comparacion);
                			
                	}else if(aux.equalsIgnoreCase("Euros")&&aux2.equalsIgnoreCase("Yenes")) {  
              			
             		   Moneda euro = new Euro(new BigDecimal(comp1));
             	       Moneda yen = new Yen(new BigDecimal(comp2));
             	       String comparacion = euro.comparar(yen);
             	       System.out.println("Comparación: " + comparacion);
             			
             	}else if(aux.equalsIgnoreCase("Euros")&&aux2.equalsIgnoreCase("Bitcoins")) {  
          			
         		   Moneda euro = new Euro(new BigDecimal(comp1));
         	       Moneda bitcoin = new Bitcoin(new BigDecimal(comp2));
         	       String comparacion = euro.comparar(bitcoin);
         	       System.out.println("Comparación: " + comparacion);
         	       
             	}
              		
              		//Comparando yen con:
              		
              		if(aux.equalsIgnoreCase("yenes")&&aux2.equalsIgnoreCase("Bolivares")) {  
              			
               		   Moneda yen = new Yen(new BigDecimal(comp1));
               	       Moneda Bolivares = new Bolivares(new BigDecimal(comp2));
               	       String comparacion = yen.comparar(Bolivares);
               	       System.out.println("Comparación: " + comparacion);
               			
               		}else if(aux.equalsIgnoreCase("Yenes")&&aux2.equalsIgnoreCase("Dolares")) {  
              			
                		   Moneda yen = new Yen(new BigDecimal(comp1));
                	       Moneda dolares = new Dolar(new BigDecimal(comp2));
                	       String comparacion = yen.comparar(dolares);
                	       System.out.println("Comparación: " + comparacion);
                			
                	}else if(aux.equalsIgnoreCase("yenes")&&aux2.equalsIgnoreCase("euros")) {  
              			
                		   Moneda yen = new Yen(new BigDecimal(comp1));
                	       Moneda euro = new Euro(new BigDecimal(comp2));
                	       String comparacion = yen.comparar(euro);
                	       System.out.println("Comparación: " + comparacion);
                			
                }else if(aux.equalsIgnoreCase("Yenes")&&aux2.equalsIgnoreCase("Bitcoins")) {  
          			
         		   Moneda yen = new Yen(new BigDecimal(comp1));
         	       Moneda bitcoin = new Bitcoin(new BigDecimal(comp2));
         	       String comparacion = yen.comparar(bitcoin);
         	       System.out.println("Comparación: " + comparacion);
         	       
             	}

              	//Comparando bitcoin con:
              		
              		if(aux.equalsIgnoreCase("bitcoins")&&aux2.equalsIgnoreCase("Bolivares")) {  
              			
               		   Moneda bitcoin = new Bitcoin(new BigDecimal(comp1));
               	       Moneda Bolivares = new Bolivares(new BigDecimal(comp2));
               	       String comparacion = bitcoin.comparar(Bolivares);
               	       System.out.println("Comparación: " + comparacion);
               			
               		}else if(aux.equalsIgnoreCase("bitcoins")&&aux2.equalsIgnoreCase("Dolares")) {  
              			
                		   Moneda bitcoin = new Bitcoin(new BigDecimal(comp1));
                	       Moneda dolares = new Dolar(new BigDecimal(comp2));
                	       String comparacion = bitcoin.comparar(dolares);
                	       System.out.println("Comparación: " + comparacion);
                			
                	}else if(aux.equalsIgnoreCase("bitcoins")&&aux2.equalsIgnoreCase("euros")) {  
              			
                		   Moneda bitcoin = new Bitcoin(new BigDecimal(comp1));
                	       Moneda euro = new Euro(new BigDecimal(comp2));
                	       String comparacion = bitcoin.comparar(euro);
                	       System.out.println("Comparación: " + comparacion);
                			
                }else if(aux.equalsIgnoreCase("bitcoins")&&aux2.equalsIgnoreCase("yenes")) {  
          			
         		   Moneda bitcoin = new Bitcoin(new BigDecimal(comp1));
         	       Moneda yen = new Yen(new BigDecimal(comp2));
         	       String comparacion = bitcoin.comparar(yen);
         	       System.out.println("Comparación: " + comparacion);
         			
         	}
              		
            	
           }
         }while(Select!=3);
      }
}

