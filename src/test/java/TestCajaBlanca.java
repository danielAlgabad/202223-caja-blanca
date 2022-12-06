import com.cajablanca.editor.Editor;
import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCajaBlanca {

    Editor editorTestVacio;
    Editor editorLLeno;

    @BeforeEach
    public void setup(){
        editorTestVacio = new Editor();
        editorLLeno = new Editor();
        editorLLeno.cargarEditor("src/test/java/ficheroLleno.txt");
    }

    @Test
    public void getLineaTest() {
        Assertions.assertThrows(EmptyCollectionException.class, () -> {
                    editorTestVacio.getLinea(3);},
                "El editor vacio al que se le hace get lineas debe dar excepción");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    editorLLeno.getLinea(-1);},
                "El editor lleno al que se le hace get lineas con lineas negativas explota");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    editorLLeno.getLinea(4);},
                "El editor lleno al que se le hace get lineas con más lineas de las que tiene explota");

        AbstractSingleLinkedListImpl<String> contenidoLinea2 = new SingleLinkedListImpl<>("y");
        try {
            Assertions.assertEquals(contenidoLinea2.toString(), editorLLeno.getLinea(2).toString(),
                    "El editor con el archivo lleno debería devolver \"y le dice\n\"");
        } catch (EmptyCollectionException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void numAparicionesTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {editorTestVacio.numApariciones(0, 1, "nada");},
                "La linea de inicio no puede ser menor o igual a 0");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {editorLLeno.numApariciones(1, 4, "nada");},
                "La linea de fin no puede ser mayor que el tamaño del editor");
        Assertions.assertEquals(0, editorTestVacio.numApariciones(1, 0, "tuetano"));
        Assertions.assertEquals(0, editorLLeno.numApariciones(2, 1, "tuetano"));
        Assertions.assertEquals(0, editorLLeno.numApariciones(3, 3, "tuetano"));
        Assertions.assertEquals(0, editorLLeno.numApariciones(2, 2, "b"));
        Assertions.assertEquals(1, editorLLeno.numApariciones(2, 2, "y"));
    }

    @Test
    public void numPalabras(){
        Assertions.assertThrows(EmptyCollectionException.class, () -> {editorTestVacio.numPalabras();},
                "el editor vacio no debería tener palabras");
    }



}