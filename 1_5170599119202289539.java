import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.lang.*;
import java.util.Stack;
import java.util.Queue;

 abstract class Group {
    protected List <PocketMonster> pocketMonster;

    public Group() {
         pocketMonster = new ArrayList<PocketMonster>();
    }

    public void add(PocketMonster pocketMonster) {
        this.pocketMonster.add(pocketMonster);
    }

    public PocketMonster remove() {
        if (!pocketMonster.isEmpty()) {
            return pocketMonster.remove(0);
        }
        return null;
    }

    public String show() {
        StringBuilder stringBuilder = new StringBuilder();
        for (PocketMonster pocketMonster : pocketMonster) {
            stringBuilder.append(pocketMonster.getName())
                         .append("/")
                         .append(pocketMonster.getType())
                         .append(", ");
        }
        return stringBuilder.toString();
    }
}

 interface Stackable<P>{
	    void push(P PocketMonster);
	    P pop();
	    P peek();
	    boolean isEmpty();
	    int size();
	}
 
 abstract class Stack<P> implements Stackable<P> {
    
    private Stack<P> previous; //Elemento anterior en la pila
    private P PocketMonster; //Variable que manejaremos en pila
     
    Stack() {
	}

      Stack(P PocketMonster){
        this.PocketMonster=PocketMonster; 
     }

     Stack(Stack<P> previous, P PocketMonster){
        this.previous=previous;
        this.PocketMonster=PocketMonster;
     }
     
     
     public void Push(P PocketMonster){
 		if (this.PocketMonster == null)
			this.PocketMonster = PocketMonster;
		else {
	         this.previous=new Stack <P> (this.previous, this.PocketMonster);
	         this.PocketMonster= PocketMonster;
		}
     }

     public P Pop(){
        if (this.isEmpty()){
            throw new IllegalArgumentException("Pila Vacia");
        }

        P top = this.PocketMonster;
		this.PocketMonster = this.previous.PocketMonster;
		this.previous = this.previous.previous;

		return top;
     }

     public P Peek() {
		return this.PocketMonster;
	}

    public boolean isEmpty() {
		return this.previous == null;
	}

    public int size() {
		return this.isEmpty() ? 0 : 1 + this.previous.size();
	}
    
	public String toString() {
		if (!this.isEmpty())
			return this.previous + " <- " + this.PocketMonster;
		return this.PocketMonster != null ? String.valueOf(this.PocketMonster) : "";
	}
}
 
 



 class Queue extends Group {
    private Group g[];
    private static PocketMonster First, Last;
    private static int capacity; 
    private static PocketMonster queue[]; 
    private static int front, rear;      
     
    Queue(int size) {   
        front = rear = 0;   
        capacity = size;   
        queue = new PocketMonster[capacity];   
    }   
     
     
    static void queueEnqueue(PocketMonster Pokemon)  {   
        // check if the queue is full  
        if (capacity == rear) {   
            System.out.printf("\nQueue is full\n");   
            return;   
        }   
     
        // insert element at the rear   
        else {   
            queue[rear] = Pokemon;   
            rear++;   
        }   
        return;   
    }   
     
    //remove an element from the queue  
    static void queueDequeue()  {   
        // check if queue is empty   
        if (front == rear) {   
            System.out.printf("\nQueue is empty\n");   
            return;   
        }   
     
        // shift elements to the right by one place uptil rear   
        else {   
            for (int i = 0; i < rear - 1; i++) {   
                queue[i] = queue[i + 1];   
            }   
     
         
      // set queue[rear] to null  
            if (rear < capacity)   
                queue[rear] = null;   
     
            // decrement rear   
            rear--;   
        }   
        return;   
    }   
     
    // print queue elements   
    static void queueDisplay()   
    {   
        int i;   
        if (front == rear) {   
            System.out.printf("Queue is Empty\n");   
            return;   
        }   
     
        // traverse front to rear and print elements   
        for (i = front; i < rear; i++) {   
            System.out.printf(" %d , ", queue[i]);   
        }   
        return;   
    }   
     
    // print front of queue   
    static void queueFront()   
    {   
        if (front == rear) {   
            System.out.printf("Queue is Empty\n");   
            return;   
        }   
        System.out.printf("\nFront Element of the queue: %d", queue[front]);   
        return;   
    }   

  
}

 class PocketMonster {
    private String type;
    private String name;

    public PocketMonster(String type, String name) {
        this.type = type;
        this.name = name;
    }

    // Getters y setters

    public String getName(){
        return name;
    }

    public void setName(String n){
        name=n;
    }

    public String getType(){
        return type;
    }

    public void setType(String t){
        type=t;
    }

}



public class fileReader {

	public static void main(String[] args) {
        int Select, Select2=0;
        Group PokedexS=null, PokedexQ=null;
        PocketMonster pokemon=null;
        Queue EquipoCola;
        Stack EquipoStack;
        Scanner teclado=new Scanner(System.in), capt=new Scanner(System.in);
        System.out.println("Bienvenido al Pokedex");
        System.out.println("Seleccione la opcion deseada");
        
        do {

            System.out.println("1 - Crear Pokedex Stack");
            System.out.println("2 - Crear Pokedex Cola");
            System.out.println("3 - Crear Equipo Stack");
            System.out.println("4 - Crear Equipo Cola");
            System.out.println("5 - Mostrar Equipo Stack");
            System.out.println("6 - Mostrar Equipo Cola");
            System.out.println("7 - Encuentro");
            System.out.println("8-Terminar");

            Select=Integer.parseInt(teclado.next());
            
            switch(Select) {
            case 1:
            	while(Select2<=2) {
            		System.out.println("Pokedex Stack");
                    System.out.println("1 - Ingresar Pokemon y Su tipo");
                    System.out.println("2 - Mostrar Pokedex");
                    System.out.println("3 - Volver a Menu Principal");
            		Select2=Integer.parseInt(teclado.next());
            		if(Select2==1) {
            			System.out.println("Nombre del Pokemon:");
            			pokemon.setName(capt.nextLine());
            			System.out.println("Tipo:");
            			pokemon.setType(capt.nextLine());
            			PokedexS.add(pokemon);
            		}else if(Select2==2) {
            			PokedexS.show();
            		}
            	}
            	break;
            case 2:
            	while(Select2<=2) {
            		System.out.println("Pokedex Cola");
                    System.out.println("1 - Ingresar Pokemon y Su tipo");
                    System.out.println("2 - Mostrar Pokedex");
                    System.out.println("3 - Volver a Menu Principal");
            		Select2=Integer.parseInt(teclado.next());
            		if(Select2==1) {
            			System.out.println("Nombre del Pokemon:");
            			pokemon.setName(capt.nextLine());
            			System.out.println("Tipo:");
            			pokemon.setType(capt.nextLine());
            			PokedexQ.add(pokemon);
            		}else if(Select2==2) {
            			PokedexQ.show();
            		}
            	}
				break;
		   case 3:		   	
              public class EquipoStack {
              private Stack<Pokemon> stack;

              public EquipoStack() {
              stack = new Stack<>();
              }

              public void add(Pokemon pokemon) {
              stack.push(pokemon);
              }

             public Pokemon remove() {
             return stack.pop();
             }

             public boolean isEmpty() {
             return stack.isEmpty();
             }

            public void show() {
            System.out.println("Equipo Stack:");
            for (Pokemon pokemon : stack) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType());
              }
             }
            }
			break;
		case 4:
		   public class EquipoQueue {
            private Queue<Pokemon> queue;

           public EquipoQueue() {
           queue = new LinkedList<>();
           }

           public void add(Pokemon pokemon) {
           queue.add(pokemon);
           }

          public Pokemon remove() {
          return queue.remove();
          }

          public boolean isEmpty() {
          return queue.isEmpty();
          }

         public void show() {
         System.out.println("Equipo Queue:");
         for (Pokemon pokemon : queue) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType());
            }
           }
          }
		  break;
      case 5:
        System.out.println("Equipo Stack:");
        for (Pokemon pokemon : stack) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType());
           }
           break;
		   
	  case 6:
	    public void show() {
          System.out.println("Equipo Queue:");
            for (Pokemon pokemon : queue) {
             System.out.println(pokemon.getName() + " - " + pokemon.getType());
             }
            }
           break;   
      case 7:
		   	private static void encounter(Pokemon p1, Pokemon p2) {
             if (p1.getType().equalsIgnoreCase(p2.getWeakness())) {
                System.out.println(p1.getName() + " derrotó a " + p2.getName() + " porque es resistente a " + p2.getWeakness());
             } else if (p2.getType().equalsIgnoreCase(p1.getWeakness())) {
                System.out.println(p2.getName() + " derrotó a " + p1.getName() + " porque es resistente a " + p1.getWeakness());
             } else {
                System.out.println("Empate entre " + p1.getName() + " y " + p2.getName());
    }
}
        }while (Select!=8); 

        if (args.length > 0) {
           String fileName = args[0];
            try {
                BufferedReader bufferedReader = new BufferedReader (new FileReader(fileName));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    processInstruction(line);
                }
                bufferedReader.close();
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("Debe proporcionar el nombre del archivo.");
        }
    }

    private static void processInstruction(String instruction) {
        // Lógica para procesar las instrucciones aquí
    }
}



/*public class testing {

		public static void main (String[] args) {
			System.out.print("Hello ");
			System.out.print("Java");
		}
}*/
