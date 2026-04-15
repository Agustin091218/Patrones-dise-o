# Patrones de Diseño de Software

## Estudio de tres patrones: Strategy, Facade y Template Method

Este documento resume tres patrones de diseño estudiados: **Strategy**, **Facade** y **Template Method**.

---

## 1. Patrón Strategy

### ¿Qué es?
El patrón **Strategy** define una familia de algoritmos, los encapsula en clases separadas y los hace intercambiables entre sí. Permite que el algoritmo utilizado por un objeto pueda variar de forma independiente al cliente que lo usa.

Es útil cuando se necesita alternar entre distintas variantes de un mismo comportamiento sin modificar el código cliente.

### Clasificación
**Patrón de Comportamiento (GoF)**  
Reemplaza la herencia por composición para variar algoritmos en tiempo de ejecución.

### ¿Cómo se utiliza?
Se basa en tres componentes principales:

1. **Interfaz Strategy**: declara un método común que deben implementar todas las estrategias concretas.
2. **Estrategias concretas**: implementan la interfaz con una lógica específica.
3. **Contexto**: mantiene una referencia a una estrategia y delega en ella la ejecución del algoritmo.

### Ejemplo en Java
```java
// 1. Interfaz Strategy
interface EstrategiaDescuento {
    double aplicar(double precio);
}

// 2. Estrategias concretas
class SinDescuento implements EstrategiaDescuento {
    public double aplicar(double precio) { 
        return precio; 
    }
}

class DescuentoNavidad implements EstrategiaDescuento {
    public double aplicar(double precio) { 
        return precio * 0.80; 
    }
}

// 3. Contexto
class Carrito {
    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento e) {
        this.estrategia = e;
    }

    public double calcularTotal(double precio) {
        return estrategia.aplicar(precio);
    }
}
```

---

## 2. Patrón Facade

### ¿Qué es?
El patrón **Facade** proporciona una interfaz unificada y simplificada a un conjunto de interfaces más complejas en un subsistema. Actúa como un "frente" o "fachada" que oculta la complejidad interna y facilita el uso del sistema completo.

Es útil cuando se trabaja con bibliotecas o sistemas con muchas dependencias, y se necesita una forma simple de acceder a las funcionalidades más usadas.

### Clasificación
**Patrón Estructural (GoF)**  
Abstrae la complejidad de un subsistema completo tras una interfaz simple.

### ¿Cómo se utiliza?
El patrón cuenta con dos roles principales:

1. **Fachada**: conoce las clases del subsistema y delegar las solicitudes del cliente en los objetos apropiados. Es el único punto de contacto con el subsistema.
2. **Clases del subsistema**: implementan la funcionalidad real del sistema. Manejan el trabajo asignado por la Fachada y no tienen conocimiento de ella.

### Ejemplo en Java
```java
// Clases del subsistema interno
class CPU {
    public void freeze() { /*...*/ }
    public void jump(long pos) { /*...*/ }
    public void execute() { /*...*/ }
}

class Memory {
    public void load(long position, byte[] data) { /*...*/ }
}

class HardDrive {
    public void read(long lba, int size) { /*...*/ }
}

// Fachada
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() {
        cpu.freeze();
        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }
}

// Uso simple desde el cliente
class Cliente {
    public static void main(String[] args) {
        ComputerFacade computadora = new ComputerFacade();
        computadora.start(); // Interfaz simple
    }
}
```

---

## 3. Patrón Template Method

### ¿Qué es?
El patrón **Template Method** define el esqueleto de un algoritmo en una clase base, delegando algunos pasos a las subclases. Permite que las subclases redefinan ciertos pasos del algoritmo sin cambiar su estructura global.

Es útil cuando se tienen algoritmos con una estructura común pero con variaciones en ciertos pasos específicos.

### Clasificación
**Patrón de Comportamiento (GoF)**  
Define la estructura de un algoritmo y permite que las subclases modifiquen ciertos pasos.

### ¿Cómo se utiliza?
Intervienen dos componentes:

1. **Clase Abstracta**: define los métodos abstractos que las subclases deben implementar, y contiene un método plantilla que invoca a estos métodos en un orden determinado.
2. **Clase Concreta**: implementa los métodos abstractos definido en la clase padre para realizar los pasos específicos del algoritmo.

### Ejemplo en Java
```java
// Clase abstracta con el método plantilla
abstract class DataMiner {
    // Método plantilla (no se debe sobrescribir)
    public final void mine(String path) {
        String file = openFile(path);
        String data = extractData(file);
        String[] parsed = parseData(data);
        analyzed(parsed);
        sendReport();
    }

    // Pasos que las subclases deben implementar
    protected abstract String openFile(String path);
    protected abstract String extractData(String file);
    protected abstract String[] parseData(String data);
    protected abstract void analyzed(String[] data);
    protected abstract void sendReport();
}

// Implementaciones concretas
class PDFDataMiner extends DataMiner {
    protected String openFile(String path) { /* lógica para PDF */ }
    protected String extractData(String file) { /* lógica para PDF */ }
    protected String[] parseData(String data) { /* lógica para PDF */ }
    protected void analyzed(String[] data) { /* lógica */ }
    protected void sendReport() { /* lógica */ }
}

class CSVDataMiner extends DataMiner {
    protected String openFile(String path) { /* lógica para CSV */ }
    protected String extractData(String file) { /* lógica para CSV */ }
    protected String[] parseData(String data) { /* lógica para CSV */ }
    protected void analyzed(String[] data) { /* lógica */ }
    protected void sendReport() { /* lógica */ }
}
```

---

## Resumen Comparativo

| Patrón | Propósito | Tipo |
|--------|----------|------|
| **Strategy** | Intercambiar algoritmos en runtime | Comportamiento |
| **Facade** | Simplificar acceso a sistemas complejos | Estructural |
| **Template Method** | Definir estructura de algoritmo con pasos variables | Comportamiento |