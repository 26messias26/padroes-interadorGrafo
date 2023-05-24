package grafo.dirigido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class IteradorBFS<T> implements Iterator<Vertice<T>>{

    private Queue<Vertice<T>> filaVisita;

    public IteradorBFS(Grafo<T> grafo, Vertice vertice){
        filaVisita = new LinkedList<Vertice<T>>();

        Vertice<T> verticeRaiz = vertice;
		filaVisita.add(verticeRaiz);
		verticeRaiz.setStatus(VertexState.Visited);

    }

    @Override
    public boolean hasNext() {
        return !(filaVisita.size() == 0);
    }

    @Override
    public Vertice<T> next() {

		if (!hasNext()) {
			throw new NoSuchElementException();
		}

        Vertice<T> verticeAtual = filaVisita.remove();
		for (Aresta<T> aresta : verticeAtual.getAdj()) {
            
            Vertice<T> proximoVertice = (Vertice<T>) aresta.getDestino();
            if (!filaVisita.contains(proximoVertice)) {
                proximoVertice.setStatus(VertexState.Visited);
                filaVisita.add(proximoVertice);
            }
        }
        return verticeAtual;
    }

}
