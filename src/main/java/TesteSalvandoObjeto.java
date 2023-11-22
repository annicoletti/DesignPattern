
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nicoletti
 */
public class TesteSalvandoObjeto {

    private static final String FILE_PATH = "/home/nicoletti/teste-save-obj-java/";

    public static void main(String[] args) {
        
        pieapple();

        reflection("java.lang.String");
        reflection("java.util.ArrayList");
        reflection("java.util.List");
        reflection("java.lang.Integer");

        Scanner scan = new Scanner(System.in);

        String mensagem = "essa é a minha mensagem para salvar!!";

        byte[] saved = save(mensagem);
        recovery(saved);

        List<String> lista = new ArrayList<String>();
        lista.add("Item 1");
        lista.add("Item 2");
        lista.add("Item 3");
        lista.add("Item 4");

        Byte[] byteClass;

        byte[] savedLista = save(lista);
        recovery(savedLista);

        OneTest oneTest = new OneTest();
        oneTest.setDecimal(10.5);
        oneTest.setFullName("Objeto de teste 2");
        oneTest.setNumber(99);
        oneTest.setStatus(Boolean.TRUE);
        oneTest.setTextList(lista);

        byte[] savedObj = save(oneTest);
        recovery(savedObj);

        System.out.println("Digite o nome do arquivo para salvar:");
        String fileName = scan.nextLine();
        saveFile(oneTest, FILE_PATH + fileName.trim());

        System.out.println("Digite o nome do arquivo para abrir:");
        fileName = scan.nextLine();
        openFile(FILE_PATH + fileName.trim());

    }

    private static byte[] save(Object object) {

        byte[] data = null;

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            data = outputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("saved: " + data);
        return data;
    }

    private static void saveFile(Object object, String file) {

        byte[] data = null;

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("saved: " + file);
    }

    private static void recovery(byte[] byteArray) {

        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
            ObjectInputStream ois = new ObjectInputStream(bais);

            Object readObject = ois.readObject();

            System.out.println("open class: " + readObject.getClass());
            System.out.println("open: " + readObject);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void openFile(String file) {

        try {
            FileInputStream bais = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object readObject = ois.readObject();

            System.out.println("open class: " + readObject.getClass());
            System.out.println("open: " + readObject);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void reflection(String className) {
        try {

            Class<?> clazz = Class.forName(className);
            Object newInstance = clazz.getConstructor().newInstance();
//            Object newInstance = clazz.getConstructor(clazz.getClass()).newInstance();
//            Object newInstance = Class.forName(className).newInstance();

            System.out.println(newInstance.getClass().getName());
            System.out.println(newInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pieapple() {
        try {
            Class<?> integerClass = Integer.class;
            Constructor<?> constructor = integerClass.getConstructor(int.class);
            Object integerObject = constructor.newInstance(10); // Replace 10 with the desired value
            Integer integerValue = (Integer) integerObject;

            System.out.println("integerObject: " + integerObject);
            System.out.println("integerValue: " + integerValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
