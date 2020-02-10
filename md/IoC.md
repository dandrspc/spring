# __Inversión de Control (IoC) e Inyección de Dependencias__

## __Inversión de dependencias__

Para poder hablar sobre __IoC__ es necesario primero, exponer el principio de __Inversión de Dependencias (Dependency Invertion DI).__ En la programación orientada a objetos, este principio nos ayuda a definir cómo se vinculan las diferentes clases que tienen que darle servicio a otras. 

__DI__ parte de la premisa de que existen clases de alto y bajo nivel. Las clases de alto nivel son las encargas de la lógica de negocio. Por su parte, la clases de bajo nivel están ahí sólo para dar soporte a las clases de alto nivel. Este principio ayuda a que las clases estén vinculadas de la forma más desacopladas posible y establece que:  

1. Los módulos de alto nivel no deberían depender de los módulos de bajo nivel. Ambos deberían depender de abstracciones. (p.ej interfaces)  
1. Las abstracciones no deberían depender de los detalles. Los detalles (implementaciones concretas) deben depender de abstracciones.

                    Robert C. Martin

Veámos un ejemplo en código.  
Supongámos que tenemos un sistema de notificaciones donde al usuario se le deben enviar notificaciones por diferentes canales: Email, Whatsapp, SMS. 

``` 
public class Notifier() {

    private EmailSender emailSender;
    private SmsSender smsSender;
    private WhatsappSender WhatsappSender;

    public Notifier() {
        this.emailSender = new EmailSender();
        this.smsSender = new SmsSender();
        this.whatsappSender = new WhatsappSender(); 
    }

    public void notify(User user, int severity, Message msg) {
        emailSender.send(user.getEmail(), msg);

        if(severity > 1) {
            whatsappSender.send(user.getCellPhone(), smg);
        }
        if(severity == 2) {
            smsSender.send(user.getCellPhone(), smg);
        }
    }
}
```

Como vemos en el constructor tenemos una dependencia muy fuerte entre el Notifier y sus clases auxiliares, dado que estamos creando los objetos en el propio constructor de la clase Notifier. En el momento en que sea necesario cambiar la implementación de alguno de los atributos de la clase, nos veremos obligados a modificar el código en la clase Notifier. Una mejor implementación de este programa sería la siguiente: 

``` 
public Notifier(IEmailSender emailSender, ISmsSender smsSender, IWhatsappSender whatsappSender) {

        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.whatsappSender = whatsappSender;

    }
```
Como vemos, en el constructor no se crean los objetos, sino que son recibidos como parámetros. IEmailSender, ISmsSender y IWhatsappSender, ahora no son clases sino interfaces así, cualquier objeto que implemente estas interfaces puede ser recibido como parámetro y la clase seguirá funcionando. De eta manera, logramos reducir el acoplamiento entre las clases de alto nivel y las de bajo nivel.  

## __Inversión de Control (IoC)__

La inversión de control es una implementación del principio de Inversión de Dependencias. Muchas veces es llamado como el Principio de HolliWood __"No nos llames, nosotros te llamamos".__ Una definición informal de este principio es: "IoC es dejar que alguien más cree los objetos por tí". Este alguien más, es usualmente un contenedor de IoC.  
Esta simple explicación ilustra algunas ideas importantes:  

1. Es llamado IoC porque el control de los objetos se invierte. No es el programador sino alguien más quien controla los objetos.  
1. IoC es relativo en el sentido en que aplica sólo a algunos objetos de la aplicación. Puede existir inversión de control para algunos objetos mientras que otros siguen bajo total control del programador. [1]

Aunque, el control se transfiere completamente al contenedor de IoC, el programador puede influenciar cuáles objetos deben ser manejados por el controlador. Esto lo hace a través de anotaciones, de archivos de configuración o extendiendo de algunas clases espaciales. Un contenedor de IoC maneja todo el ciclo de vida de los objetos: creación, destrucción, y el momento en que son invocados. 


## __Inyección de Dependencias__

La inyección de dependencias es un patrón de diseño, subtipo de la inversión de control. El objetivo es tener un código más fácil de mantener y de probar. En este patrón de diseño un entidad externa se encarga de proveer los objetos que se necesitan para la construcción de otro objeto.  
Para ponerlo de una manera más simple. Es lo opuesto a tener las dependencias hard codeadas. 


La idea es pasar de tener esto:
``` 

public class MyClass { 
    private MyDependency myDependency = new MyDependency(); 
}
```
A esto: 
``` 
public class MyClass { 
    private MyDependency myDependency;
    public MyClass(MyDependency myDependency){
        this.myDependency = myDependency;
    }
}
```
En caso de ejemplo anterior, se trata de inyección de dependencias por medio del constructor. 

También es posible hacerlo a través de los métodos set. 
```
public class MyClass { 
    private MyDependency myDependency;
    
    public MyClass(){}

    public void setMyDependency(MyDependency myDependency)
}
```

Así, una clase externa controladora, podría hacer lo siguiente para inyectar la dependencia. 

```
public class Controller { 
    
    MyClass myClass = new MyClass(new MyDependency);
} 

o

public class Controller { 
    
    MyClass myClass = new MyClass();
    myClass.setMyDependency(new MyDependency())
} 

```
Este concepto se puede extender para el uso de interfaces en las declaraciones, de tal manera que no se dependa de la implementación de una clase en particular, sino de un comportamiento. 
___
[1: IoC vs. DI](https://dzone.com/articles/ioc-vs-di)