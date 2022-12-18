import com.cajablanca.editor.Editor;
import com.cajablanca.grafo.Arco;
import com.cajablanca.grafo.Grafo;
import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class GrafoTest {

    Grafo grafoVacio;
    Grafo grafoConCosas;

    @BeforeEach
    public void setup(){
        grafoVacio = new Grafo();
        grafoVacio.addVertice(0);
        grafoConCosas = new Grafo(true, false);

        grafoConCosas.addVertice(0);
        grafoConCosas.addVertice(1);
        //grafoConCosas.addVertice(2);
        //grafoConCosas.addVertice(3);
        //grafoConCosas.addVertice(4);

        grafoConCosas.addArco(new Arco(0, 1, 0));
        grafoConCosas.addArco(new Arco(1, 0, 0));
        //grafoConCosas.addArco(new Arco(0, 2, 0));
        //grafoConCosas.addArco(new Arco(1, 3, 0));
        //grafoConCosas.addArco(new Arco(1, 4, 0));
    }

    @Test
    public void printListaAdyacenteTest(){

        grafoVacio.printListaAdyacentes(0);

        //grafoConCosas.printListaAdyacentes(0);
        //grafoConCosas.printListaAdyacentes(1);
    }

    @Test
    public void todosVisitadosTest(){
        System.out.println(grafoConCosas.componentsRelated());
    }

    @Test
    public void BFSTest(){
        Assertions.assertThrows(NoSuchElementException.class, () -> {
                    grafoConCosas.BFS(96);},
                "Si el vertice no está en el grafo cómo esperas encontrarlo maquina");
        Assertions.assertEquals("[0]", grafoVacio.BFS(0),
                "para un solo nodo solo debe haber ese nodo en la anchura");
        Assertions.assertEquals("[0 1 2 3 4]", grafoConCosas.BFS(0));
    }

    @Test
    public void kruskalTest(){
        //grafoVacio.kruskal();


        //grafoVacio.addArco( new Arco(0, 0, 0));
        //grafoVacio.kruskal();

        grafoConCosas.kruskal();

        //grafoConCosas.kruskal();
    }



}
