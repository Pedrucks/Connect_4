package programa;
import java.util.Scanner;

public class Programa {
    
    public static class Juego{
    
        private int filas;
        private int columnas;
        private int tablero[][];

        public Juego(int filas, int columnas) {
            
            this.filas = filas;
            this.columnas = columnas;
            
            tablero = new int[filas][columnas];
            
            for(int i = 0; i < filas; i++){
                
                for(int j = 0; j < columnas; j++){
                    
                    tablero[i][j] = 0;
                    
                }
                
            }
            
        }
        
        public boolean PosicionCorrecta(int posicion){
            
            boolean resultado = true;
            int contador = 0;
            
            for(int i = 0; i < filas; i++){
                
                if(tablero[i][posicion - 1] == 0){
                    
                    contador++;
                    
                }
                
            }
            
            if(contador == 0){
                
                resultado = false;
                
            }
            
            return resultado;
            
        }
        
        public void Movimiento(int jugador, int posicion){
            
            for(int i = filas - 1; i >= 0; i--){
                
                if(tablero[i][posicion - 1] == 0){
                    
                    tablero[i][posicion - 1] = jugador;
                    i = -1;
                    
                }
                
            }
            
        }
        
        public int Fin(){
            
            boolean resultado = false;
            int contador = 0;
            int aux = 0;
            int ganador = 0;
            
            for(int i = 0; i < filas; i++){
                
                for(int j = 0; j < columnas; j++){
                    
                    if(tablero[i][j] == 0){
                        
                        contador ++;
                        
                    }
                    
                }
                
            }
            
            if(contador == 0){
                
                ganador = -1;
                
            }
            
            for(int i = 0; i < filas; i++){ //Comprobar que hay 4 en horizontal
                
                for(int j = 0; j < columnas - 1; j++){
                    
                    if(tablero[i][j] == tablero[i][j + 1] && tablero[i][j] != 0){
                        
                        aux ++;
                                
                        
                    }else{
                        
                        aux = 0;
                        
                    }
                    
                    if(aux >= 3){
                        
                        ganador = tablero[i][j];
                        i = filas;
                        j = columnas;
                        
                    }
                    
                } 
                
                aux = 0;
                
            }
            
            for(int j = 0; j < columnas; j++){ //Comprobar que hay 4 en vertical
                
                for(int i = 0; i < filas - 1; i++){
                    
                    if(tablero[i][j] == tablero[i + 1][j] && tablero[i][j] != 0){
                        
                        aux ++;
                                
                    }else{
                        
                        aux = 0;
                        
                    }
                    
                    if(aux >= 3){
                        
                        ganador = tablero[i][j];
                        i = filas;
                        j = columnas;
                        
                    }
                    
                }
                
                aux = 0;
                
            }
            
            for(int i = 0; i < filas - 3; i++){ //Comprobar que hay 4 en diagonal de izquierda a derecha;
                
                for(int j = 0; j < columnas - 3; j++){
                    
                    if(tablero[i][j] == tablero[i + 1][j + 1] && tablero[i + 1][j + 1] == tablero[i + 2][j + 2] &&
                            tablero[i + 2][j + 2] == tablero[i + 3][j + 3] && tablero[i][j] != 0){
                        
                        ganador = tablero[i][j];
                        i = filas;
                        j = columnas;
                        
                    }
                    
                }
                
            }
            
            for(int i = 0; i < filas - 3; i++){
                
                for(int j = columnas - 1; j > 2; j--){
                    
                    if(tablero[i][j] != 0 && tablero[i][j] == tablero[i + 1][j - 1] && tablero[i][j] == tablero[i + 2][j - 2] &&
                            tablero[i][j] == tablero[i + 3][j - 3]){
                       
                        ganador = tablero[i][j];
                        i = filas;
                        j = columnas;
                        
                    }
                    
                }
                
            }
            
            
            return ganador;
            
        }
        
        public void Mostrar(){
            
            for(int i = 0; i < filas; i++){
                
                for(int j = 0; j < columnas; j++){
                    
                    if(tablero[i][j] == 0){
                        
                        System.out.print("\u001B[30m" + tablero[i][j]+"     ");
                        
                    }else if(tablero[i][j] == 1){
                        
                        System.out.print("\u001B[31m" + tablero[i][j]+"     ");
                        
                    }else if(tablero[i][j] == 2){
                        
                        System.out.print("\u001B[32m" + tablero[i][j]+"     ");
                        
                    }else if(tablero[i][j] == 3){
                        
                        System.out.print("\u001B[33m" + tablero[i][j]+"     ");
                        
                    }else if(tablero[i][j] == 4){
                        
                        System.out.print("\u001B[34m" + tablero[i][j]+"     ");
                        
                    }else if(tablero[i][j] == 5){
                        
                        System.out.print("\u001B[35m" + tablero[i][j]+"     ");
                        
                    }else if(tablero[i][j] == 6){
                        
                        System.out.print("\u001B[36m" + tablero[i][j]+"     ");
                        
                    }
                    
                }
                
                System.out.println("\n");
                
            }
            
            System.out.println("");
            
            for(int i = 1; i < columnas + 1; i++){
                
                System.out.print(i+"     ");
                
            }
            
        }           
        
    }

    public static void main(String[] args) {
        
        int fil = 0;
        int col = 0;
        int jugadores = 0;
        int aux = 1;
        int direccion = 0;
        boolean GameOver = false;
        Scanner datos = new Scanner(System.in);
       
        System.out.println("CONNECT 4 by Pedrucks");
        
        System.out.print("Introduzca el número de filas y columnas de su tablero: ");
        fil = datos.nextInt();
        col = datos.nextInt();
        
        while(fil < 4 || col < 4){
            
            System.out.println("Datos mal introducidos, introduzca de nuevo sus filas y columnas: ");
            fil = datos.nextInt();
            col = datos.nextInt();
        }
        
        System.out.print("\nIntroduzca el número de jugadores (entre 1 y 6): ");
        jugadores = datos.nextInt();
        
        while(jugadores < 1 || jugadores > 6){
            
            System.out.println("\nNúmero de jugadores no válido, introduzca de nuevo su dato: ");
            jugadores = datos.nextInt();
        }
        
        Juego j1 = new Juego(fil, col);
        
        while(GameOver == false){
            
            System.out.println("");
            
            j1.Mostrar();
             
            System.out.println("\n");
            
            System.out.print("Introduzca la columna donde desea introducir su ficha, jugador "+aux+": ");
            
            direccion = datos.nextInt();
            
            while(direccion < 1 || direccion > col){
                
                System.out.print("Posición incorrecta, elija una posición válida: ");
                direccion = datos.nextInt();
                
            }
            
            while(j1.PosicionCorrecta(direccion) == false){
                
                System.out.println("\n");
            
                System.out.print("Movimiento incorrecto, Introduzca una columna donde pueda introducir su ficha, jugador "+aux+": ");
            
                direccion = datos.nextInt();
            
                while(direccion < 1 || direccion > col){
                
                    System.out.print("Posición incorrecta, elija una posición válida: ");
                    direccion = datos.nextInt();
                
                }
                
            }
            
            j1.Movimiento(aux, direccion);
            
            aux++;
            
            if(aux > jugadores){
                
                aux = 1;
                
            }
            
            if(j1.Fin() > 0){
                
                GameOver = true;
                
            }else if(j1.Fin() < 0){
                
                GameOver = true;
                
            }else{
                
                GameOver = false;
                
            }
            
            
        }
        
        System.out.println("");
        
        j1.Mostrar();
        
        if(j1.Fin() > 0){
                
            System.out.println("\n\nGANADOR JUGADOR: "+j1.Fin());
                
        }else if(j1.Fin() < 0){
                
            System.out.println("\n\nNO HAY GANADOR");
                
        }
        
    }
    
}
