package rpg.factory;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Clase EnemyFactory que se encarga de generar instancias aleatorias de enemigos en el juego.
 */
public class EnemyFactory {

    // Objeto Random para generar valores aleatorios
    private static final Random random = new Random();

    /**
     * Método estático que devuelve una instancia aleatoria de una subclase de Enemy.
     *
     * @return instancia de un enemigo aleatorio o null si ocurre un error.
     */
    public static Enemy getEnemy() {
        Enemy enemyInstance;  // Variable para almacenar la instancia del enemigo
        Set<Class<? extends Enemy>> enemyClasses;  // Conjunto de clases que extienden Enemy
        List<Class<? extends Enemy>> classList;    // Lista de clases filtradas

        // Configura Reflections para buscar clases en el classpath
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())  // Escanea el classpath de Java
                .setScanners(new SubTypesScanner(), new FieldAnnotationsScanner()));  // Escanea subtipos y anotaciones

        // Obtiene todas las clases que extienden Enemy
        enemyClasses = reflections.getSubTypesOf(Enemy.class);

        // Filtra las clases para obtener solo las de tipo básico
        classList = filterList(enemyClasses.stream().toList(), EnemyType.BASIC);

        try {
            int randomIndex;
            if (classList != null) {
                // Selecciona una clase aleatoria de la lista filtrada y crea una instancia
                randomIndex = random.nextInt(classList.size());
                enemyInstance = classList.get(randomIndex).getDeclaredConstructor()
                        .newInstance();  // Crea una nueva instancia del enemigo
            } else {
                throw new Exception();  // Lanza una excepción si la lista es nula
            }
        } catch (Exception e) {
            e.printStackTrace();  // Imprime el stack trace si ocurre un error
            return null;  // Retorna null en caso de error
        }
        return enemyInstance;  // Retorna la instancia del enemigo
    }

    /**
     * Método privado que filtra una lista de clases de enemigos según el tipo de enemigo.
     *
     * @param classList Lista de clases de enemigos.
     * @param enemyType Tipo de enemigo a filtrar.
     * @return Lista filtrada de clases que coinciden con el tipo de enemigo.
     */
    private static List<Class<? extends Enemy>> filterList(List<Class<? extends Enemy>> classList, EnemyType enemyType) {
        Enemy enemy;  // Variable para almacenar la instancia temporal de Enemy
        List<Class<? extends Enemy>> classListFiltered = new ArrayList<>();  // Lista filtrada

        for (Class<? extends Enemy> enemyClass : classList) {
            try {
                // Crea una instancia temporal del enemigo para verificar su tipo
                enemy = enemyClass.getDeclaredConstructor().newInstance();
                if (enemy.getType() == enemyType) {
                    // Si el tipo coincide, agrega la clase a la lista filtrada
                    classListFiltered.add(enemyClass);
                }
            } catch (Exception e) {
                return null;  // Retorna null si ocurre un error al instanciar la clase
            }
        }
        return classListFiltered;  // Retorna la lista filtrada
    }
}
