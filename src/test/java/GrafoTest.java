import com.cajablanca.editor.Editor;
import com.cajablanca.grafo.Arco;
import com.cajablanca.grafo.Grafo;
import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrafoTest {

    Grafo grafoVacio;
    Grafo grafoConCosas;

    @BeforeEach
    public void setup(){
        grafoVacio = new Grafo();
        grafoConCosas = new Grafo(true, false);
        grafoConCosas.addVertice(0);
        grafoConCosas.addVertice(1);
        grafoConCosas.addVertice(2);
        grafoConCosas.addArco(new Arco(2, 1, 0));
        grafoConCosas.addArco(new Arco(0, 1, 0));
    }

    @Test
    public void printListaAdyacenteTest(){
        grafoConCosas.printListaAdyacentes(0);
        grafoConCosas.printListaAdyacentes(1);
    }

    @Test
    public void todosVisitadosTest(){

        grafoConCosas.componentsRelated();



    }
}
