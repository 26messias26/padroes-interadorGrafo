package grafo.dirigido;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class IteradorDFS<T> implements Iterator<Vertice<T>>{

	private Stack<Vertice<T>> pilhaVisita;
    
	public IteradorDFS(Grafo<T> grafo, Vertice vertice){
		pilhaVisita = new Stack();
        Vertice<T> verticeRaiz = vertice;
        pilhaVisita.push(verticeRaiz);
        verticeRaiz.setStatus(VertexState.Visited);

	}

    @Override
    public boolean hasNext() {
        return !(pilhaVisita.size() == 0);
    }

    @Override
    public Vertice<T> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Vertice<T> verticeAtual = pilhaVisita.pop();
        for (Aresta<T> aresta : verticeAtual.getAdj()) {
            
            Vertice<T> proximoVertice = (Vertice<T>) aresta.getDestino();
            if (!pilhaVisita.contains(proximoVertice)) {
                proximoVertice.setStatus(VertexState.Visited);
                pilhaVisita.push(proximoVertice);
            }
        }
        return verticeAtual;
    }

	

    
}
