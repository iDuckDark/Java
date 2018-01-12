
public class GameStack implements Stack<DotInfo> {


    private int top;

    public DotInfo[] gamestack;
    
    private int size;

    public GameStack(int size){
        this.size=size;
        top=0;
        gamestack = new DotInfo[size*size];
    }
    public boolean isEmpty(){
        return (top==0);
    }

    public DotInfo peek(){
        return (gamestack[top-1]);
    }
    public DotInfo pop(){
        DotInfo saved = gamestack[ --top ];

        gamestack[ top ] = null;

        return saved;
    }
    public void push( DotInfo element ){
          gamestack[ top++ ] = element;
    }
    public DotInfo[] getStack(){
        return gamestack;
    }

}